package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private RemoveTheWord r = new RemoveTheWord();

    public ChallengeTests() {
    }

    @Test
    public void test1() {
        assertThat(r.removeLetters(new String[]{"s", "t", "r", "i", "n", "g", "w"}, "string"), is(new String[]{"w"}));
    }

    @Test
    public void test2() {
        assertThat(r.removeLetters(new String[]{"b", "b", "l", "l", "g", "n", "o", "a", "w"}, "balloon"), is(new String[]{"b", "g", "w"}));
    }

    @Test
    public void test3() {
        assertThat(r.removeLetters(new String[]{"d", "b", "t", "e", "a", "i"}, "edabit"), is(new String[]{}));
    }

    @Test
    public void test4() {
        assertThat(r.removeLetters(new String[]{"t", "t", "e", "s", "t", "u"}, "testing"), is(new String[]{"t", "u"}));
    }
}
