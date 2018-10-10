package com.TaxBooking.taxBooking.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Msg {

	
	public static String usersessionName = "userId";
	public static String save = "Saved Successfully";
	public static String update = "Updated Successfully";
	public static String delete = "Deleted Successfully";
	public static String error = "Error occured. Try Again";
	public static String unknown_request = "UNKNOWN REQUEST";
	
	

    public static int SUCCESS_CODE=200;
    public static int ERROR_CODE=300;
    public static int ERROR_NETWORK_CODE=400;
    public static int TOKEN_NOT_FOUND=500;
    public static int INCORRECT_TOKEN=600;
    public static int NULLS_FOUND=700;
    
    public static String token="TBS" + new SimpleDateFormat("dd-MM-yyyy").format(new Date());

	
	
}
