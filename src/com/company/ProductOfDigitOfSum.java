package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

/**
 * function that takes numbers as arguments, adds them together,
 * and returns the product of digits until the answer is only 1 digit long.
 */
public class ProductOfDigitOfSum extends Challenge {

    private int sumDigProd(int... args) {
        Integer a = getIfArgsLengthEqualsOne(args);
        if (a != null) return a;

        int sumOfDigits = getSumOfInitialAddition(args);
        String product = multiplicativeReducer(sumOfDigits);

        while (String.valueOf(product).length() > 1)
            product = multiplicativeReducer(Integer.parseInt(product));


        return Integer.parseInt(product);
    }

    private int getSumOfInitialAddition(int[] args) {
        var sumOfDigits = 0;
        for (var i = 0; i < args.length; i++)
            if (i != args.length - 1)
                sumOfDigits += args[i];
            else
                sumOfDigits += args[args.length - 1];

        return sumOfDigits;
    }

    private Integer getIfArgsLengthEqualsOne(int[] args) {
        if (args.length == 1) {
            String[] a = getStringsWithoutBrackets(args);
            if (a.length == 3)
                return Integer.parseInt(a[1]);
            else {
                Arrays.sort(a);
                if (Integer.parseInt(a[2]) == Integer.parseInt(a[a.length - 1]))
                    return Integer.parseInt(a[2]);
            }
        }
        return null;
    }

    private String multiplicativeReducer(int n) {
        Optional<String> oI = Arrays.stream(getIntArray(n))
                .reduce((a, b) -> String.valueOf(Integer.parseInt(a) * Integer.parseInt(b)));


        return oI.orElseGet(() -> String.valueOf(true));
    }

    private String[] getStringsWithoutBrackets(int[] args) {
        return Arrays.toString(args).replace('[', (char) 0)
                .replace(']', (char) 0).split("");
    }

    private String[] getIntArray(int n) {
        return String.valueOf(n).split("");
    }


    @Override
    public void show() {
        System.out.println(sumDigProd(111111111));
        System.out.println(sumDigProd(6));
        System.out.println(sumDigProd(8, 16, 89, 3));
        System.out.println(sumDigProd(16, 28));
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println(sumDigProd(0));
    }
}
