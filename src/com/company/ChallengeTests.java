package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private AccurateReversal a = new AccurateReversal();

    public ChallengeTests() {

    }


    @Test
    public void test1() {
        assertEquals("Tibade", a.specialReverseString("Edabit"));
    }

    @Test
    public void test2() {
        assertEquals("REWOL reppu", a.specialReverseString("UPPER lower"));
    }

    @Test
    public void test3() {
        assertEquals("6 54 321", a.specialReverseString("1 23 456"));
    }

    @Test
    public void test4() {
        assertEquals("!dlro Wolleh", a.specialReverseString("Hello World!"));
    }

    @Test
    public void test5() {
        assertEquals("?ysiadg odru oys 'erehw", a.specialReverseString("Where's your dog Daisy?"));
    }

    @Test
    public void test6() {
        assertEquals("Stee hsely tsgn IDA csacs Naemsscta Htnwo Nks'ti", a.specialReverseString("It's known that CSS means Cascading Style Sheets"));
    }
}
