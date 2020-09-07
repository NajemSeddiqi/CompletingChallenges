package com.company;

import java.util.*;

/**
 * Returns an integers additive and multiplicative persistence
 */
public class Persistence extends Challenge {

    private int additivePersistence(int n) {
        return reduceIfNotSingleDigit(n, true);
    }

    private int multiplicativePersistence(int n) {
        return reduceIfNotSingleDigit(n, false);
    }


    private static int reduceIfNotSingleDigit(int n, boolean isAdditive) {
        if (String.valueOf(n).length() <= 1) return 0;

        String number = reducer(n, isAdditive);
        int count = 1;
        while (number.length() > 1) {
            count++;
            number = reducer(Integer.parseInt(number), isAdditive);
        }
        return count;
    }

    private static String reducer(int n, boolean isAdditive) {
        return isAdditive ? additiveReducer(n) : multiplicativeReducer(n);
    }

    private static String multiplicativeReducer(int n) {
        Optional<String> oI = Arrays.stream(getIntArray(n))
                .reduce((a, b) -> String.valueOf(Integer.parseInt(a) * Integer.parseInt(b)));

        return oI.orElseGet(() -> String.valueOf(true));
    }

    private static String additiveReducer(int n) {
        Optional<String> oI = Arrays.stream(getIntArray(n))
                .reduce((a, b) -> String.valueOf(Integer.parseInt(a) + Integer.parseInt(b)));

        return oI.orElseGet(() -> String.valueOf(true));
    }

    private static String[] getIntArray(int n) {
        return String.valueOf(n).split("");
    }


    @Override
    public void show() {
        System.out.println(additivePersistence(1679583));
        System.out.println(multiplicativePersistence(123456));
    }
}
