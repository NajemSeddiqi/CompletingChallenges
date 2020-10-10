package com.company;

import java.util.*;

/**
 * function that returns true if exactly one word in the array differs in length from the rest.
 * Return false in all other cases
 * oddOneOut(["silly", "mom", "let", "the"]) ➞ true
 * oddOneOut(["swanky", "rhino", "moment"]) ➞ true
 * oddOneOut(["the", "them", "theme"]) ➞ false
 * oddOneOut(["very", "to", "an", "some"]) ➞ false
 */
public class OddOneOut extends Challenge {

    private boolean oddOneOut(String[] words) {
        var lengthArray = new ArrayList<Integer>();
        var result = new HashMap<Integer, Integer>();

        for (String word : words) lengthArray.add(word.length());
        lengthArray.forEach(n -> result.put(n, Collections.frequency(lengthArray, n)));

        return getAnswer(words, result);
    }

    private boolean getAnswer(String[] words, HashMap<Integer, Integer> result) {
        boolean answer = false;
        for (Map.Entry<Integer, Integer> e : result.entrySet())
            if (words.length - 1 == e.getValue()) {
                answer = true;
                break;
            }
        return answer;
    }

    @Override
    public void show() {
        System.out.println(oddOneOut(new String[]{"silly", "mom", "let", "the"}));
        System.out.println(oddOneOut(new String[]{"swanky", "rhino", "moment"}));
        System.out.println(oddOneOut(new String[]{"the", "them", "theme"}));
        System.out.println(oddOneOut(new String[]{"very", "to", "an", "some"}));
    }
}
