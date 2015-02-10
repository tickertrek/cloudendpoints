package com.tickertrek.cloudendpoints.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

/**
 *
 * @author Uttam
 */
public class Constants {
    public class OrderProcessor{
        public static final String ORDER_PROCESSOR_HOST = "localhost";
        public static final int ORDER_PROCESSOR_RECEIVER_PORT = 3001;
    }
    
    public class T2OpCode{
       public static final int ERROR = 0;
       public static final int ORDER_CANCEL_SUCCESS = 1;
       //public static final int ORDER = 3;
       public static final int ORDER_NEW = 2;
       public static final int ORDER_CANCEL = 3;
       public static final int ORDER_UPDATE = 4;
       public static final int ORDER_UPDATE_SUCCESS = 5;
       public static final int ORDER_NEW_SUCCESS = 6;
   }
    
    public static final DecimalFormat decimalFormatter = new DecimalFormat("#####0.00");
    public static final SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat istDateFormat = new SimpleDateFormat("dd-MM-yy hh:mmaa");
    public static final SimpleDateFormat yahooQuoteDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mmaa");
    public static final Logger OPLogger = Logger.getLogger("com.bullfinder.orderprocessor");

   static{
       /*try{
            OPLogger.addHandler(new FileHandler("OrderProcessor.log"));
       }catch(Exception e){
           
       }*/
               
     gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
     istDateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
     yahooQuoteDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
    }
    public static Date rollBackToGMT(Date d){
            long gmtTime = d.getTime() + TimeZone.getDefault().getOffset(d.getTime());
            return new Date(gmtTime);

        }
    
    
    

    public static final String WEBISTE_HOST_NAME_WITH_CONTEXT = "http://www.tickertrek.com";//"http://localhost:8080/bullfinder";

    public static final String USER_ACTION_LOGIN = "login";
    public static final String USER_ACTION_SIGNOUT = "signout";
    public static final String USER_REQUEST_ACTION_KEY = "action";
    public static final String USER_ACTION_EMAIL_KEY = "email";
    public static final String USER_ACTION_PASSWORD_KEY = "password";
    public static final String USER_RESPONSE_ACTION_STATUS_SUCCESS = "success";
    public static final String USER_RESPONSE_ACTION_STATUS_KEY = "status";
    public static final String USER_RESPONSE_ACTION_STATUS_ERROR = "error";
    public static final String USER_ACTION_RETRIEVE_PROFILE = "retrieveprofile";
    public static final String USER_ACTION_STRATEGIES_I_FOLLOW = "strategiesifollow";
    public static final String SESSION_ATTRIBUTE_USER_ID = "userid";
    public static final String SESSION_ATTRIBUTE_EMAIL = "email";
    public static final String SESSION_ATTRIBUTE_FULLNAME = "fullname";
    public static final String SESSION_ATTRIBUTE_USER_PROFILE = "userProfile";
    public static final String RESPONSE_ATTRIBUTE_REF = "ref";
    public static final String RESPONSE_ATTRIBUTE_DATA = "data";
    public static final String RESPONSE_ATTRIBUTE_ERRORCODE = "errorCode";
    public static final String RESPONSE_ATTRIBUTE_MESSAGE = "message";
    
    
    
    public static final String RESPONSE_ATTRIBUTE_ABOUT_ME = "aboutme";
    public static final String RESPONSE_ATTRIBUTE_PROFESSION = "profession";

    public static final String REGISTRATION_CODE_KEY = "registrationcode";
    public static final String SIGNUP_KEY = "signup";
    public static final String REGISTRATION_CONFIRM_KEY = "registrationconfirm";

    public static final String FORGOT_PASSWORD_KEY = "forgotpassword";
    public static final String FORGOT_PASSWORD_CONFIRM_KEY = "forgotpasswordconfirm";
    public static final String FORGOT_PASSWORD_CODE_KEY = "forgotpasswordcode";
    public static final String FORGOT_PASSWORD_EMAIL_KEY = "forgotpasswordemail";
    public static final String CHANGE_PASSWORD_VIA_FORGOT_PASSWORD_KEY = "changepassword";
    public static final String FORGOT_PASSWORD_LINK_EMAIL_SUBJECT = "Please continue change your password in TickerTrek";
    public static final String FORGOT_PASSWORD_SUCESS_EMAIL_SUBJECT = "You have successfully changed your password in TickerTrek";

