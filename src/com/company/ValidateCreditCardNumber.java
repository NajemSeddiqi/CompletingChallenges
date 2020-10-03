package com.company;

import java.util.ArrayList;

/**
 * Credit card numbers must be between 14-19 digits in length, and pass the Luhn test
 */
public class ValidateCreditCardNumber extends Challenge {

    private boolean validateCard(long number) {
        String strNum = Long.valueOf(number).toString();
        if (strNum.length() < 14 || strNum.length() > 19) return false;

        int checkDigit = Integer.parseInt(strNum.substring(strNum.length() - 1));
        var n = new StringBuilder(strNum.substring(0, strNum.length() - 1)).reverse();
        String[] nArray = n.toString().split("");

        var doubledOdds = new ArrayList<Integer>();
        recomposeDigits(nArray, doubledOdds);

        int sum = additiveReducer(doubledOdds);
        int confirmCheckDigit = 10 - Integer.parseInt(String.valueOf(String.valueOf(sum).charAt(1)));

        return confirmCheckDigit == checkDigit;
    }

    private void recomposeDigits(String[] nArray, ArrayList<Integer> doubledOdds) {
        for (var i = 0; i < nArray.length; i++)
            if (i % 2 == 0) {
                String doubled = String.valueOf(Integer.parseInt(nArray[i]) * 2);
                if (doubled.length() > 1)
                    doubled = getDoubledOddOne(doubled);

                doubledOdds.add(Integer.parseInt(doubled));
            } else {
                doubledOdds.add(Integer.parseInt(nArray[i]));
            }

    }

    private String getDoubledOddOne(String doubled) {
        int firstIdx = Integer.parseInt(String.valueOf(doubled.charAt(0)));
        int secondIdx = Integer.parseInt(String.valueOf(doubled.charAt(1)));
        return String.valueOf(firstIdx + secondIdx);
    }

    private Integer additiveReducer(ArrayList<Integer> a) {
        return a.stream().reduce(Integer::sum).orElse(0);
    }


    @Override
    public void show() {
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(79927398713L));
    }
}
