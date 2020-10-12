package com.company;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * Suppose a pair of identical characters serve as book ends for all characters in between them
 * returns the total number of unique characters (books, so to speak) between all pairs of book ends.
 */
public class BookEnd extends Challenge {
    private String books;
    private char bookend;
    private ArrayList<Integer> counts = new ArrayList<>();
    private int count = 1;

    int countUniqueBooks(String books, char bookend) {
        this.books = books;
        this.bookend = bookend;

        ArrayList<Integer> indexOfList = getBookendIndexes();
        HashSet<String> booksInBetween = getBooksInBetween(indexOfList);

        return getCounts(booksInBetween).stream().mapToInt(Integer::intValue).sum();
    }

    private ArrayList<Integer> getBookendIndexes() {
        var indexOfList = new ArrayList<Integer>();
        for (int i = 0; i < books.length(); i++)
            if (books.charAt(i) == bookend)
                indexOfList.add(i);

        return indexOfList;
    }

    private HashSet<String> getBooksInBetween(ArrayList<Integer> indexOfList) {
        var booksInBetween = new ArrayList<String>();
        for (var i = 0; i < indexOfList.size() - 1; i += 2) {
            String s = books.substring(indexOfList.get(i) + 1, indexOfList.get(i + 1));
            if (!s.equalsIgnoreCase(""))
                booksInBetween.add(s);
        }
        return new HashSet<>(booksInBetween);
    }

    private ArrayList<Integer> getCounts(HashSet<String> booksInBetween) {
        for (String s : booksInBetween) {
            if (s.length() >= 2)
                countLargeBookendGroup(s);
            else
                counts.add(1);

            count = 1;
        }
        return counts;
    }

    private void countLargeBookendGroup(String s) {
        for (var i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) != s.charAt(i + 1))
                count++;

        counts.add(count);
    }

    @Override
    public void show() {
//        System.out.println(countUniqueBooks("&3&3&3&", '&'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
//        System.out.println(countUniqueBooks("A#BBCD##GGA##!#", '#'));
    }

}
