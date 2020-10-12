package com.company;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private BookEnd b = new BookEnd();

    public ChallengeTests() {
    }

    @Test
    public void test1() {
        assertEquals(4, b.countUniqueBooks("AZYWABBCATTTA", 'A'));
    }

    @Test
    public void test2() {
        assertEquals(3, b.countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
    }

    @Test
    public void test3() {
        assertEquals(0, b.countUniqueBooks("ZZABCDEF", 'Z'));
    }

    @Test
    public void test4() {
        assertEquals(6, b.countUniqueBooks("A#BBCD##GGA##!#", '#'));
    }

    @Test
    public void test5() {
        assertEquals(1, b.countUniqueBooks("&AAAAAAAAAAAA&", '&'));
    }

    @Test
    public void test6() {
        assertEquals(0, b.countUniqueBooks("&&&&&&&&", '&'));
    }

    @Test
    public void test7() {
        assertEquals(2, b.countUniqueBooks("&A&&&&&&C&", '&'));
    }

    @Test
    public void test8() {
        assertEquals(2, b.countUniqueBooks("&A&33333&C&", '&'));
    }

    @Test
    public void test9() {
        assertEquals(1, b.countUniqueBooks("&3&3&3&", '&'));
    }

    @Test
    public void test10() {
        assertEquals(2, b.countUniqueBooks("&4&3&3&", '&'));
    }

    @Test
    public void test11() {
        assertEquals(0, b.countUniqueBooks("&AA&", 'A'));
    }

    @Test
    public void test12() {
        assertEquals(3, b.countUniqueBooks("AZAAABDZCCZZ", 'Z'));
    }

    @Test
    public void test13() {
        assertEquals(1, b.countUniqueBooks("AZAAABDZCCZZ", 'A'));
    }
}
