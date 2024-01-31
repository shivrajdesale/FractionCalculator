package com.shiv.calculator.service;

import com.shiv.calculator.interpreter.FractionalExpressionInterpreter;
import com.shiv.calculator.model.FractionalExpression;
import com.shiv.calculator.model.FractionalNumber;

import java.util.Optional;

public class FractionalCalculator {
    private final FractionalExpressionInterpreter interpreter;

    public FractionalCalculator(FractionalExpressionInterpreter interpreter){
        this.interpreter = interpreter;
    }

    public Optional<FractionalNumber> calculate(String input){
        return this.interpreter.interpret(input)
                .map(this::performOperation);
    }

    public FractionalNumber performOperation(FractionalExpression expression){
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

    private FractionalNumber add(FractionalNumber l, FractionalNumber r){
        return new FractionalNumber(l.getNumerator() * r.getDenominator() + l.getDenominator() * r.getNumerator()
                , l.getDenominator() * r.getDenominator());
    }

    private FractionalNumber subtract(FractionalNumber l, FractionalNumber r){
        return new FractionalNumber( l.getNumerator() * r.getDenominator() - l.getDenominator() * r.getNumerator(),
                l.getDenominator() * r.getDenominator() );
    }

    private FractionalNumber multiply(FractionalNumber l, FractionalNumber r){
        return new FractionalNumber(l.getNumerator() * r.getNumerator(),
                l.getDenominator() * r.getDenominator() );
    }

    private FractionalNumber divide(FractionalNumber l, FractionalNumber r){
        return new FractionalNumber(l.getNumerator() * r.getDenominator(),
                l.getDenominator() * r.getNumerator() );
    }

}
