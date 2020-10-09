package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private PalindromeDescendant p = new PalindromeDescendant();

    public ChallengeTests() {
    }

    @Test
    public void test1() {
        assertThat(p.palindromeDescendant(11211230), is(true));
    }

    @Test
    public void test2() {
        assertThat(p.palindromeDescendant(13001120), is(true));
    }

    @Test
    public void test3() {
        assertThat(p.palindromeDescendant(23336014), is(true));
    }

    @Test
    public void test4() {
        assertThat(p.palindromeDescendant(11), is(true));
    }

    @Test
    public void test5() {
        assertThat(p.palindromeDescendant(1122), is(false));
    }

    @Test
    public void test6() {
        assertThat(p.palindromeDescendant(332233), is(true));
    }

    @Test
    public void test7() {
        assertThat(p.palindromeDescendant(10210112), is(true));
    }

    @Test
    public void test8() {
        assertThat(p.palindromeDescendant(9735), is(false));
    }

    @Test
    public void test9() {
        assertThat(p.palindromeDescendant(97358817), is(false));
    }
}
