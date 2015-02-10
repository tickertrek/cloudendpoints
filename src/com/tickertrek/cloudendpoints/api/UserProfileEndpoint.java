package com.tickertrek.cloudendpoints.api;

import com.tickertrek.cloudendpoints.EMF;
import com.tickertrek.cloudendpoints.entity.AuthToken;
import com.tickertrek.cloudendpoints.entity.Registration;
import com.tickertrek.cloudendpoints.entity.UserAuth;
import com.tickertrek.cloudendpoints.entity.UserProfile;
import com.tickertrek.cloudendpoints.exception.BullFinderException;
import com.tickertrek.cloudendpoints.mail.MailTransport;
import com.tickertrek.cloudendpoints.util.Constants;
import com.tickertrek.cloudendpoints.util.Utilities;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


@Api(name = "userprofileendpoint", namespace = @ApiNamespace(ownerDomain = "tickertrek.com", ownerName = "tickertrek.com", packagePath = "cloudendpoints.entity"))
public class UserProfileEndpoint {
	//private Log loger = LogFactory.getLog(getClass());
	
	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listUserProfile")
	public CollectionResponse<UserProfile> listUserProfile(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<UserProfile> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr
					.createQuery("select from UserProfile as UserProfile");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<UserProfile>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (UserProfile obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<UserProfile> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param userprofile the entity to be updated.
	 * @return The updated entity.
	 */
	/*@ApiMethod(name = "updateUserProfile")
	public UserProfile updateUserProfile(UserProfile userprofile, AuthToken token) throws Exception {
		if (isAuthenticated(token)) {
			throw new BullFinderException(Constants.ExceptionCode.UNAUTHENTICATED_USER_ERROR,
	                "Operation requires Authentication");
		}
		EntityManager mgr = getEntityManager();
		try {
			if (!containsUserProfile(userprofile)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(userprofile);
		} finally {
			mgr.close();
		}
		return userprofile;
	}*/

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeUserProfile")
	public void removeUserProfile(@Named("email") String email, AuthToken token) throws Exception {
		if (isAuthenticated(token)) {
			throw new BullFinderException(Constants.ExceptionCode.UNAUTHENTICATED_USER_ERROR,
	                "Operation requires Authentication");
		}		
		EntityManager mgr = getEntityManager();
		try {
			UserProfile userprofile = this.getUserProfileByEmail(email);
			mgr.remove(userprofile);
		} finally {
			mgr.close();
		}
	}
	
	/**
     * This method registers user with the given code. From the code it retrieves the user info from the
     * database. and then registers to the auth table. Finally the method returns the user
     * profile object for log in purpose
     * @param registerCode
     * @return
     * @throws Exception
     */
	@ApiMethod(name = "registerAndLoginUserWithCode")
    public AuthToken registerAndLoginUserWithCode(@Named("registerCode") String registerCode) 
    		throws Exception {
        //loger.info("Trying to register user");
        
        EntityManager mgr = getEntityManager();
        Registration reg = null;
		try {
			Query q = mgr.createQuery("select c from " + Registration.class.getName() + 
			        " c where c.code = :p1");
			q.setParameter("p1", registerCode);		
			reg = (Registration) q.getSingleResult();
			
			Date codeDate = reg.getCreateDate();
	        Date currentDate = new Date(System.currentTimeMillis());
			if((codeDate.getTime()+Constants.A_DAY_IN_MILLISEC) < currentDate.getTime()) {
				mgr.remove(reg);
	            throw new BullFinderException(Constants.ExceptionCode.REGISTRATION_CODE_EXPIRED_ERROR,
	                Constants.ExceptionCode.REGISTRATION_CODE_EXPIRED_ERROR_MSG);
	        }
			if (this.getUserProfileByEmail(reg.getEmail()) != null)
	            throw new BullFinderException(Constants.ExceptionCode.REGISTRATION_USER_EMAIL_EXISTS_ERROR,
	                Constants.ExceptionCode.REGISTRATION_USER_EMAIL_EXISTS_ERROR_MSG);
			
			UserProfile userProfile = new UserProfile();
			userProfile.setEmail(reg.getEmail());
			userProfile.setUserName(reg.getUserName());
			persist(userProfile);
			
			UserAuth userAuth = new UserAuth();
			userAuth.setEmail(reg.getEmail());
			userAuth.setUserName(reg.getUserName());
			userAuth.setPassword(reg.getPassword());
			persist(userAuth);
			mgr.remove(reg);
			return this.getCustomAuthToken(reg.getEmail(), reg.getUserName());			
		} catch (NoResultException e) {
			throw new BullFinderException(e, Constants.ExceptionCode.REGISTRATION_CODE_DOES_NOT_EXIST_ERROR,
                    Constants.ExceptionCode.REGISTRATION_CODE_DOES_NOT_EXIST_ERROR_MSG);
		} finally {
			mgr.close();
		}
    }
    
    private String createRegitrationCode(String email, 
    									 String encryptedPassword,
    									 String userName) throws Exception {
    	
        if (this.getUserProfileByEmail(email) != null)
            throw new BullFinderException(Constants.ExceptionCode.REGISTRATION_USER_EMAIL_EXISTS_ERROR,
                Constants.ExceptionCode.REGISTRATION_USER_EMAIL_EXISTS_ERROR_MSG);
        if (this.getUserProfileByUserName(userName) != null)
            throw new BullFinderException(Constants.ExceptionCode.REGISTRATION_USER_NICKNAME_EXISTS_ERROR,
                Constants.ExceptionCode.REGISTRATION_USER_NICKNAME_EXISTS_ERROR_MSG);

        
        String code = Utilities.generateRandomRegistrationCode(email, userName);
        Date currentDate = new Date(System.currentTimeMillis());
        
        EntityManager mgr = getEntityManager();
		try {
			Registration reg = new Registration();
			reg.setEmail(email);
			reg.setUserName(userName);
			reg.setPassword(encryptedPassword);
			reg.setCreateDate(currentDate);
			reg.setCode(code);
			mgr.persist(reg);
		} finally {
			mgr.close();
		}
        return code;
    }
    
    private AuthToken getCustomAuthToken(String email, String userName) {
    	EntityManager mgr = getEntityManager();
    	AuthToken token = null;
    	Date currentDate = new Date(System.currentTimeMillis());
    	try {
			Query q = mgr.createQuery("select c from " + AuthToken.class.getName() + 
			        " c where c.email = :p1 and c.userName = :p2");
			q.setParameter("p1", email);
			q.setParameter("p2", userName);
			token = (AuthToken) q.getSingleResult();
			token.setCreateDate(currentDate);
			mgr.persist(token);
    	} catch (NoResultException e) {
			// Do nothing
		} finally {
			mgr.close();
		}
    	if (token == null) {
	    	String code = Utilities.generateRandomCode(email, userName);	    	
	        token = new AuthToken();
	        token.setEmail(email);
	        token.setUserName(userName);
	        token.setUserToken(code);
	        token.setTokenType(Constants.TokenType.CUSTOM_TOKEN_TYPE);
	        token.setCreateDate(currentDate);
	        persist(token);
    	}
        return token;
    }
    
    
    @ApiMethod(name = "authenticateUser")
    public AuthToken authenticateUser(@Named("email") String emailOrUserName, 
    								  @Named("password") String password) 
    								  throws Exception {
    	
    	EntityManager mgr = getEntityManager();
		UserAuth userAuth = null;
		try {
			Query q = mgr.createQuery("select c from " + UserAuth.class.getName() + 
			        " c where c.email = :p1 and c.password = :p2");
			q.setParameter("p1", emailOrUserName);
			q.setParameter("p2", Utilities.encryptPassword(password));
		
			userAuth = (UserAuth) q.getSingleResult();
			if (userAuth.getEmail() == null || userAuth.getUserName() == null)
				throw new Exception("User id/email is null after login.");
		} catch (Exception e) {
			throw new BullFinderException(e, Constants.ExceptionCode.LOGIN_USER_EMAIL_AND_PASSWORD_NOT_MATCH_ERROR,
                    Constants.ExceptionCode.LOGIN_USER_EMAIL_AND_PASSWORD_NOT_MATCH_ERROR_MSG);
		} finally {
			mgr.close();
		}
		
		return this.getCustomAuthToken(userAuth.getEmail(), userAuth.getUserName());		       
    }
    
    @ApiMethod(name = "initializeCustomRegistration")
    public void initializeCustomRegistration(@Named("email") String email, 
    									     @Named("password") String password,
    									     @Named("userName") String userName)
            throws Exception {
        //loger.info("Initializing user for registration.");
        if (email == null || email.isEmpty()) {
        	throw new BullFinderException(Constants.ExceptionCode.GENERIC_ERROR_FORM_FILED_NULL_ERROR,
                    "Empty email address.");
        }
        if (userName == null || userName.isEmpty()) {
        	throw new BullFinderException(Constants.ExceptionCode.GENERIC_ERROR_FORM_FILED_NULL_ERROR,
                    "Empty user name.");
        }
        if (password == null || password.isEmpty()) {
        	throw new BullFinderException(Constants.ExceptionCode.GENERIC_ERROR_FORM_FILED_NULL_ERROR,
                    "Invalid password.");
        }
        String code = this.createRegitrationCode(email, Utilities.encryptPassword(password), userName);

        MailTransport.sendRegistrationLinkeMail(code, email);
    }

    /*public void initializeForgotPassword(String email, String fullname)
            throws Exception{
        loger.info("Initializing forgot password.");

        String code = this.createForgotPasswordCode(email, fullname);

        MailTransport.sendForgotPasswordLinkeMail(code, email);
    }*/
    
	private boolean containsUserProfile(UserProfile userprofile) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			UserProfile item = mgr
					.find(UserProfile.class, userprofile.getKey());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}
	
	private UserProfile getUserProfileByUserName(String userName) {
		EntityManager mgr = getEntityManager();
		UserProfile item = null;
		try {
			Query q = mgr.createQuery("select c from " + UserProfile.class.getName() + 
			        " c where c.userName = :p1");
			q.setParameter("p1", userName);		
			item = (UserProfile) q.getSingleResult();
		} catch (Exception e) {
			return null;
		} finally {
			mgr.close();
		}
		return item;
	}
	
	private UserProfile getUserProfileByEmail(String email) {
		EntityManager mgr = getEntityManager();
		UserProfile item = null;
		try {
			Query q = mgr.createQuery("select c from " + UserProfile.class.getName() + 
			        " c where c.email = :p1");
			q.setParameter("p1", email);
		
			item = (UserProfile) q.getSingleResult();
		} catch (Exception e) {
			return null;
		} finally {
			mgr.close();
		}
		return item;
	}
	
	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}
	
	private void persist(Object obj) {
		EntityManager mgr = getEntityManager();
		try {
			mgr.persist(obj);
		} finally {
			mgr.close();
		}
	}
	
	private boolean isAuthenticated(AuthToken token) {
		EntityManager mgr = getEntityManager();
    	Date currentDate = new Date(System.currentTimeMillis());
    	try {
			Query q = mgr.createQuery("select c from " + AuthToken.class.getName() + 
			        " c where c.email = :p1 and c.userName = :p2 and c.userToken = :p3");
			q.setParameter("p1", token.getEmail());
			q.setParameter("p2", token.getUserName());
			q.setParameter("p3", token.getUserToken());
			token = (AuthToken) q.getSingleResult();
			token.setCreateDate(currentDate);
			mgr.persist(token);
			return true;
    	} catch (NoResultException e) {
			return false;
		} finally {
			mgr.close();
		}
	}
}
