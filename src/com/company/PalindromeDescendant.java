package com.company;


import java.util.HashMap;
import java.util.Vector;

/**
 * A number may not be a palindrome, but its descendant can be.
 * A number's direct child is created by summing each pair of adjacent digits to create the digits of the next number
 * For instance, 123312 is not a palindrome, but its next child 363 is, where: 3 = 1 + 2; 6 = 3 + 3; 3 = 1 + 2
 * returns true if the number itself is a palindrome or any of its descendants down to 2 digits
 * (a 1-digit number is trivially a palindrome)
 */
public class PalindromeDescendant extends Challenge {

    private boolean palindromeDescendant(int n) {
        if (String.valueOf(n).length() == 1) return true;
        return isPalindrome(n);
    }

    private boolean isPalindrome(int n) {
        int half = String.valueOf(n).length() / 2;
        int length = String.valueOf(n).length();

        String firstHalf = String.valueOf(n).substring(0, half);
        StringBuilder secondHalf = new StringBuilder(String.valueOf(n).substring(half, length)).reverse();

        if (firstHalf.equalsIgnoreCase(secondHalf.toString())) {
            return true;
        } else {
            Boolean s = checkSmallValue(n);
            if (s != null) return s;

            Boolean h1 = checkMediumValue(n);
            if (h1 != null) return h1;

            return checkParityOfN(getDescendants(n));
        }

    }

    private boolean checkParityOfN(StringBuilder children) {
        if (children.length() % 2 == 0) {
            String h = getStartingChars(children);
            String l = getEndingChars(children);
            return isPalindrome(Integer.parseInt(h + l));
        } else {
            String h = getStartingChars(children);
            String l = getEndingChars(children);

            h = h + l.charAt(0) + l;
            return isPalindrome(Integer.parseInt(h));
        }
    }

    private StringBuilder getDescendants(int n) {
        StringBuilder children = new StringBuilder();
        for (int i = 0, j = 1; j < String.valueOf(n).length(); i += 2, j += 2) {
            int a = getParsedInteger(n, i);
            int b = getParsedInteger(n, j);
            children.append(a + b);
        }
        return children;
    }

    private Boolean checkMediumValue(int n) {
        if (String.valueOf(n).length() == 3) {
            String vN = String.valueOf(n);
            String h = vN.substring(0, vN.length() / 2);
            String l = vN.substring(vN.length() / 2);

            h = h + l.charAt(0) + l;
            return isPalindrome(Integer.parseInt(h));
        }
        return null;
    }

    private Boolean checkSmallValue(int n) {
        if (String.valueOf(n).length() == 2) {
            if (String.valueOf(n).charAt(0) == String.valueOf(n).charAt(1))
                return true;

            int left = getParsedInteger(n, 0);
            int right = getParsedInteger(n, 1);
            String s = String.valueOf(left + right);
            return s.length() == 2 && s.charAt(0) == s.charAt(1);
        }
        return null;
    }

    private int getParsedInteger(int n, int x) {
        return Integer.parseInt(String.valueOf(String.valueOf(n).charAt(x)));
    }

    private String getStartingChars(StringBuilder children) {
        return children.toString().substring(0, children.length() / 2);
    }

    private String getEndingChars(StringBuilder children) {
        return children.toString().substring(children.length() / 2, children.length());
    }

    @Override
    public void show() {
        System.out.println(palindromeDescendant(6));
        System.out.println(palindromeDescendant(1122));
        System.out.println(palindromeDescendant(123312));
        System.out.println(palindromeDescendant(11211230));
        System.out.println(palindromeDescendant(23336014));
        System.out.println(palindromeDescendant(11));
    }
}
