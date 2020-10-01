package com.company;

import java.util.*;


/**
 * selects all words that have all the same vowels (in any order and/or number) as the first word,
 * including the first word.
 * Frequency does not matter e.g. if the first word is "loopy",
 * then you can include words with any number of o's, so long as they only
 * contain o's, and not any other vowels.
 */
public class VowelFamilies extends Challenge {

    private String[] sameVowelGroup(String[] strings) {
        var everyVowel = new HashMap<Integer, HashSet<Character>>();
        var families = new ArrayList<>(Collections.singleton(strings[0]));

        for (var i = 0; i < strings.length; i++)
            for (var j = 0; j < getVowels(strings[i]).size(); j++)
                everyVowel.put(i, getVowels(strings[i]));

        addMatchingFamilies(families, everyVowel, strings);
        return families.toArray(new String[0]);
    }

    private void addMatchingFamilies(ArrayList<String> families, HashMap<Integer, HashSet<Character>> everyVowel, String[] strings) {
        for (var i = 1; i < everyVowel.size(); i++)
            if (everyVowel.get(0).equals(everyVowel.get(i)))
                families.add(strings[i]);
    }

    private HashSet<Character> getVowels(String str) {
        var vowels = new HashSet<Character>();

        for (var i = 0; i < str.length(); i++)
            if (isVowel(str.charAt(i)))
                vowels.add(str.charAt(i));

        return vowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    @Override
    public void show() {
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"})));
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"})));
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"})));
    }
}