    public static final String STRATEGY_RELATION_OWN = "0";
    public static final String STRATEGY_RELATION_FOLLOWING = "1";
    public static final String STRATEGY_RELATION_WATCHING = "2";



    
    
        

    public static final long A_DAY_IN_MILLISEC = 86400000;

    public static final String SMTP_HOST_ADDR = "smtp.tickertrek.com";//"smtp.gmail.com";//smtp.tickertrek.com";//"128.120.32.8";
    public static final String SMTP_PASSWORD = "bullfinder123";//"bullfinder123";//"bullfinder123";
    public static final String SMTP_HOST_USER_NAME = "contact@tickertrek.com";//"tickertrek";//"contact";
    public static final String SMTP_HOST_TRANSPORT_PROVIDER = "smtp";
    public static final String FROM_ADDR_FOR_USER_EMAIL = "tickertrek@gmail.com";//"contact@tickertrek.com";
    public static final String FROM_NAME_FOR_USER_EMAIL = "TickerTrek Team";
    public static final String RESGISTRATION_LINK_EMAIL_SUBJECT = "Please confirm your registration in TickerTrek";
    public static final String RESGISTRATION_SUCESS_EMAIL_SUBJECT = "You have successfully registered in TickerTrek";

    public static final String SEARCH_KEY = "search";
    
    
    public class MessageCode{
        public static final String MESSAGE_CODE = "messageCode";
        public static final String MESSAGE_SUCCESS = "0";
        public static final String MESSAGE_ERROR = "1";
        public static final String MESSAGE_SUPPRESS = "2";
    }
    
    public class OpCode1{
       public static final int ERROR = 0;
       public static final int ORDER_CANCEL_SUCCESS = 1;
       //public static final int ORDER = 3;
       public static final int ORDER_NEW = 2;
       public static final int ORDER_CANCEL = 3;
       public static final int ORDER_UPDATE = 4;
       public static final int ORDER_UPDATE_SUCCESS = 5;
       public static final int ORDER_NEW_SUCCESS = 6;
   }
    
    public class ExceptionCode{
        public static final int LOGIN_USER_EMAIL_AND_PASSWORD_NOT_MATCH_ERROR = 0;
        public static final int BULLFINDER_GENERIC_ERROR = 1;
        public static final int BULLFINDER_USER_IDS_DONT_MATCH_ERROR = 2;
        public static final int REGISTRATION_USER_EMAIL_EXISTS_ERROR = 3;
        
        public static final int REGISTRATION_ERROR = 4;
        public static final int REGISTRATION_CODE_EXPIRED_ERROR = 5;
        public static final int REGISTRATION_CODE_DOES_NOT_EXIST_ERROR = 6;
        public static final int INVALID_INPUT_ERROR = 7;
        public static final int GENERIC_ERROR = 8;
        public static final int DUPLICATE_CHAMP_SIGNUP = 9;
        public static final int REGISTRATION_USER_NICKNAME_EXISTS_ERROR = 10;
        public static final int GENERIC_ERROR_FORM_FILED_NULL_ERROR = 21;
        //// Quote related public exception
        public static final int QUOTE_INVALID_TICKER = 51;
        
        // Error message that should not be repoted to the user
        public static final int UNAUTHENTICATED_USER_ERROR = 1001;
        
        // Quote related server exception
        public static final int QUOTE_SERVER_FAILURE = 1051;

        public static final int TICKER_COMMENT_HASH_TAG_FAILURE = 1500;
        public static final String TICKER_COMMENT_HASH_TAG_FAILURE_MSG = "Invalid use of hashtag - syntax: #Ticker <message>.";
        public static final int FORGOT_PASSWORD_ERROR = 800;
        public static final String FORGOT_PASSWORD_ERROR_MSG = "Invalid email entered for forgot password, please correct email id.";
        public static final int FORGOT_PASSWORD_USER_EMAIL_DOES_NOT_EXIST_ERROR = 801;
        public static final String FORGOT_PASSWORD_USER_EMAIL_DOES_NOT_EXIST_ERROR_MSG = "The user email you entered does not exist"
                + ", please correct the email and try again.";
        public static final int FORGOT_PASSWORD_CODE_EXPIRED_ERROR = 802;
        public static final String FORGOT_PASSWORD_CODE_EXPIRED_ERROR_MSG =
            "Your forgot password link has been expired. Please try again.";
        
