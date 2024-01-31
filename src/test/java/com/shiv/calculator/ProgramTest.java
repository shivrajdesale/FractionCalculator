package com.shiv.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void test_ProgramInstance() {
        //when
        Program expected = Program.getInstance();
        //action
        Program actual = Program.getInstance();
        //then
        assertEquals(expected, actual);

    }


    @Test
    void exit() {
    }
}