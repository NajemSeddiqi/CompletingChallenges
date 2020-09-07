package com.company;


/**
 * returns true if two strings share the same letter pattern, and false otherwise.
 */
public class SameLetterPattern extends Challenge {

    static boolean hasSamePattern(String input, String target) {
        if (input.length() != target.length()) return false;
        return getAmountOfRepeatingChars(input) == getAmountOfRepeatingChars(target)
                && !input.substring(input.length() - 2, input.length() - 1).equalsIgnoreCase(target.substring(target.length() - 2, target.length() - 1))
                && !input.substring(0, 1).equalsIgnoreCase(target.substring(0, 1));
    }

    private static int getAmountOfRepeatingChars(String s) {
        var count = 0;
        for (var i = 0; i < s.length(); i++) {
            char curr = i == s.length() - 1 ? s.charAt(i - 1) : s.charAt(i);
            char next = i == s.length() - 1 ? curr : s.charAt(i + 1);
            if (curr == next)
                count++;
        }
        return count;
    }

    @Override
    public void show() {
//        System.out.println(hasSamePattern("ABAB", "CDCD"));
//        System.out.println(hasSamePattern("ABCBA", "BCDCB"));
//        System.out.println(hasSamePattern("FFGG", "CDCD"));
//        System.out.println(hasSamePattern("FFFF", "ABCD"));
//        System.out.println(hasSamePattern("AAABBB", "CCCDDD"));
//        System.out.println(hasSamePattern("AAAA", "BBBB"));
        System.out.println(hasSamePattern("BAAB", "QZZQ"));
        System.out.println(hasSamePattern("ABCA", "ABCD"));
    }
}




