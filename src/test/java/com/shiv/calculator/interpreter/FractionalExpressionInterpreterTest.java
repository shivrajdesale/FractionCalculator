package com.shiv.calculator.interpreter;

import com.shiv.calculator.exception.InvalidInputException;
import com.shiv.calculator.model.FractionalExpression;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FractionalExpressionInterpreterTest {

    private FractionalExpressionInterpreter interpreter;
    @BeforeEach
    void setUp() {
        this.interpreter = new FractionalExpressionInterpreter();
    }

    @Test
    public void testInterpret_Success(){
        //when
        String input = "1/2 * 3&3/4";

        //action
        Optional<FractionalExpression> actual = interpreter.interpret(input);

        //then
        assertTrue(actual.isPresent());
        FractionalExpression result = actual.get();
        assertEquals("*" , result.getOperator());
        assertEquals(1, result.getLeftOperand().getNumerator());
        assertEquals(2, result.getLeftOperand().getDenominator());
        assertEquals(15, result.getRightOperand().getNumerator());
        assertEquals(4, result.getRightOperand().getDenominator());

    }

    @Test
    public void testInterpret_wholeNumber_Success(){
        //when
        String input = "5 * 3&3/4";

        //action
        Optional<FractionalExpression> actual = interpreter.interpret(input);

        //then
        assertTrue(actual.isPresent());
        FractionalExpression result = actual.get();
        assertEquals("*" , result.getOperator());
        assertEquals(5, result.getLeftOperand().getNumerator());
        assertEquals(1, result.getLeftOperand().getDenominator());
        assertEquals(15, result.getRightOperand().getNumerator());
        assertEquals(4, result.getRightOperand().getDenominator());

    }

    @Test
    public void testInterpret_NegativeNumber_Success(){
        //when
        String input = "3/2 * -3&3/4";

        //action
        Optional<FractionalExpression> actual = interpreter.interpret(input);

        //then
        assertTrue(actual.isPresent());
        FractionalExpression result = actual.get();
        assertEquals("*" , result.getOperator());
        assertEquals(3, result.getLeftOperand().getNumerator());
        assertEquals(2, result.getLeftOperand().getDenominator());
        assertEquals(-9, result.getRightOperand().getNumerator());
        assertEquals(4, result.getRightOperand().getDenominator());

    }

    @Test
    public void testInterpret_invalid_operand_exception(){
        //when
        String input = "1/2 & 3&3/4";

        //action
        InvalidInputException exception = Assertions.assertThrows(
          InvalidInputException.class, () -> interpreter.interpret(input));

        //then
        assertEquals("Invalid Input", exception.getMessage());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void interpret() {
    }
}