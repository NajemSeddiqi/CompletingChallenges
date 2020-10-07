package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChallengeTests {
    private TextTwist t = new TextTwist();

    public ChallengeTests() {
    }

    @Test
    public void test1() {
        assertThat(t.totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"), is(13));
    }

    @Test
    public void test2() {
        assertThat(t.totalPoints(new String[]{"dial", "tail", "lid", "tide", "date", "late", "tad"}, "detail"), is(12));
    }

    @Test
    public void test3() {
        assertThat(t.totalPoints(new String[]{"trance", "recant"}, "recant"), is(108));
    }

    @Test
    public void test4() {
        assertThat(t.totalPoints(new String[]{"bluest", "sublet", "let", "set", "belt", "belts", "bet", "bets", "sted", "but", "tule"}, "subtle"), is(121));
    }

    @Test
    public void test5() {
        assertThat(t.totalPoints(new String[]{"cat", "create", "sat"}, "caster"), is(2));
    }

    @Test
    public void test6() {
        assertThat(t.totalPoints(new String[]{"emote", "tome", "root"}, "meteor"), is(5));
    }
}