        public static final String GENERIC_ERROR_MSG = "Bad Bad Server!!! No Donut for the programmer!!!";
        public static final String LOGIN_USER_EMAIL_AND_PASSWORD_NOT_MATCH_ERROR_MSG =
            "User email and password dont match.";
        public static final String BULLFINDER_GENERIC_ERROR_MSG =
            "An unexpected error has occured, we are trying to solve it. "
            + "You can report it as well on the Forum page";
        public static final String BULLFINDER_USER_IDS_DONT_MATCH_ERROR_MSG =
            "An unexpected error has occured, we are trying to solve it. "
            + "Please report it if the problem persist on the Forum page";
        public static final String REGISTRATION_USER_EMAIL_EXISTS_ERROR_MSG =
            "User email already exists, please use a different email";
        public static final String REGISTRATION_USER_NICKNAME_EXISTS_ERROR_MSG =
            "User Name already exists, please use a different User Name";
        
        public static final String REGISTRATION_ERROR_MSG =
            "Unable to register, please try again later";
        public static final String REGISTRATION_CODE_EXPIRED_ERROR_MSG =
            "Your registration link has been expired. Please register again.";
        public static final String REGISTRATION_CODE_DOES_NOT_EXIST_ERROR_MSG =
            "Your registration code does not exist or the link is expired. Please register again.";
        public static final String GENERIC_ERROR_FORM_FILED_NULL_ERROR_MSG =
                "Some of the required values of this form is null, please check again, and then submit";

    }
    
    public class Championship{
        public static final String CHAMP_SIGNUP = "champsignup";
        public static final String CHAMP_LIST = "championshiplist";
        public static final String CHAMP_RANKING = "championshipranking";
        public static final String CHAMP_INFO = "champinfo";
        
        public static final int INACTIVE = 0;
        public static final int ACTIVE = 1;
        public static final int ENDED = 2;
        public static final int RUNNING = 3;
    }
    
    public class Profile{
        public static final String SESSION_ATTRIBUTE_USER_PROFILE_KEY = "userProfile";
        public static final String PROFILE_FULLNAME_KEY = "fullname";
        public static final String PROFILE_NICKNAME_KEY = "nickname";
        public static final String PROFILE_USER_ID_KEY = "userid";
        public static final String PROFILE_UPDATE = "profileupdate";
        public static final String PASSWORD_UPDATE = "passwordupdate";
        
        
    }


    /////////////////////////////////////////////////////////////////////////////////
    //  filtertype == 0 added to the slelect list but not in the WHERE clause
    //  filtertype == 1 added to the slelect list and WHERE clause is range
    //  filtertype == 2 added to the slelect list and WHERE clause is value
    //  filtertype == 3 NOT added to the slelect list but WHERE AND/OR sortorder/type clause is customized basic search
    //////////////////////////////////////////////////////////////////////////////////
   public class Filter{
        public static final int FILTER_DEFAULT_CALUMN = 0;
        public static final int FILTER_RANGE = 1;
        public static final int FILTER_VALUE = 2;
        public static final int FILTER_BASIC_SEARCH = 3;
        public static final String FILTER_BASIC_TYPE1 = "bs-filter1";
        public static final String FILTER_BASIC_TYPE2 = "bs-filter2";
        public static final String FILTER_BASIC_MAX_PROFIT = "maxprofit";
        public static final String FILTER_BASIC_MOST_ACTIVE = "mostactive";
        public static final String FILTER_BASIC_TOP_LOOSER = "toplooser";
        public static final String FILTER_BASIC_LONG_TRACK = "lt";
        public static final String FILTER_BASIC_FREE_TRIAL = "ot";
        public static final String FILTER_BASIC_PROFITABLE_THREE_MONTHS = "p3m";
    }

   public static class Strategy{
       /// userID to Strategy relationship
       public static final int OWNER = 0;
       public static final int FOLLOWER = 1;
       public static final int WATCHER = 2;
       public static final int PUBLIC = 9;

       public static final String GET_POWER = "getpower";

