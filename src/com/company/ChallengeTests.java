package com.company;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private SherlockValidation s = new SherlockValidation();

    public ChallengeTests() {
    }

    @Test
    public void test1() {
        assertThat(s.isValid("aabbccddeefghi"), is("NO"));
    }

    @Test
    public void test2() {
        assertThat(s.isValid("aabbcd"), is("NO"));
    }

    @Test
    public void test3() {
        assertThat(s.isValid("abcdefghhgfedecba"), is("YES"));
    }

    @Test
    public void test4() {
        assertThat(s.isValid("abc"), is("YES"));
    }

    @Test
    public void test5() {
        assertThat(s.isValid("abcc"), is("YES"));
    }

    @Test
    public void test6() {
        assertThat(s.isValid("abccc"), is("NO"));
    }

    @Test
    public void test7() {
        assertThat(s.isValid("aabccc"), is("NO"));
    }

    @Test
    public void test8() {
        assertThat(s.isValid("aabbccc"), is("YES"));
    }

    @Test
    public void test9() {
        assertThat(s.isValid("ibcttdxu"), is("YES"));
    }

    @Test
    public void test10() {
        assertThat(s.isValid("inuttdxux"), is("NO"));
    }

    @Test
    public void test11() {
        assertThat(s.isValid("mopnntrxelq"), is("YES"));
    }
}
