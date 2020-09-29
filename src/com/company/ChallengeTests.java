package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private VowelFamilies vowelFamilies;

    public ChallengeTests() {
        vowelFamilies = new VowelFamilies();
    }

    @Test
    public void test1() {
        assertThat(vowelFamilies.sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"}), is(new String[]{"hoops", "bot", "bottom"}));
    }

    @Test
    public void test2() {
        assertThat(vowelFamilies.sameVowelGroup(new String[]{"crop", "nomnom", "bolo", "yodeller"}), is(new String[]{"crop", "nomnom",
                "bolo"}));
    }

    @Test
    public void test3() {
        assertThat(vowelFamilies.sameVowelGroup(new String[]{"semantic", "aimless", "beautiful", "meatless icecream"}), is(new String[]{
                "semantic", "aimless", "meatless icecream"}));
    }

    @Test
    public void test4() {
        assertThat(vowelFamilies.sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot"}), is(new String[]{"many"}));
    }

    @Test
    public void test5() {
        assertThat(vowelFamilies.sameVowelGroup(new String[]{"toe", "ocelot", "maniac"}), is(new String[]{"toe", "ocelot"}));
    }

    @Test
    public void test6() {
        assertThat(vowelFamilies.sameVowelGroup(new String[]{"a", "apple", "flat", "map", "shark"}), is(new String[]{"a", "flat", "map",
                "shark"}));
    }

    @Test
    public void test7() {
        assertThat(vowelFamilies.sameVowelGroup(new String[]{"a", "aa", "ab", "abc", "aaac", "abe"}), is(new String[]{"a", "aa", "ab",
                "abc", "aaac"}));
    }
}
