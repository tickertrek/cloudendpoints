package com.tickertrek.cloudendpoints.exception;

/**
*
* @author Uttam
*/
public class BullFinderException extends Exception{

   /**
	 * 
	 */
   private static final long serialVersionUID = 1216151398017100372L;
   private int excpId;
   private String customMsg;

   public int getExcpId() {
       return excpId;
   }

   public void setExcpId(int excpId) {
       this.excpId = excpId;
   }

   public String getCustomMsg() {
       return customMsg;
   }

   public void setExcpMsg(String customMsg) {
       this.customMsg = customMsg;
   }
   
   public BullFinderException(){
       super();
   }

   public BullFinderException(Throwable exp){
       super(exp);
   }

   public BullFinderException(Throwable exp, int id, String msg){
       super(exp);
       this.excpId = id;
       this.customMsg = msg;
   }

   public BullFinderException(Throwable exp, int id){
       super(exp);
       this.excpId = id;
       this.customMsg = exp.getMessage();
   }

   public BullFinderException(int id, String msg){
       super(msg);
       this.excpId = id;
       this.customMsg = msg;
   }

}