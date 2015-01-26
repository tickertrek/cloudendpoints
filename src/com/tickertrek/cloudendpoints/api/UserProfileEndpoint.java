package com.tickertrek.cloudendpoints.api;

import com.tickertrek.cloudendpoints.EMF;
import com.tickertrek.cloudendpoints.entity.UserProfile;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "userprofileendpoint", namespace = @ApiNamespace(ownerDomain = "tickertrek.com", ownerName = "tickertrek.com", packagePath = "cloudendpoints.entity"))
public class UserProfileEndpoint {

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
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getUserProfile")
	public UserProfile getUserProfile(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		UserProfile userprofile = null;
		try {
			userprofile = mgr.find(UserProfile.class, id);
		} finally {
			mgr.close();
		}
		return userprofile;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param userprofile the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertUserProfile")
	public UserProfile insertUserProfile(UserProfile userprofile) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsUserProfile(userprofile)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(userprofile);
		} finally {
			mgr.close();
		}
		return userprofile;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param userprofile the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateUserProfile")
	public UserProfile updateUserProfile(UserProfile userprofile) {
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
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeUserProfile")
	public void removeUserProfile(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			UserProfile userprofile = mgr.find(UserProfile.class, id);
			mgr.remove(userprofile);
		} finally {
			mgr.close();
		}
	}

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

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
