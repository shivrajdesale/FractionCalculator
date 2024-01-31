package com.shiv.calculator.interpreter;

import com.shiv.calculator.Util;
import com.shiv.calculator.model.FractionalExpression;
import com.shiv.calculator.model.FractionalNumber;

import java.util.*;
import java.util.regex.Pattern;

public class FractionalExpressionInterpreter {

    private final List<String> operatorList = Arrays.asList("+", "-", "*", "/");
    private final Pattern pattern = Pattern.compile("-*[0-9]+(/[0-9]+|&[0-9]+/[0-9]+)*");
    public Optional<FractionalExpression> interpret(String input) {
        String[] inputParts = input.split(" ");
        if(validate(inputParts)){
            //Operator operator = Operator.valueOf(inputParts[1]);
            FractionalNumber leftOperand = getFractionNumber(inputParts[0]);
            FractionalNumber rightOperand = getFractionNumber(inputParts[2]);
            return Optional.of(new FractionalExpression(inputParts[1], leftOperand, rightOperand));
        }
        return Optional.empty();

    }

    private boolean validate(String[] inputParts){
        //return inputParts.length == 0 && Operator.getOperator(inputParts)
        return inputParts.length ==3 && operatorList.contains(inputParts[1]) && pattern.matcher(inputParts[0]).matches()
                && pattern.matcher(inputParts[2]).matches();

    }

    private FractionalNumber getFractionNumber(String operand){
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
        long gcd = Util.getGCD(n, d);
        return new FractionalNumber(n/gcd, d/gcd);
    }
}
