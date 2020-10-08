package com.company;

import java.util.*;

/**
 * a function that takes in an array of already-guessed words,
 * the unscrambled 6-letter word and returns the total number of points a player scored in a particular round using the following rubric:
 * 3-letter words are 1 pt
 * 4-letter words are 2 pts
 * 5-letter words are 3 pts
 * 6-letter words are 4 pts + 50 pt bonus (for unscrambling the word)
 * words that cannot be formed from the 6-letter unscrambled words count as 0 pts i.e invalid words
 */
public class TextTwist extends Challenge {

    private int totalPoints(String[] words, String unScrambledWord) {
        var pointArray = new ArrayList<Integer>();

        for (String word : words) {
            int valid = 0;
            var sb = new StringBuilder(unScrambledWord);

            if (checkValidityOfSameLengthWord(unScrambledWord, pointArray, word))
                continue;

            valid = getValidEnteredWords(word, valid, sb);

            if (valid == word.length())
                pointArray.add(word.length());
        }

        return getPoints(pointArray);
    }

    private boolean checkValidityOfSameLengthWord(String unScrambledWord, ArrayList<Integer> pointArray, String word) {
        if (word.length() == unScrambledWord.length()) {
            if (isCorrect(word, unScrambledWord))
                pointArray.add(word.length());

            return true;
        }
        return false;
    }

    private int getValidEnteredWords(String word, int valid, StringBuilder sb) {
        for (var j = 0; j < word.length(); j++)
            if (sb.toString().contains(String.valueOf(word.charAt(j)))) {
                sb.deleteCharAt(sb.indexOf(String.valueOf(word.charAt(j))));
                valid++;
            }

        return valid;
    }

    private boolean isCorrect(String word, String unscrambled) {
        var map = new HashMap<String, Integer>();
        var map1 = new HashMap<String, Integer>();

        var wArray = new ArrayList<>(List.of(word.split("")));
        var uArray = new ArrayList<>(List.of(unscrambled.split("")));

        wArray.forEach(x -> map.put(x, Collections.frequency(wArray, x)));
        uArray.forEach(x -> map1.put(x, Collections.frequency(uArray, x)));

        return map.size() == map1.size();
    }

    private int getPoints(ArrayList<Integer> points) {
        int p = 0;
        for (int i : points) {
            switch (i) {
                case 3:
                    p += 1;
                    break;
                case 4:
                    p += 2;
                    break;
                case 5:
                    p += 3;
                    break;
                case 6:
                    p += 54;
                    break;
                default:
                    return 0;
            }
        }

        return p;
    }

    @Override
    public void show() {
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println(totalPoints(new String[]{"bluest", "sublet", "let", "set", "belt", "belts", "bet", "bets", "sted", "but",
                "tule"}, "subtle"));
        System.out.println(totalPoints(new String[]{"emote", "tome", "root"}, "meteor"));
    }
}
