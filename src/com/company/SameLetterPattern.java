package com.company;


/**
 * returns true if two strings share the same letter pattern, and false otherwise.
 */
public class SameLetterPattern extends Challenge {

    private boolean hasSamePattern(String input, String target) {
        if (input.length() != target.length()) return false;
        boolean lastOnesNotEqual =
                !input.substring(input.length() - 2, input.length() - 1).equalsIgnoreCase(target.substring(target.length() - 2, target.length() - 1));

        boolean firstOnesNotEqual = !input.substring(0, 1).equalsIgnoreCase(target.substring(0, 1));

        return getAmountOfRepeatingChars(input) == getAmountOfRepeatingChars(target)
                && lastOnesNotEqual
                && firstOnesNotEqual;
    }

    private int getAmountOfRepeatingChars(String s) {
        var count = 0;
        for (var i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) == s.charAt(i + 1))
                count++;

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
        System.out.println(hasSamePattern("ABCA", "ABCD"));
    }
}




