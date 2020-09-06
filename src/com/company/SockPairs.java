package com.company;

import java.util.*;

/**
 * function that returns the number of pairs. A pair consists of two of the same letter
 */
public class SockPairs extends Challenge {

    private int getSockPairs(String str) {
        var original = new ArrayList<>(List.of(str.split("")));
        var result = new HashMap<String, Integer>();
        original.forEach(s -> result.put(s, Collections.frequency(original, s)));
        return countAndReturnPairs(result);
    }

    private int countAndReturnPairs(HashMap<String, Integer> result) {
        var count = 0;
        for (Map.Entry<String, Integer> e : result.entrySet()) {
            count++;
            if (e.getValue() % 2 != 0)
                count--;

            if (e.getValue() > 2) {
                count--;
                for (var i = 0; i < e.getValue(); i += 2)
                    count++;
            }
        }
        return count;
    }

    @Override
    public void show() {
        System.out.println(getSockPairs("CABBACCCCBBAA"));
        System.out.println(getSockPairs("CABBACCC"));
        System.out.println(getSockPairs("AACDE"));
        System.out.println(getSockPairs("ACDBE"));
        System.out.println(getSockPairs(""));
    }
}
