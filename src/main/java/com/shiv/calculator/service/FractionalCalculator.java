package com.shiv.calculator.service;

import com.shiv.calculator.exception.InvalidInputException;
import com.shiv.calculator.interpreter.FractionalExpressionInterpreter;
import com.shiv.calculator.model.FractionalExpression;
import com.shiv.calculator.model.FractionalNumber;

import java.util.Optional;


/**
 * public class FractionalCalculator
 * Service class to perform interpretation of provided input and operational
 * as per interpreted expression
 * @author Shivraj Desale
 */
public class FractionalCalculator {
    private final FractionalExpressionInterpreter interpreter;

    public FractionalCalculator(FractionalExpressionInterpreter interpreter){
        this.interpreter = interpreter;
    }


    /**
     * Method to perform parsing and operation as per provided input String
     * @param input {@link String}
     *        - String input to perform operation
     * @return container object {@link Optional<FractionalNumber>}
     *        - container object with result value of type Fractional Number
     * @throws {@link InvalidInputException
     *        - Exception to convey provided input is in invalid format
     *
     */
    public Optional<FractionalNumber> calculate(String input) throws InvalidInputException {
        return this.interpreter.interpret(input)
                .map(this::performOperation);
    }

    /**
     * Method to perform operation as per expression
     * @param expression {@link FractionalExpression}
     *        - expression representing operator and operands
     * @return result {@link FractionalNumber}
     *        - final result in format Fractional Number
     *
     */
    private FractionalNumber performOperation(FractionalExpression expression){
        switch (expression.getOperator()){
            case "+":
                return this.add(expression.getLeftOperand(), expression.getRightOperand());
            case "-":
                return this.subtract(expression.getLeftOperand(),expression.getRightOperand());
            case "*":
                return this.multiply(expression.getLeftOperand(),expression.getRightOperand());
            case "/":
                return this.divide(expression.getLeftOperand(),expression.getRightOperand());
            default:
                return null;
        }
    }

    /**
     * Private Method for addition operation
     * @param l {@link FractionalNumber}
     *        - left operand
     * @param r {@link FractionalNumber}
     *        - right operand
     * @return result {@link FractionalNumber}
     *        - addition result in format Fractional Number
     *
     */
    private FractionalNumber add(FractionalNumber l, FractionalNumber r){
        return new FractionalNumber(l.getNumerator() * r.getDenominator() + l.getDenominator() * r.getNumerator()
                , l.getDenominator() * r.getDenominator());
    }

    /**
     * Private Method for subtraction operation
     * @param l {@link FractionalNumber}
     *        - left operand
     * @param r {@link FractionalNumber}
     *        - right operand
     * @return result {@link FractionalNumber}
     *        - subtraction result in format Fractional Number
     *
     */
    private FractionalNumber subtract(FractionalNumber l, FractionalNumber r){
        return new FractionalNumber( l.getNumerator() * r.getDenominator() - l.getDenominator() * r.getNumerator(),
                l.getDenominator() * r.getDenominator() );
    }

    /**
     * Private Method for multiplication operation
     * @param l {@link FractionalNumber}
     *        - left operand
     * @param r {@link FractionalNumber}
     *        - right operand
     * @return result {@link FractionalNumber}
     *        - multiplication result in format Fractional Number
     *
     */
    private FractionalNumber multiply(FractionalNumber l, FractionalNumber r){
        return new FractionalNumber(l.getNumerator() * r.getNumerator(),
                l.getDenominator() * r.getDenominator() );
    }

    /**
     * Private Method for division operation
     * @param l {@link FractionalNumber}
     *        - left operand
     * @param r {@link FractionalNumber}
     *        - right operand
     * @return result {@link FractionalNumber}
     *        - division result in format Fractional Number
     *
     */
    private FractionalNumber divide(FractionalNumber l, FractionalNumber r){
        return new FractionalNumber(l.getNumerator() * r.getDenominator(),
                l.getDenominator() * r.getNumerator() );
    }

}
