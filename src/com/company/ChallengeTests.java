package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChallengeTests {
    private BookEnd bookEnd;

    public ChallengeTests() {
        bookEnd = new BookEnd();
    }

    @Test
    public void test1() {
        assertEquals(4, bookEnd.countUniqueBooks("AZYWABBCATTTA", 'A'));
    }

    @Test
    public void test2() {
        assertEquals(3, bookEnd.countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
    }

    @Test
    public void test3() {
        assertEquals(0, bookEnd.countUniqueBooks("ZZABCDEF", 'Z'));
    }

    @Test
    public void test4() {
        assertEquals(6, bookEnd.countUniqueBooks("A#BBCD##GGA##!#", '#'));
    }

    @Test
    public void test5() {
        assertEquals(1, bookEnd.countUniqueBooks("&AAAAAAAAAAAA&", '&'));
    }

    @Test
    public void test6() {
        assertEquals(0, bookEnd.countUniqueBooks("&&&&&&&&", '&'));
    }

    @Test
    public void test7() {
        assertEquals(2, bookEnd.countUniqueBooks("&A&&&&&&C&", '&'));
    }

    @Test
    public void test8() {
        assertEquals(2, bookEnd.countUniqueBooks("&A&33333&C&", '&'));
    }

    @Test
    public void test9() {
        assertEquals(1, bookEnd.countUniqueBooks("&3&3&3&", '&'));
    }

    @Test
    public void test10() {
        assertEquals(2, bookEnd.countUniqueBooks("&4&3&3&", '&'));
    }

    @Test
    public void test11() {
        assertEquals(0, bookEnd.countUniqueBooks("&AA&", 'A'));
    }

    @Test
    public void test12() {
        assertEquals(3, bookEnd.countUniqueBooks("AZAAABDZCCZZ", 'Z'));
    }

    @Test
    public void test13() {
        assertEquals(1, bookEnd.countUniqueBooks("AZAAABDZCCZZ", 'A'));
    }
}
