package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A string is an almost-palindrome if, by changing only one character, you can make it a palindrome.
 * That is what the function is for, return true or false if string can become a palindrome by one simple change
 */
public class Palindrome extends Challenge {

    private static String firstHalf;
    private static String secondHalf;
    private static ArrayList<Character> resultList = new ArrayList<>();
    private static int changeAtIndex = 0;
    private static char diff = '0';

    private static boolean isAlmostPalindrome(String str) {
        firstHalf = str.substring(0, (str.length() / 2));
        secondHalf = new StringBuilder(str.substring((str.length() / 2))).reverse().toString();

        var result = oneSimpleChange().toArray();
        var leftSet = Arrays.copyOfRange(result, 0, result.length / 2);
        var rightSet = Arrays.copyOfRange(result, result.length / 2, result.length);
        boolean isEven = str.length() % 2 == 0;

        return isPalindrome(leftSet, rightSet, isEven);
    }

    private static ArrayList<Character> oneSimpleChange() {
        int length = Math.min(firstHalf.length(), secondHalf.length());
        addFirstHalfToResultList(length);
        addSecondHalfToResultList();
        return resultList;
    }

    private static void addFirstHalfToResultList(int length) {
        for (var i = 0; i < length; i++) {
            if (firstHalf.charAt(i) != secondHalf.charAt(i)) {
                changeAtIndex = i;
                diff = firstHalf.charAt(i);
            }
            resultList.add(firstHalf.charAt(i));
        }
    }

    private static void addSecondHalfToResultList() {
        for (var i = 0; i < secondHalf.length(); i++) {
            if (i == changeAtIndex) {
                resultList.add(diff);
                continue;
            }
            resultList.add(secondHalf.charAt(i));
        }
    }


    private static boolean isPalindrome(Object[] leftSet, Object[] rightSet, boolean isEven) {
        return isEven ? Arrays.equals(leftSet, rightSet) : Arrays.equals(leftSet, Arrays.copyOf(rightSet, rightSet.length - 1));
    }

    @Override
    public void show() {
        System.out.println(isAlmostPalindrome("abccia"));
        System.out.println(isAlmostPalindrome("abcdcbg"));
        System.out.println(isAlmostPalindrome("abcdaaa"));
    }
}
