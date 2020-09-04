package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var a = new ArrayList<Integer>(List.of(1, 2, 4, 5, 6, 7, 7, 8));

        var r = a.stream()
                .reduce(Integer::sum);

        System.out.println(r.get());
    }

}
