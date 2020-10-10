package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private TruncatablePrimes t = new TruncatablePrimes();

    public ChallengeTests() {
    }

    @Test
    public void test1() {
        assertEquals(TruncatablePrimes.Side.LEFT, t.truncatable(47));
    }

    @Test
    public void test2() {
        assertEquals(TruncatablePrimes.Side.LEFT, t.truncatable(347));
    }

    @Test
    public void test3() {
        assertEquals(TruncatablePrimes.Side.LEFT, t.truncatable(62383));
    }

    @Test
    public void test4() {
        assertEquals(TruncatablePrimes.Side.RIGHT, t.truncatable(79));
    }

    @Test
    public void test5() {
        assertEquals(TruncatablePrimes.Side.RIGHT, t.truncatable(7331));
    }

    @Test
    public void test6() {
        assertEquals(TruncatablePrimes.Side.RIGHT, t.truncatable(233993));
    }

    @Test
    public void test7() {
        assertEquals(TruncatablePrimes.Side.BOTH, t.truncatable(3797));
    }

    @Test
    public void test8() {
        assertEquals(TruncatablePrimes.Side.BOTH, t.truncatable(739397));
    }

    @Test
    public void test9() {
        System.out.println("Single-digit number treated as both.");
        assertEquals(TruncatablePrimes.Side.BOTH, t.truncatable(5));
    }

    @Test
    public void test10() {
        assertEquals(TruncatablePrimes.Side.NONE, t.truncatable(349));
    }

    @Test
    public void test11() {
        System.out.println("The starting number is composite.");
        assertEquals(TruncatablePrimes.Side.NONE, t.truncatable(2317));
    }

    @Test
    public void test12() {
        System.out.println("1 is not a prime.");
        assertEquals(TruncatablePrimes.Side.NONE, t.truncatable(131));
    }

    @Test
    public void test13() {
        System.out.println("Cannot contain a 0 digit.");
        assertEquals(TruncatablePrimes.Side.NONE, t.truncatable(6043));
    }
}
