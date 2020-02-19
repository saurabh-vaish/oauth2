package com.app.outh2server.common;

import lombok.Data;

@Data
public class ErrorMessage {

	public static String USER_PASSWORD_REQUIRED	 = "User Name & Password Required";
	public static String INVALID_CREDENTIALS_MESSAGE	 = "Invalid Credentials";
	public static String ACCOUNT_ACTIVATE_MESSAGE	 = "Please contact Admin";
	public static String USER_NOT_FOUND_MESSAGE	 = "User not found with given credentials";

	public static String INVALID_USER_ID = "Please provide valid user id ";
	public static String INVALID_USER_EMAIL = "Please provide valid user email ";

	public static String INVALID_REQUEST = "Please provide valid request ";
	public static String DUPLICATE_USER_ID = "User id can't be duplicate  ";
	public static String DUPLICATE_USER_EMAIL = "User email can't be duplicate ";

	public static String NO_CURRENT_PASSWORD = "Current password is empty !";
	public static String NO_NEW_PASSWORD = "Please provide new password ";
	public static String INVALID_PASSWORD = "Invalid password !";


	public static String SERVER_ERROR = "Internal server error";



}
