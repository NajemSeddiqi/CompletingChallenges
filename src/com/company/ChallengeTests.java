package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private ProductOfDigitOfSum p = new ProductOfDigitOfSum();

    public ChallengeTests() {

    }

    @Test
    public void test1() {
        assertEquals(6, p.sumDigProd(8, 16, 89, 3));
    }

    @Test
    public void test2() {
        assertEquals(6, p.sumDigProd(16, 28));
    }

    @Test
    public void test3() {
        assertEquals(9, p.sumDigProd(9));
    }

    @Test
    public void test4() {
        assertEquals(6, p.sumDigProd(26, 497, 62, 841));
    }

    @Test
    public void test5() {
        assertEquals(0, p.sumDigProd(0));
    }

    @Test
    public void test6() {
        assertEquals(6, p.sumDigProd(17737, 98723, 2));
    }

    @Test
    public void test7() {
        assertEquals(8, p.sumDigProd(123, -99));
    }

    @Test
    public void test8() {
        assertEquals(7, p.sumDigProd(9, 8));
    }

    @Test
    public void test9() {
        assertEquals(8, p.sumDigProd(167, 167, 167, 167, 167, 3));
    }

    @Test
    public void test10() {
        assertEquals(1, p.sumDigProd(111111111));
    }

    @Test
    public void test11() {
        assertEquals(2, p.sumDigProd(98526, 54, 863, 156489, 45, 6156));
    }

    @Test
    public void test12() {
        assertEquals(8, p.sumDigProd(999, 999));
    }

    @Test
    public void test13() {
        assertEquals(2, p.sumDigProd(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void test14() {
        assertEquals(2, p.sumDigProd(999, 2222));
    }

    @Test
    public void test15() {
        assertEquals(6, p.sumDigProd(8618, -2));
    }
}
