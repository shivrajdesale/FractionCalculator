package com.shiv.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void getGCD() {
        //when
        long n1 = 2, n2 = 4;
        //action
        long actual = Util.getGCD(n1, n2);
        //then
        assertEquals(2, actual);

    }

    @Test
    void getGCD_Negative() {
        //when
        long n1 = -2, n2 = 4;
        //action
        long actual = Util.getGCD(n1, n2);
        //then
        assertEquals(2, actual);

    }

    @Test
    void getGCD_NonDivisible() {
        //when
        long n1 = 7, n2 = 4;
        //action
        long actual = Util.getGCD(n1, n2);
        //then
        assertEquals(1, actual);

    }
}