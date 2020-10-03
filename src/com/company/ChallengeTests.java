package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private ValidateCreditCardNumber v = new ValidateCreditCardNumber();

    public ChallengeTests() {

    }

    @Test
    public void test1() {
        assertFalse(v.validateCard(79927398714L));
    }

    @Test
    public void test2() {
        System.out.println("Passes Luhn test, but too short.");
        assertFalse(v.validateCard(79927398713L));
    }

    @Test
    public void test3() {
        assertTrue(v.validateCard(709092739800713L));
    }

    @Test
    public void test4() {
        assertFalse(v.validateCard(1234567890123456L));
    }

    @Test
    public void test5() {
        assertTrue(v.validateCard(12345678901237L));
    }

    @Test
    public void test6() {
        assertTrue(v.validateCard(5496683867445267L));
    }

    @Test
    public void test7() {
        assertFalse(v.validateCard(4508793361140566L));
    }

    @Test
    public void test8() {
        assertTrue(v.validateCard(376785877526048L));
    }

    @Test
    public void test9() {
        assertFalse(v.validateCard(36717601781975L));
    }
}
