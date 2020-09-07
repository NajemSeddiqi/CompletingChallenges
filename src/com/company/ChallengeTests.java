package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChallengeTests {

    @Test
    public void test1() {
        assertTrue(SameLetterPattern.hasSamePattern("ABAB", "CDCD"));
    }

    @Test
    public void test2() {
        assertTrue(SameLetterPattern.hasSamePattern("AAABBB", "CCCDDD"));
    }

    @Test
    public void test3() {
        assertTrue(SameLetterPattern.hasSamePattern("ABCBA", "BCDCB"));
    }

    @Test
    public void test4() {
        assertTrue(SameLetterPattern.hasSamePattern("AAAA", "BBBB"));
    }

    @Test
    public void test5() {
        assertTrue(SameLetterPattern.hasSamePattern("BAAB", "ABBA"));
    }

    @Test
    public void test6() {
        assertTrue(SameLetterPattern.hasSamePattern("BAAB", "QZZQ"));
    }

    @Test
    public void test7() {
        assertTrue(SameLetterPattern.hasSamePattern("TTZZVV", "PPSSBB"));
    }

    @Test
    public void test8() {
        assertTrue(SameLetterPattern.hasSamePattern("ZYX", "ABC"));
    }

    @Test
    public void test9() {
        assertTrue(SameLetterPattern.hasSamePattern("AABAA", "SSCSS"));
    }

    @Test
    public void test10() {
        assertTrue(SameLetterPattern.hasSamePattern("AABAABAA", "SSCSSCSS"));
    }

    @Test
    public void test11() {
        assertTrue(SameLetterPattern.hasSamePattern("UBUBUBUB", "WEWEWEWE"));
    }

    @Test
    public void test12() {
        assertFalse(SameLetterPattern.hasSamePattern("FFGG", "FFG"));
    }

    @Test
    public void test13() {
        assertFalse(SameLetterPattern.hasSamePattern("FFGG", "CDCD"));
    }

    @Test
    public void test14() {
        assertFalse(SameLetterPattern.hasSamePattern("FFFG", "GGHI"));
    }

    @Test
    public void test15() {
        assertFalse(SameLetterPattern.hasSamePattern("FFFF", "ABCD"));
    }

    @Test
    public void test16() {
        assertFalse(SameLetterPattern.hasSamePattern("ABCA", "ABCD"));
    }

    @Test
    public void test17() {
        assertFalse(SameLetterPattern.hasSamePattern("ABCAAA", "DDABCD"));
    }
}
