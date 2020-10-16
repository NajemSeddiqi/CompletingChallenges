package com.company;


import java.util.*;


/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 * It is also valid if he can remove just 1 character at 1 index in the string,
 * and the remaining characters will occur the same number of times
 */
public class SherlockValidation extends Challenge {

    String isValid(String str) {
        var a = new ArrayList<>(List.of(str.split("")));
        var occurrences = new HashMap<String, Integer>();
        a.forEach(x -> occurrences.put(x, Collections.frequency(a, x)));

        long distinctCount = occurrences
                .values()
                .stream()
                .distinct()
                .count();

        if (distinctCount == 1)
            return "YES";
        else if (distinctCount > 2)
            return "NO";

        int max = getMax(occurrences);
        int min = getMin(occurrences);
        long res = getRes(occurrences, max);

        return res == 1 && (max - min == 1) ? "YES" : "NO";
    }

    private int getMax(HashMap<String, Integer> occurrences) {
        return occurrences
                .values()
                .stream()
                .mapToInt(x -> x)
                .max().orElse(-1);
    }

    private int getMin(HashMap<String, Integer> occurrences) {
        return occurrences
                .values()
                .stream()
                .mapToInt(x -> x)
                .min().orElse(-1);
    }

    private long getRes(HashMap<String, Integer> occurrences, int max) {
        return occurrences
                .values()
                .stream()
                .filter(x -> x == max)
                .count();
    }


    @Override
    public void show() {
//        System.out.println(isValid("abc"));
//        System.out.println(isValid("abcc"));
//        System.out.println(isValid("aabbcd"));
//        System.out.println(isValid("aabbccddeefghi"));
//        System.out.println(isValid("abcdefghhgfedecba"));
    }
}
