package com.tickertrek.cloudendpoints.util;


import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

/**
 *
 * @author Uttam
 */
public class Utilities {



    public static Calendar calender = Calendar.getInstance(TimeZone.getDefault());
    public static final SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat istDateFormat = new SimpleDateFormat("dd-MM-yy hh:mmaa");
    public static final SimpleDateFormat currentDateFormat;
    public static final DecimalFormat decimalFormatter = new DecimalFormat("#####0.00");

             
   static{
     gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
     istDateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
     //Add the logic here to change the current time format for different time zone.
     currentDateFormat = istDateFormat;
    }

    public static String encryptPassword (String password) throws Exception{
        return md5PasswordEncryption(password);
    }
    protected static String md5PasswordEncryption(String password) throws Exception{
        byte[] defaultBytes = password.getBytes();       
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        algorithm.reset();
        algorithm.update(defaultBytes);
        byte messageDigest[] = algorithm.digest();
        StringBuilder hexString = new StringBuilder();
        String hex;
        for (int i=0;i<messageDigest.length;i++) {
            hex = Integer.toHexString(0xFF & messageDigest[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println("Password:"+hexString.toString());
        return hexString.toString();        
    }
    
    public static String generateRandomCode(String email, String name){
        String str="QAa0bcLdUK2eHfJgTP8XhiFj61DOklNm9nBoI5pGqYVrs3CtSuMZvwWx4yE7zR";
	 	StringBuilder sb = new StringBuilder();
	 	Random r = new Random();
	 	int te=0;
	    int length = r.nextInt(32)+30;
	 	for(int i=1;i<=length;i++){
	 		te=r.nextInt(62);
	 		sb.append(str.charAt(te));
	 	}
	 	return (sb.toString()+email.hashCode()+name.hashCode());
    }
    
    public static String generateRandomRegistrationCode(String email, String name){
        String str="QAa0bcLdUK2eHfJgTP8XhiFj61DOklNm9nBoI5pGqYVrs3CtSuMZvwWx4yE7zR";
	 	StringBuilder sb = new StringBuilder();
	 	Random r = new Random();
	 	int te=0;
	    int length = r.nextInt(32)+30;
	 	for(int i=1;i<=length;i++){
	 		te=r.nextInt(62);
	 		sb.append(str.charAt(te));
	 	}
	 	return (sb.toString()+email.hashCode()+name.hashCode());
    }

    public static String generateRandomForgotPasswordCode(String email){
        String str="QAa0bcLdUK2eHfJgTP8XhiFj61DOklNm9nBoI5pGqYVrs3CtSuMZvwWx4yE7zR";
 	StringBuilder sb = new StringBuilder();
 	Random r = new Random();
 	int te=0;
        int length = r.nextInt(32)+30;
 	for(int i=1;i<=length;i++){
 		te=r.nextInt(62);
 		sb.append(str.charAt(te));
 	}
 	return (sb.toString()+email.hashCode());
    }
    

    public static Date rollBackToGMT(Date d){
        long gmtTime = d.getTime() + TimeZone.getDefault().getOffset(d.getTime());
        return new Date(gmtTime);
        
    }
    
    
    public static String filterText(String text){
        System.err.println("Filter the user input for forum and delete this logging, text:"+text);
        //loger.error("Filter the user input for forum and delete this logging, text:"+text);
        if(text == null || text.trim().length() == 0)
            return null;
        return text.trim();
    }
    
    public static String removeChampExt(String s){
        int i = s.lastIndexOf("_");
        return s.substring(0, i);
    }

}

