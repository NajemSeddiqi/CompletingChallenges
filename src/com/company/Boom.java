package com.company;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Boom extends Challenge {

    /* return "Boom!" if the number 7 appears in the array.
     *
     */
    private String sevenBoom(int[] numbers) {
        return Arrays.toString(numbers).contains("7") ? "Boom!" : "There are no sevens!";
    }

    @Override
    public void show() {
        System.out.println(sevenBoom(new int[]{7, 555557, 60, 96, 86}));
    }
}
