package com.tickertrek.cloudendpoints.mail;


import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import java.util.logging.Logger;
import com.tickertrek.cloudendpoints.util.Constants;

/**
 *
 * @author Uttam
 */
public class MailTransport {
	private static final Logger logger = Logger.getLogger(MailTransport.class.getName());
    private static Session session;
    static{
        Properties props = new Properties();

        //Add the SMTP host address.
        //props.put("mail.smtps.host", Constants.SMTP_HOST_ADDR);
        //props.put("mail.smtps.auth", "true");//"true");
        // Get a Session object
	session = Session.getInstance(props, null);        
    }



    public static void sendRegistrationSuccessfuleMail(String email) throws Exception{

        String mail = "Dear User, you have successfully registered in TickerTrek. Thank you for choosing TickerTrek";

        session.setDebug(true);


        // construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(Constants.FROM_ADDR_FOR_USER_EMAIL,
                Constants.FROM_NAME_FOR_USER_EMAIL));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        msg.setSubject(Constants.RESGISTRATION_SUCESS_EMAIL_SUBJECT);

        StringBuilder sb = new StringBuilder();
        sb.append("<HTML>\n");
        sb.append("<HEAD>\n");
        sb.append("<TITLE>\n");
        sb.append(Constants.RESGISTRATION_SUCESS_EMAIL_SUBJECT + "\n");
        sb.append("</TITLE>\n");
        sb.append("</HEAD>\n");

        sb.append("<BODY>\n");
        sb.append("<H1>" + Constants.RESGISTRATION_SUCESS_EMAIL_SUBJECT + "</H1>" + "\n");

        sb.append(mail);
        sb.append("</BODY>\n");
        sb.append("</HTML>\n");

        msg.setDataHandler(new DataHandler(
            new ByteArrayDataSource(sb.toString(), "text/html")));
        msg.setSentDate(new Date());

        msg.saveChanges();
        // send the thing off
        Transport.send(msg);
        //Transport transport = session.getTransport(Constants.SMTP_HOST_TRANSPORT_PROVIDER);
        //transport.connect(Constants.SMTP_HOST_ADDR, Constants.FROM_ADDR_FOR_USER_EMAIL,
        //        Constants.SMTP_PASSWORD);
        //transport.sendMessage(msg, msg.getAllRecipients());
        //transport.close();

        logger.info(mail);
        
    }

    public static void sendRegistrationLinkeMail(String code, String email) throws Exception{
        String mail = "Dear User, please click on the link below to confirm the registration process in TickerTrek"
                + "<a href=\""+Constants.WEBISTE_HOST_NAME_WITH_CONTEXT+"/registeruser?action=registrationconfirm&"
                +Constants.REGISTRATION_CODE_KEY+"="+code+"\"> "
                +Constants.WEBISTE_HOST_NAME_WITH_CONTEXT+"/registeruser?action=registrationconfirm&" +Constants.REGISTRATION_CODE_KEY+"="+code+"</a> <br><br>"
                + "Please confirm your registration within 24 hours, otherwise the link will expire.";

        session.setDebug(true);


        // construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(Constants.FROM_ADDR_FOR_USER_EMAIL,
                Constants.FROM_NAME_FOR_USER_EMAIL));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        msg.setSubject(Constants.RESGISTRATION_LINK_EMAIL_SUBJECT);

        StringBuilder sb = new StringBuilder();
        sb.append("<HTML>\n");
        sb.append("<HEAD>\n");
        sb.append("<TITLE>\n");
        sb.append(Constants.RESGISTRATION_LINK_EMAIL_SUBJECT + "\n");
        sb.append("</TITLE>\n");
        sb.append("</HEAD>\n");

        sb.append("<BODY>\n");
        sb.append("<H1>" + Constants.RESGISTRATION_LINK_EMAIL_SUBJECT + "</H1>" + "\n");

        sb.append(mail);
        sb.append("</BODY>\n");
        sb.append("</HTML>\n");

        msg.setDataHandler(new DataHandler(
            new ByteArrayDataSource(sb.toString(), "text/html")));
        msg.setSentDate(new Date());

        msg.saveChanges();
        // send the thing off
        Transport.send(msg);
        /*Transport transport = session.getTransport(Constants.SMTP_HOST_TRANSPORT_PROVIDER);
        transport.connect(Constants.SMTP_HOST_ADDR, Constants.FROM_ADDR_FOR_USER_EMAIL,
                Constants.SMTP_PASSWORD);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();*/

        //Also archive the email into a folder for record.
        logger.info(msg.getContent().toString());
    }


    /*public static void sendForgotPasswordLinkeMail(String code, String email) throws Exception{
        String mail = "Dear User, please click on the link below to change your password in TickerTrek"
                + "<a href=\""+Constants.WEBISTE_HOST_NAME_WITH_CONTEXT+"?forgotpasswordconfirm=true&"
                +Constants.FORGOT_PASSWORD_CODE_KEY+"="+code+"&"+Constants.FORGOT_PASSWORD_EMAIL_KEY+"="+email+"\"> "
                +Constants.WEBISTE_HOST_NAME_WITH_CONTEXT+"?forgotpasswordconfirm=true</a> <br><br>"
                + "Please change your password within 24 hours, otherwise the link will expire.";

        if(loger.isDebugEnabled())
            loger.debug("Forgotpassword link:"+mail);
        session.setDebug(true);


        // construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(Constants.FROM_ADDR_FOR_USER_EMAIL,
                Constants.FROM_NAME_FOR_USER_EMAIL));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        msg.setSubject(Constants.FORGOT_PASSWORD_LINK_EMAIL_SUBJECT);

        StringBuilder sb = new StringBuilder();
        sb.append("<HTML>\n");
        sb.append("<HEAD>\n");
        sb.append("<TITLE>\n");
        sb.append(Constants.FORGOT_PASSWORD_LINK_EMAIL_SUBJECT + "\n");
        sb.append("</TITLE>\n");
        sb.append("</HEAD>\n");

        sb.append("<BODY>\n");
        sb.append("<H1>" + Constants.FORGOT_PASSWORD_LINK_EMAIL_SUBJECT + "</H1>" + "\n");

        sb.append(mail);
        sb.append("</BODY>\n");
        sb.append("</HTML>\n");

        msg.setDataHandler(new DataHandler(
            new ByteArrayDataSource(sb.toString(), "text/html")));
        msg.setSentDate(new Date());

        msg.saveChanges();
        // send the thing off
        Transport transport = session.getTransport(Constants.SMTP_HOST_TRANSPORT_PROVIDER);
        transport.connect(Constants.SMTP_HOST_ADDR, Constants.FROM_ADDR_FOR_USER_EMAIL,
                Constants.SMTP_PASSWORD);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();

        //Also archive the email into a folder for record.
        loger.info(msg.getContent());
    }
    
    public static void sendForgotPasswordSuccessfuleMail(String email) throws Exception{

        String mail = "Dear User, this is the email to confirm a change of password"
                + " in TickerTrek. Thank you for choosing TickerTrek";

        // construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(Constants.FROM_ADDR_FOR_USER_EMAIL,
                Constants.FROM_NAME_FOR_USER_EMAIL));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        msg.setSubject(Constants.FORGOT_PASSWORD_SUCESS_EMAIL_SUBJECT);

        StringBuilder sb = new StringBuilder();
        sb.append("<HTML>\n");
        sb.append("<HEAD>\n");
        sb.append("<TITLE>\n");
        sb.append(Constants.FORGOT_PASSWORD_SUCESS_EMAIL_SUBJECT + "\n");
        sb.append("</TITLE>\n");
        sb.append("</HEAD>\n");

        sb.append("<BODY>\n");
        sb.append("<H1>" + Constants.FORGOT_PASSWORD_SUCESS_EMAIL_SUBJECT + "</H1>" + "\n");

        sb.append(mail);
        sb.append("</BODY>\n");
        sb.append("</HTML>\n");

        msg.setDataHandler(new DataHandler(
            new ByteArrayDataSource(sb.toString(), "text/html")));
        msg.setSentDate(new Date());

        msg.saveChanges();
        // send the thing off
        Transport transport = session.getTransport(Constants.SMTP_HOST_TRANSPORT_PROVIDER);
        transport.connect(Constants.SMTP_HOST_ADDR, Constants.FROM_ADDR_FOR_USER_EMAIL,
                Constants.SMTP_PASSWORD);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();

        loger.info(mail);

    }

    
    public static void main (String args[]){

        try {
            sendRegistrationSuccessfuleMail("investweet@gmail.com");
            //System.out.println("password:"+getMyKerberosePassphrase());
            
        }catch (Exception exp){
            loger.error(exp);
            System.out.println("ERROR: Error while sending email.");
        }

    }*/


   
}

