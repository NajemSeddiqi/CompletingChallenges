package com.company;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Boom {

    /* System.out.println(Boom.sevenBoom(new int[]{7, 5555587, 60, 96, 86}));
     * return "Boom!" if the number 7 appears in the array.
     * O(n^2)?
     */
    static String sevenBoom(int[] numbers) {
        boolean contains = false;

        for (var i : stringifyIntArray(numbers)) {

            if (i.length() > 1) {

                for (var j : i.toCharArray()) {

                    if (Integer.parseInt(String.valueOf(j)) == 7) {
                        contains = true;
                        break;
                    }
                }
            } else if (Integer.parseInt(i) == 7) {
                contains = true;
                break;
            }
        }

        return contains ? "Boom!" : "There are no sevens!";
    }

    private static String[] stringifyIntArray(int[] numbers) {
        return IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")).split("");
    }
    //End
}
