package com.shiv.calculator.model;

import com.shiv.calculator.util.Util;

/**
 * public class {@link FractionalNumber}
 * class to represent the Fraction Numbers in form of numerator and denominator
 * @author Shivraj Desale
 */
public class FractionalNumber {
    private final long numerator;

    private final long denominator;

    private final String representation;

    /**
     * Constructor for class  {@link FractionalExpression}
     * @param numerator long
     *        - numerator of fractional number
     * @param denominator long
     *        - denominator of fractional number
     */
    public FractionalNumber(long numerator, long denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        if(numerator == 0){
            this.representation = "0";
        }else{
            long gcd = Util.getGCD(numerator, denominator);
            long n = numerator / gcd;
            long d = denominator / gcd;
            long quotient = n / d;
            long remainder = n % d;
            remainder = quotient < 0 && remainder < 0 ? Math.abs(remainder) : remainder;
            StringBuilder builder = new StringBuilder();
            if(quotient != 0) {
                builder.append(quotient);
                if(remainder != 0) {
                    builder.append("&");
                }
            }
            if(remainder != 0) {
                builder.append(remainder).append("/").append(d);
            }
            this.representation = builder.toString();
        }

    }

    /**
     * @return numerator long
     */
    public long getNumerator() {
        return numerator;
    }

    /**
     * @return denominator long
     */
    public long getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return representation;
    }
}
