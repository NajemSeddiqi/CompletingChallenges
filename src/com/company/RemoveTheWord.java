package com.company;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * a function that takes an array and string.
 * The function should remove the letters in the string from the array, and return the array
 */
public class RemoveTheWord extends Challenge {

    String[] removeLetters(String[] chars, String str) {
        var output = new ArrayList<String>();

        removeRelevantLetters(chars, str);

        for (String s : chars)
            if (s != null)
                output.add(s);

        return output.toArray(new String[0]);
    }

    private void removeRelevantLetters(String[] chars, String str) {
        for (var i = 0; i < str.length(); i++)
            for (var j = 0; j < chars.length; j++)
                if (String.valueOf(str.charAt(i)).equalsIgnoreCase(chars[j])) {
                    chars[j] = null;
                    break;
                }
    }

    @Override
    public void show() {
        System.out.println(Arrays.toString(removeLetters(new String[]{"s", "t", "r", "i", "n", "g", "w"}, "string")));
        System.out.println(Arrays.toString(removeLetters(new String[]{"b", "b", "l", "l", "g", "n", "o", "a", "w"}, "balloon")));
        System.out.println(Arrays.toString(removeLetters(new String[]{"d", "b", "t", "e", "a", "i"}, "edabit")));
    }
}