       public static final String NEW_STRATEGY = "new";
       public static final String DELETE_STRATEGY = "deletestrategy";
       public static final String STRATEGY_LIST = "strategylist";
       public static final String STRATEGY_UPDATE = "save";
       public static final String STRATEGY_UNFOLLOW = "unfollow";
       public static final String STRATEGY_FOLLOW = "follow";
       public static final String STRATEGY_UNWATCH = "unwatch";
       public static final String STRATEGY_WATCH = "watch";

       public static final int INR = 0;
       public static final int USD = 1;
       public static final int GBP = 2;
       public static final String[] CURRENCY_CODE = {"INR", "USD", "GBP"};
       
       public static final int TYPE_GENERAL = 0;
       public static final int TYPE_CHAMPIONSHIP = 1;

       public static final int LISTING_PUBLIC = 0;
       public static final int LISTING_PRIVATE = 1;
       public static final String[] LISTING_CODE = {"public", "private"};

       public static final int STOCK = 0;
       public static final int OPTION = 1;
       public static final int FUTURE = 2;
       public static final int FOREX = 3;
       public static final String[] INSTRUMENT_CODE = {"stock", "option", "future","forex"};
       
       public static final int BROKERAGE_FEE_FIXED = 0;
       public static final int BROKERAGE_FEE_PERCENTAGE = 1;

       
   }
   public static class Trade{
       public static final String TRADE_LIST = "tradelist";
       public static final String TRADE_PORTFOLIO = "portfolio";

       public static final byte TRADE_OPEN = 0;
       public static final byte TRADE_CLOSE = 1;
       
       

   }
   public static class Order{
       public static final String ORDER_NEW = "ordernew";
       public static final String ORDER_UPDATE = "orderupdate";
       public static final String ORDER_CANCEL = "ordercancel";
       public static final String ORDER_REORDER = "reorder";
       public static final String ORDER_LIST = "orderlist";
       public static final String ALL_ORDER_LIST = "allorderlist";

       

       public static final byte ORDER_BUY = 0;
       public static final byte ORDER_SELL = 1;
       public static String[] ORDER_CODE = {"<span style='color:green'>Buy</span>","<span style='color:red'>Sell</span>"};

       public static final byte PRICE_LIMIT = 0;
       public static final byte PRICE_STOP = 1;
       public static final byte PRICE_MARKET = 2;
       public static String[] PRICE_CODE = {"Limit","Stop","Market"};


      public static final byte ORDER_PROCESSING = 0;
       public static final byte ORDER_EXECUTED = 1;
       public static final byte ORDER_CANCELED = 2;
       public static final byte ORDER_EXPIRED = 3;
       public static final byte ORDER_UPDATED = 4;
       public static final byte ORDER_TRIGGERED = 5;
       public static final byte ORDER_VOID = 6;
       public static String[] STATUS_CODE = {"Processing","<span style='color:green'>Executed</span>","<span style='color:red'>Canceled</span>"};
       public static String[] STATUS_DEFAULT_MSG = {"Your order is in process",
                                                    "Your order has been successfully executed",
                                                    "Your order has been canceled for an unknown reason"};
       

       public static final byte TERM_GFD = 0;
       public static final byte TERM_GTC = 1;
       public static String[] TERM_CODE = {"GFD","GTC"};


   }
   public static class Exchange{
       public static final byte BSE = 0;
       public static final byte NSE = 1;
       public static final byte UNKNOWN = 2;
       public static String[] EXCAHANGE_CODE = {"BSE","NSE"};

   }
   public static class Instrument{
       public static final byte STOCK = 0;
       public static final byte OPTION = 1;
       public static final byte FUTURE = 2;
       public static final byte FOREX = 2;

       public static final String[] INSTRUMENT_CODE = {"Stock", "Option", "Future","Forex"};
   }
   public static class Market{
       public static final byte INDIA = 0;
       public static final byte US = 1;
       public static final byte UK = 2;

       public static final String[] MARKET_CODE = {"Indian", "US", "UK"};
   }
   
   public static class PublicData{
       public static final String SUMMARY = "summary";
       public static final String FILTER_MENU = "filtermenu";
       public static final String QUOTE = "quote";
       public static final String QUOTE_LIST = "quotelist";
       public static final String SYMBOL_LOOKUP = "symbollookup";
       
       
   }
   public static class Request{
       public static final String USER_PROFILE="userPublicProfile";
       public static final String PUBLIC_TRADE_LIST="publicTradeList";
   }

