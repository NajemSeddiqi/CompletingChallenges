package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Checks if each word's last letter is the first letter of the subsequent word
 * i.e. She eats super righteously -> true
 */
public class SmoothSentence extends Challenge {

    private static boolean isSmooth(String str) throws Exception {
        if (str.isBlank() || str.isEmpty())
            throw new Exception("Please no blanks.");

        String[] s = str.split(" ");
        return checkSmoothnessAndReturnList(s).size() >= s.length;
    }

    private static ArrayList<Boolean> checkSmoothnessAndReturnList(String[] s) {
        var isSmoothList = new ArrayList<Boolean>();
        isSmoothList.add(true);

        for (var i = 0; i < s.length; i++) {
            String curr = s[i];
            String next = i != s.length - 1 ? s[i + 1] : curr;
            var currChar = Character.toLowerCase(curr.charAt(curr.length() - 1));
            var nextChar = Character.toLowerCase(next.charAt(0));
            if (currChar == nextChar)
                isSmoothList.add(true);
        }
        return isSmoothList;
    }


    @Override
    public void show() {
        try {
            System.out.println(isSmooth("Marta appreciated deep perpendicular right trapezoids"));
            System.out.println(isSmooth("Someone is outside the doorway"));
            System.out.println(isSmooth("She eats super righteously"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
