package com.company;

import java.util.Arrays;

class ReverseOddLengthWords {

    /*System.out.println(ReverseOddLengthWords.ReverseTheOddOnes("Make sure you only reverse words of odd length"));
     * reverse all the words which have odd length. The even length words are not changed
     * */
    static String ReverseTheOddOnes(String str) {
        var strArray = str.split(" ");
        var correctString = new StringBuilder();
        StringBuilder stringBuilder;

        for (var i : strArray) {
            if (i.length() % 2 != 0) {
                stringBuilder = new StringBuilder(i).reverse().append(" ");
            } else {
                stringBuilder = new StringBuilder().append(i).append(" ");
            }
            correctString.append(stringBuilder);
        }

        return correctString.toString();
    }
}
