package jmockit.examples.mockingstaticmethods;

import jmockit.examples.basicwithoutmocking.CommonUtil;

public class ValidationUtil {
	/**
	 * Validate given object should not be empty.<br >
	 * Throws IllegalArgumentException if the object is null.
	 * 
	 * @param o - object
	 * @param name
	 */
	public static void validateShouldNotBeEmpty(Object o, String name) {
		if(CommonUtil.isNull(o)) {
			throw new IllegalArgumentException(name + " cannot be null");
		}
	}
	
	/**
	 * Validate given string should not be empty<br >
	 * Throws IllegalArgumentException if the string is empty or null.
	 * 
	 * @param s - string
	 * @param name
	 */
	public static void validateStringShouldNotBeEmpty(String s, String name) {
		if(CommonUtil.isStringEmptyOrNull(s)) {
			throw new IllegalArgumentException(name + " cannot be empty or null");
		}
	}
}
