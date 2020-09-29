package com.company;

import java.util.Arrays;

/**
 * function that transforms sentences ending with multiple question marks ? or exclamation points !
 * into a sentence only ending with one of either without changing punctuation in the middle of the sentence.
 */
class NoYelling extends Challenge {

    private String stopYelling(String str) {
        if (!str.contains("!") && !str.contains("?")) return "Why?";
        String[] sentence = str.split(" ");
        String lastStringInSentence = sentence[sentence.length - 1];
        String initialStrings = lastStringInSentence.substring(0, (int) (lastStringInSentence.length() - getAmountOfMarks(lastStringInSentence)));
        return getModifiedString(lastStringInSentence, initialStrings, sentence);
    }

    private long getAmountOfMarks(String lastStringInSentence) {
        char type = lastStringInSentence.contains("!") ? '!' : '?';
        return lastStringInSentence.chars().filter(n -> n == type).count() - 1;
    }

    private String getModifiedString(String lastStringInSentence, String initialStrings, String[] sentence) {
        return Arrays.toString(sentence)
                .replace(lastStringInSentence, initialStrings)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();
    }

    @Override
    public void show() {
        System.out.println(stopYelling("That's a!!! ton!! of cheese!!!!"));
    }
}
