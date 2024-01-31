package com.shiv.calculator.service;

import com.shiv.calculator.exception.InvalidInputException;
import com.shiv.calculator.interpreter.FractionalExpressionInterpreter;
import com.shiv.calculator.model.FractionalExpression;
import com.shiv.calculator.model.FractionalNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FractionCalculatorTest {

    private FractionalCalculator calculator;

    @BeforeEach
    void setUp(){
        FractionalExpressionInterpreter interpreter = new FractionalExpressionInterpreter();
        this.calculator = new FractionalCalculator(interpreter);
    }

    @Test
    public void testCalculate_Multiply_Success(){
        //when
        String input = "1/2 * 3/4";

        //action
        Optional<FractionalNumber> actual = this.calculator.calculate(input);

        //then
        assertTrue(actual.isPresent());
        assertEquals("3/8", actual.get().toString());
    }

    @Test
    public void testCalculate_Divide_Success(){
        //when
        String input = "3&1/2 / 1&3/4";

        //action
        Optional<FractionalNumber> actual = this.calculator.calculate(input);

        //then
        assertTrue(actual.isPresent());
        assertEquals("2", actual.get().toString());
    }

    @Test
    public void testCalculate_Addition_Success(){
        //when
        String input = "3&1/2 + 1&3/4";

        //action
        Optional<FractionalNumber> actual = this.calculator.calculate(input);

        //then
        assertTrue(actual.isPresent());
        assertEquals("5&1/4", actual.get().toString());
    }

    @Test
    public void testCalculate_Subtraction_Success(){
        //when
        String input = "3&1/2 - 1&3/4";

        //action
        Optional<FractionalNumber> actual = this.calculator.calculate(input);

        //then
        assertTrue(actual.isPresent());
        assertEquals("1&3/4", actual.get().toString());
    }

    @Test
    public void testCalculate_MultiPly_WholeNumber_Success(){
        //when
        String input = "5 * 3&3/4";

        //action
        Optional<FractionalNumber> actual = calculator.calculate(input);

        //then
        assertTrue(actual.isPresent());
        assertEquals("18&3/4", actual.get().toString());

    }

    @Test
    public void testCalculate_Multiply_NegativeNumber_Success(){
        //when
        String input = "3/2 * -3&3/4";

        //action
        Optional<FractionalNumber> actual = calculator.calculate(input);

        //then
        assertTrue(actual.isPresent());
        assertEquals("-3&3/8", actual.get().toString());

    }

    @Test
    public void testCalculate_Addition_ResultZero_Success(){
        //when
        String input = "-1/2 + 1/2";

        //action
        Optional<FractionalNumber> actual = calculator.calculate(input);

        //then
        assertTrue(actual.isPresent());
        assertEquals("0", actual.get().toString());

    }

    @Test
    public void testCalculate_throwsException(){
        //when
        String input = "-1/2*1/2";

        //action
        InvalidInputException exception = Assertions.assertThrows(InvalidInputException.class, () -> calculator.calculate(input));
        //

        //then
        assertEquals("Invalid Input", exception.getMessage());

    }

    @AfterEach
    void tearDown(){
        this.calculator = null;
    }
}