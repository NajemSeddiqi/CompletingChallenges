package com.company;


/**
 * reverse all the words which have odd length. The even length words are not changed
 * O(n)
 */

class ReverseOddLengthWords extends Challenge {

    private String ReverseTheOddOnes(String str) {
        String[] strArray = str.split(" ");
        return getReversedWordString(strArray).toString();
    }

    private StringBuilder getReversedWordString(String[] strings) {
        var correctString = new StringBuilder();
        StringBuilder stringBuilder;

        for (var i : strings) {
            if (isStringLengthEven(i.length()))
                stringBuilder = new StringBuilder(i).append(" ");
            else
                stringBuilder = new StringBuilder(i).reverse().append(" ");

            correctString.append(stringBuilder);
        }
        return correctString;
    }

    private boolean isStringLengthEven(int length) {
        return length % 2 == 0;
    }

    @Override
    public void show() {
        System.out.println(ReverseTheOddOnes("Make sure you only reverse words of odd length"));
    }
}
