package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PoppingBlocks extends Challenge {

    private static void popOff(char[] charArray) {
        var popArray = new ArrayList<Character>();
        var arr = new ArrayList<Character>();

        for (var i : charArray) {
            popArray.add(i);
        }

        for (int i = 0, j = 1; i < popArray.size(); i++, j++) {
            char curr = popArray.get(i);
            char next = i != popArray.size() - 1 ? popArray.get(j) : popArray.get(i);

            if (Character.valueOf(next) == Character.valueOf(curr)) {
                arr.add(curr);
                arr.add(next);
                curr = next;
                next = j != popArray.size() - 1 ? popArray.get(j + 1) : popArray.get(j);
                i++;
                j++;
                if (j != popArray.size() - 1 && Character.valueOf(curr) == Character.valueOf(next)) {
                    arr.add(next);
                }
            }
        }
        arr.forEach(System.out::println);
    }

    private static boolean moreThanTwo(char curr, char next) {
        return false;
    }


    @Override
    public void show() {
        popOff(new char[]{'A', 'B', 'A', 'A', 'A', 'B', 'B'});
    }
}
