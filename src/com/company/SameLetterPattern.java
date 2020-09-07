package com.company;


/**
 * returns true if two strings share the same letter pattern, and false otherwise.
 */
public class SameLetterPattern extends Challenge {

    private boolean hasSamePattern(String input, String target) {
        if (input.length() != target.length()) return false;
        return getAmountOfRepeatingChars(input) == getAmountOfRepeatingChars(target);
    }

    private int getAmountOfRepeatingChars(String s) {
        var count = 0;
        for (var i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                count++;
        }
        return count;
    }

    @Override
    public void show() {
        System.out.println(hasSamePattern("ABAB", "CDCD"));
        System.out.println(hasSamePattern("ABCBA", "BCDCB"));
        System.out.println(hasSamePattern("FFGG", "CDCD"));
        System.out.println(hasSamePattern("FFFF", "ABCD"));
        System.out.println(hasSamePattern("AAABBB", "CCCDDD"));
        System.out.println(hasSamePattern("AAAA", "BBBB"));
        System.out.println(hasSamePattern("BAAB", "QZZQ"));
    }
}




