package jmockit.examples.basicwithoutmocking;

public class CommonUtil {

	/**
	 * Checks if the object is null
	 * 
	 * @param o - object
	 * @return
	 * true if the object is null<br />
	 * false if the object is not null 
	 */
	public static boolean isNull(Object o) {
		return (o == null);
	}
	
	/**
	 * Checks if the string is empty or null 
	 * 
	 * @param s - string
	 * @return
	 * true if the string is null<br />
	 * true if the string is ""<br />
	 * true if the string is " "<br />
	 * 
	 * false if the string length is greater than 0
	 */
	public static boolean isStringEmptyOrNull(String s) {
		return (isNull(s) || s.trim().length() == 0);
	}
}
