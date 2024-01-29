package com.shiv.calculator.model;

/**
 * public class {@link FractionalNumber}
 * class to represent the Fraction Numbers in form of numerator and denominator
 * @author Shivraj Desale
 */
public class FractionalNumber {
    private final long numerator;

    private final long denominator;

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
}
