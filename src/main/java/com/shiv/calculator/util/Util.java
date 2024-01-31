package com.shiv.calculator.util;

/**
 * public class Util
 * General Util class
 * @author Shivraj Desale
 */
public class Util {

	/**
	 * Method to calculate GCD on long numbers
	 * @param n1 - first long number
	 * @param n2 - second long number
	 * @return result - gcd of two long numbers
	 *
	 */
	public static long getGCD(long n1, long n2) {
		long gcd = 1; n1 = Math.abs(n1); n2 = Math.abs(n2);
		
		long small = n1 < n2 ? n1 : n2;
		for(long i = small; i > 1; i--) {
			if(n1 % i == 0 && n2 % i == 0) {
				return i;
			}
		}
		
		return gcd;
	}
}
