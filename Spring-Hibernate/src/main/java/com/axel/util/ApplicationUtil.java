package com.axel.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * The Class ApplicationUtil has static utility methods
 * 
 * @author Ankit Singh
 * @since 28/09/2015
 */
public final class ApplicationUtil {
	
	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
	
	/** The Constant DATE_FORMAT. */
	private static final String DD_MM_YYYY_DATE_FORMAT = "dd-MM-yyyy";

	/**
	 * Instantiates a new application util.
	 */
	private ApplicationUtil() {

	}

	/**
	 * Checks if is list null or empty.
	 *
	 * @param listOfData
	 *            the list of data
	 * @return true, if is list null or empty
	 */
	public static boolean isListNullOrEmpty(List listOfData) {
		return listOfData == null || listOfData.size() == 0;
	}

	/**
	 * Checks if is string null or empty.
	 *
	 * @param string
	 *            the string
	 * @return true, if is string null or empty
	 */
	public static boolean isStringNullOrEmpty(String string) {
		return string == null || string.isEmpty();
	}

	/**
	 * Parses the date.
	 *
	 * @param date
	 *            the date
	 * @param dateFormat
	 *            the date format
	 * @return the date
	 */
	public static Date getParsedDate(String date) {

		DateFormat dateFormat = new SimpleDateFormat(DD_MM_YYYY_DATE_FORMAT, Locale.ENGLISH);
		Date parsedDate = null;
		
		try {
			parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parsedDate;
	}

	/**
	 * Parses the date.
	 *
	 * @param date
	 *            the date
	 * @param dateFormat
	 *            the date format
	 * @return the date
	 */
	public static String convertDateToString(Date date) {

		DateFormat df = new SimpleDateFormat(DATE_FORMAT);

		String publishedDate = df.format(date);

		return publishedDate;
	}

}