   public static class Forum {
       public static final String TOPIC_ID_KEY = "topicid";
       public static final String TOPIC_COMMENTS_KEY = "comments";
       public static final String TOPIC_TITLE_KEY = "title";
       public static final String TOPIC_CREATEDBY_USERID_KEY = "createdbyid";
       public static final String TOPIC_CREATEDBY_NICMNAME_KEY = "createdbyname";
       public static final String TOPIC_CREATEDATE_KEY = "createdate";
       public static final String TOPIC_POSTCOUNT_KEY = "postcount";
       public static final String TOPIC_LASTPOST_KEY = "lastpost";

       public static final String COMMENT_ID_KEY = "commentid";
       public static final String COMMENT_DATE_KEY = "commentdate";
       public static final String COMMENT_BY_USERID_KEY = "commentedbyid";
       public static final String COMMENT_BY_NICMNAME_KEY = "commentedbyname";
       public static final String COMMENT_TEXT_KEY = "comment";
       public static final String COMMENT_REPLY_ID_KEY = "replyid";

       public static final String RECENT_TOPICS_SESSION_OBJECT = "recenttopics";
        public static final String MOST_DISCUSSED_TOPICS_SESSION_OBJECT = "mostdiscussedtopics";


        public static final String USER_ACTION_RETRIEVE_TOPICS = "getforumtopics";
        public static final String USER_ACTION_RETRIEVE_TOPIC_THREAD = "gettopicthread";
        public static final String USER_ACTION_CREATE_TOPIC = "createtopic";
        public static final String USER_ACTION_POST_COMMENT = "postcomment";
        public static final String USER_ACTION_TOPIC_TITLE = "topictitle";
        public static final String USER_ACTION_TOPIC_COMMENT = "comment";
        public static final String USER_ACTION_TOPIC_ID = "topicid";
        public static final String USER_ACTION_COMMENT_REPLY_ID = "replyid";
        
        public static final String FEEDBACK = "feedback";

        public static final String USER_ACTION_RETRIEVE_TICKER_TALKS = "gettickertalk";
        public static final String USER_ACTION_POST_TICKER_COMMENT = "posttickercomment";
        public static final String USER_ACTION_TICKER_COMMENT = "comment";
        public static final String USER_ACTION_TICKER_COMMENT_METER = "meter";
        public static final String USER_ACTION_TICKER_ID = "ticker";
        public static final String USER_ACTION_TICKER_COMMENT_REPLY_ID = "replyid";
        public static final String RESPONSE_ATTRIBUTE_TICKER_COMMENT_SIZE = "resultsize";

        public static final String RESPONSE_ATTRIBUTE_RECENT_TOPICS = "recenttopics";
        public static final String RESPONSE_ATTRIBUTE_MOST_DISCUSSED_TOPICS = "mostdiscussedtopics";
        public static final String RESPONSE_ATTRIBUTE_SEARCH_RESULT_SIZE = "resultsize";

        public static final String RESPONSE_ATTRIBUTE_TICKERTALK_COMMENTS = "ticekercomments";

        public static final String USER_ACTION_SEARCH_KEY = "searchkey";
        public static final String USER_ACTION_SEARCH_TOPICS = "searchtopics";
        public static final String USER_ACTION_POST_FEEDBACK = "postfeedback";
        public static final String USER_ACTION_FEEDBACK_TITLE = "feedbacktitle";
        public static final String USER_ACTION_FEEDBACK_COMMENT = "feedback";
        public static final String SEARCH_STOP_WORDS = "a,able,about,across,after,all,almost,also,am,among,an,"
                + "and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,"
                + "every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,"
                + "just,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,"
                + "or,other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,"
                + "there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,"
                + "why,will,with,would,yet,you,your";


        public static final int TICKER_DOES_NOT_EXIST_ERROR = 7;
        public static final String TICKER_DOES_NOT_EXIST_ERROR_MSG =
            "The ticker does not exist, please select an existing ticker.";

       
   }
   
   public class TokenType {
	   public static final String CUSTOM_TOKEN_TYPE = "custom";
   }

}


