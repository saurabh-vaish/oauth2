package com.app.outh2server.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;


public class GlobalValidation {

	private GlobalValidation() {

	}

	/**
	 * method for validating string empty or not
	 * @param value
	 * @param message
	 * @throws CustomException
	 */
	public static void isStringEmpty(String value, String message) {
		if (StringUtils.isEmpty(value)) {
			throw new CustomException(message, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * method for validating Date having format dd-MM-yyyy
	 * @param value
	 * @param message
	 * @throws CustomException
	 */
	public static void checkDate(String value, String message) {
		if (StringUtils.isEmpty(value)) {
			throw new CustomException(message, HttpStatus.BAD_REQUEST);
		}   else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try{
				sdf.parse(value);
			} catch (ParseException e) {
				throw new CustomException("Please provide valid date ", HttpStatus.BAD_REQUEST);
			}

		}
	}


	/**
	 * method for validating object
	 * @param value
	 * @param message
	 * @throws CustomException
	 */
	public static void isObjectEmpty(Object value, String message) {
		if (value == null) {
			throw new CustomException(message, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * method for validating object
	 * @param message
	 * @throws CustomException
	 */
	public static void isFalse(Boolean b, String message) {
		if (Boolean.FALSE.equals(b)) {
			throw new CustomException(message, HttpStatus.BAD_REQUEST);
		}
	}

}
