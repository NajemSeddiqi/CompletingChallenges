package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private OddOneOut o = new OddOneOut();

    public ChallengeTests() {

    }

    @Test
    public void test1() {
        assertTrue(o.oddOneOut(new String[]{"silly", "mom", "let", "the"}));
    }

    @Test
    public void test2() {
        assertTrue(o.oddOneOut(new String[]{"swanky", "rhino", "moment"}));
    }

    @Test
    public void test3() {
        assertFalse(o.oddOneOut(new String[]{"the", "them", "theme"}));
    }

    @Test
    public void test4() {
        assertFalse(o.oddOneOut(new String[]{"very", "to", "an", "some"}));
    }

    @Test
    public void test5() {
        assertTrue(o.oddOneOut(new String[]{"very", "to", "then", "some"}));
    }
}
