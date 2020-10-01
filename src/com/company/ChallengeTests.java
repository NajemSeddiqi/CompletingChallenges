package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private RecomposingStrings recomposingStrings = new RecomposingStrings();

    public ChallengeTests() {

    }

    @Test
    public void test1() {
        assertEquals("Kid Koala", recomposingStrings.recompose("KiKdaola"));
    }

    @Test
    public void test2() {
        assertEquals("Boards Of Canada", recomposingStrings.recompose("BaosdrOCfanada"));
    }

    @Test
    public void test3() {
        assertEquals("Chemical Brothers", recomposingStrings.recompose("hCemicarBlohtesr"));
    }

    @Test
    public void test4() {
        assertEquals("Mouse On Mars", recomposingStrings.recompose("MuosOeMnasr"));
    }

    @Test
    public void test5() {
        assertEquals("Aphex Twin", recomposingStrings.recompose("AhpewTxin"));
    }

    @Test
    public void test6() {
        assertEquals("Massive Attack", recomposingStrings.recompose("MassivAettakc"));
    }

    @Test
    public void test7() {
        assertEquals("Does It Offend You Yeah", recomposingStrings.recompose("DeosItOffeYdnuoYaeh"));
    }
}
