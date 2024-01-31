package com.shiv.calculator.util;

import java.math.BigInteger;

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
		return BigInteger.valueOf(n1).gcd(BigInteger.valueOf(n2)).longValue();
	}
}
