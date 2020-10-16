package com.company;

import java.util.ArrayList;

/**
 * The UPPERCASE/lowercase positions must be kept in the same order as the original string.
 * Spaces must be kept in the same order as the original string.
 * ("Edabit") ➞ "Tibade"
 * ("UPPER lower") ➞ "REWOL reppu"
 * ("1 23 456") ➞ "6 54 321"
 */
public class AccurateReversal extends Challenge {

    private final StringBuilder sb = new StringBuilder();

    private String specialReverseString(String str) {
        var spaceIndexes = new ArrayList<Integer>();
        var upperCaseIndexes = new ArrayList<Integer>();

        recomposeAccurately(str, spaceIndexes, upperCaseIndexes);
        sb.reverse();
        accurateRecomposing(spaceIndexes, upperCaseIndexes);

        return sb.toString();
    }

    private void recomposeAccurately(String str, ArrayList<Integer> spaceIndexes, ArrayList<Integer> upperCaseIndexes) {
        for (var i = 0; i < str.length(); i++)
            if (String.valueOf(str.charAt(i)).equalsIgnoreCase(" ")) {
                spaceIndexes.add(i);
            } else {
                if (Character.isUpperCase(str.charAt(i)))
                    upperCaseIndexes.add(i);

                char lowerCase = Character.toLowerCase(str.charAt(i));
                sb.append(lowerCase);
            }
    }

    private void accurateRecomposing(ArrayList<Integer> spaceIndexes, ArrayList<Integer> upperCaseIndexes) {
        for (var i = 0; i < sb.length(); i++) {
            insertUpperCases(upperCaseIndexes, i);
            insertSpaces(spaceIndexes, i);
        }
    }

    private void insertSpaces(ArrayList<Integer> spaceIndexes, int i) {
        for (Integer spaceIndex : spaceIndexes)
            if (i == spaceIndex)
                sb.insert(i, " ");

    }

    private void insertUpperCases(ArrayList<Integer> upperCaseIndexes, int i) {
        for (Integer upperCaseIndex : upperCaseIndexes)
            if (i == upperCaseIndex) {
                char upperCase = Character.toUpperCase(sb.charAt(i));
                sb.deleteCharAt(i);
                sb.insert(i, upperCase);
            }

    }

    @Override
    public void show() {
//        System.out.println(specialReverseString("1 23 456"));
//        System.out.println(specialReverseString("Edabit"));
//        System.out.println(specialReverseString("UPPER lower"));
        System.out.println(specialReverseString("Hello World!"));
    }
}
