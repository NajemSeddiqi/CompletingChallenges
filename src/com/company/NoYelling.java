package com.company;

import java.util.Arrays;

class NoYelling {

    /* System.out.println(NoYelling.stopYelling("That's a ton!! of cheese!!!!"));
    function that transforms sentences ending with multiple question marks ? or exclamation marks !
    into a sentence only ending with one without changing punctuation in the middle of the sentences.
    * */
    static String stopYelling(String str) {
        if (!str.contains("!") && !str.contains("?")) return str;

        var split = str.split(" ");
        var last = split[split.length - 1];

        var type = last.contains("!") ? '!' : '?';
        var marks = last.chars().filter(n -> n == type).count() - 1;

        var corrected = last.substring(0, (int) (last.length() - marks));

        return Arrays.toString(split)
                .replace(last, corrected)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();
    }

}
