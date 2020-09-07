package com.company;

import java.util.ArrayList;


/**
 * An input string can be completed if additional letters can be added and no letters need to be taken away to match the word.
 * Furthermore, the order of the letters in the input string must be the same as the order of letters in the final word.
 */
public class CompleteWords extends Challenge {

    private static UserData userData;

    private static boolean canComplete(String input, String target) {
        if (input.charAt(0) != target.charAt(0)
                || input.charAt(input.length() - 1) != target.charAt(target.length() - 1)
                || containsInvalidDuplicates(input, target))
            return false;

        StringBuilder sb = new StringBuilder(input);
        userData = new UserData(input, target);
        completeTheWord(sb);

        return sb.toString().equalsIgnoreCase(target);
    }

    private static void completeTheWord(StringBuilder sb) {
        var idxArray = new ArrayList<Integer>();

        int i = 0, j = 0, insertAtIndex = 0;
        while (i != userData.getInput().length()) {
            setCurrAndNext(i, j);

            if (userData.getCurr() != userData.getNext()) {

                int currIndex = sb.toString().indexOf(userData.getNext());
                int targetIndex = getIfMultipleOccurrenceExists(idxArray, currIndex);
                idxArray.add(targetIndex);

                if (currIndex != targetIndex)
                    sb.insert(insertAtIndex, userData.getNext());

                j++;
                insertAtIndex++;
                continue;
            }
            i++;
        }
    }

    private static void setCurrAndNext(int i, int j) {
        userData.setCurr(userData.getInput().charAt(i));
        userData.setNext(userData.getTarget().charAt(j));
    }

    private static int getIfMultipleOccurrenceExists(ArrayList<Integer> idxArray, int currIndex) {
        return idxArray.contains(currIndex) ? getIndexOfSecondOccurrence() : getIndexOf();
    }

    private static int getIndexOf() {
        return userData.getTarget().indexOf(userData.getNext());
    }

    private static int getIndexOfSecondOccurrence() {
        return userData.getTarget().indexOf(userData.getNext(), userData.getTarget().indexOf(userData.getNext()) + 1);
    }


    private static boolean containsInvalidDuplicates(String input, String target) {
        boolean containsDuplicate = false;
        for (Long i : getAmountOfContains(input, target)) {
            if (i > 1) {
                containsDuplicate = true;
                break;
            }
        }
        return containsDuplicate;
    }

    private static ArrayList<Long> getAmountOfContains(String input, String target) {
        var amountOfContainsArray = new ArrayList<Long>();
        for (char i : target.toCharArray()) {
            long count = input.chars().filter(c -> c == i).count();
            if (count != 0)
                amountOfContainsArray.add(count);
        }
        return amountOfContainsArray;
    }

    @Override
    public void show() {
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful"));
        System.out.println(canComplete("sg", "something"));
        System.out.println(canComplete("sgi", "something"));
    }
}

class UserData {
    private char curr;
    private char next;
    private String input;
    private String target;

    public UserData(String input, String target) {
        this.input = input;
        this.target = target;
    }

    public char getCurr() {
        return curr;
    }

    public void setCurr(char curr) {
        this.curr = curr;
    }

    public char getNext() {
        return next;
    }

    public void setNext(char next) {
        this.next = next;
    }

    public String getInput() {
        return input;
    }

    public String getTarget() {
        return target;
    }

}
