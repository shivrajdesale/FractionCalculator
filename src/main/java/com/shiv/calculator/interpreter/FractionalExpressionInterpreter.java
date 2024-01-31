package com.shiv.calculator.interpreter;

import com.shiv.calculator.exception.InvalidInputException;
import com.shiv.calculator.model.FractionalExpression;
import com.shiv.calculator.model.FractionalNumber;

import java.util.*;
import java.util.regex.Pattern;

/**
 * public class FractionalExpressionInterpreter
 * interpreter class to parse the input and validate if it is valid
 *      and if valid parse into Fractional Expression for further processing.
 * @author Shivraj Desale
 */
public class FractionalExpressionInterpreter {

    private final List<String> operatorList = Arrays.asList("+", "-", "*", "/");
    private final Pattern pattern = Pattern.compile("-*[0-9]+(/[0-9]+|&[0-9]+/[0-9]+)*");

    /**
     * Method to interpret provided input String
     * @param input {@link String}
     *        - String input to be parsed into Fractional Expression
     * @return container object {@link Optional<FractionalExpression>}
     *        - container object with value of type Fractional Expression
     * @throws {@link InvalidInputException
     *        - Exception to convey provided input is in invalid format
     *
     */
    public Optional<FractionalExpression> interpret(String input) throws InvalidInputException{
        String[] inputParts = input.split(" ");
        if(validateInput(inputParts)){
            FractionalNumber leftOperand = getFractionalNumber(inputParts[0]);
            FractionalNumber rightOperand = getFractionalNumber(inputParts[2]);
            return Optional.of(new FractionalExpression(inputParts[1], leftOperand, rightOperand));
        }else{
            throw new InvalidInputException();
        }

    }

    /**
     * Method to validate input
     * @param inputParts {@link String[]}
     *        - array with left Operand, operator and rightOperand in string format
     * @return boolean
     *        - result if input is in valid format(valid length, valid operand's format and valid operator)
     */
    private boolean validateInput(String[] inputParts){
        //return inputParts.length == 0 && Operator.getOperator(inputParts)
        return inputParts.length ==3 && operatorList.contains(inputParts[1]) && pattern.matcher(inputParts[0]).matches()
                && pattern.matcher(inputParts[2]).matches();

    }

    /**
     * Method to validate left and right operand parts from provided input
     * @param operand {@link String}
     *        - operand string parsed from input
     * @return fractionalNumber {@link FractionalNumber}
     *        - fractional number parsed from String
     */
    private FractionalNumber getFractionalNumber(String operand){
        String[] operandParts = operand.trim().split("&");
        long n, d;
        if(operandParts[0].contains("/")) {
            operandParts = operandParts[0].split("/");
            n = Long.parseLong(operandParts[0]);
            d = Long.parseLong(operandParts[1]);
        } else if(operandParts.length == 1) {
            n = Long.parseLong(operandParts[0]);
            d = 1;
        } else {
            String[] fParts = operandParts[1].split("/");
            d = Long.parseLong(fParts[1]);
            n = Long.parseLong(operandParts[0]) * d + Long.parseLong(fParts[0]);
        }
        return new FractionalNumber(n, d);
    }
}
