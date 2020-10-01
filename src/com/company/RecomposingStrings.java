package com.company;

public class RecomposingStrings extends Challenge {
    private StringBuilder recomposedSb = new StringBuilder();

    String recompose(String str) {

        for (var i = 0; i < str.length(); ) {
            var consonantIdx = 1;
            var vowelIdx = 1;

            if (!isVowel(Character.toLowerCase(str.charAt(i)))) {
                var sb = new StringBuilder(String.valueOf(str.charAt(i)));
                if (doWhenAtLastIndex(str, i, sb)) break;

                var data = new Data(str, i, consonantIdx, sb);
                data.setNucleiIndex(getConsonantIndex(data));

                sb.reverse();
                recomposedSb.insert(data.getLoopIndex(), data.getStringBuilder().toString());

                i = getAccurateIndex(data.getLoopIndex(), data.getNucleiIndex());
            }

            if (isVowel(Character.toLowerCase(str.charAt(i)))) {
                var sb = new StringBuilder(String.valueOf(str.charAt(i)));
                if (doWhenAtLastIndexForShorterWord(str, i, sb)) break;

                var data = new Data(str, i, vowelIdx, sb);
                data.setNucleiIndex(getVowelIndex(data));

                sb.reverse();
                recomposedSb.insert(data.getLoopIndex(), data.getStringBuilder().toString());

                i = getAccurateIndex(data.getLoopIndex(), data.getNucleiIndex());
            }
        }

        addSpaceBetweenWords();

        return recomposedSb.toString();
    }

    private void addSpaceBetweenWords() {
        for (var i = 1; i < recomposedSb.length(); i++)
            if (Character.isUpperCase(recomposedSb.charAt(i))) {
                recomposedSb.insert(i, " ");
                i++;
            }
    }

    private int getVowelIndex(Data data) {
        while (isVowel(Character.toLowerCase(data.getStr().charAt(data.loopIndex + data.getNucleiIndex())))) {
            buildString(data);
            if (data.getStr().charAt(data.loopIndex + data.getNucleiIndex()) == data.getStr().charAt(data.getStr().length() - 1))
                break;
            else {
                var idx = data.getNucleiIndex();
                idx++;
                data.setNucleiIndex(idx);
            }
        }
        return data.getNucleiIndex();
    }

    private int getConsonantIndex(Data data) {
        while (!isVowel(Character.toLowerCase(data.getStr().charAt(data.loopIndex + data.nucleiIndex)))) {
            buildString(data);
            if (data.getStr().charAt(data.loopIndex + data.getNucleiIndex()) == data.getStr().charAt(data.getStr().length() - 1))
                break;
            else {
                var idx = data.getNucleiIndex();
                idx++;
                data.setNucleiIndex(idx);
            }
        }
        return data.getNucleiIndex();
    }

    private void buildString(Data data) {
        data.getStringBuilder().insert(data.nucleiIndex, data.getStr().charAt(data.getLoopIndex() + data.getNucleiIndex()));
    }

    private int getAccurateIndex(int i, int idx) {
        for (var j = 0; j < idx; j++)
            i++;
        return i;
    }

    private boolean doWhenAtLastIndexForShorterWord(String str, int i, StringBuilder sb) {
        if (i == str.length() - 1) {
            sb.reverse();
            recomposedSb.insert(i, sb.toString());
            return true;
        }
        return false;
    }

    private boolean doWhenAtLastIndex(String str, int i, StringBuilder sb) {
        if (i == str.length() - 1) {
            if (recomposedSb.charAt(recomposedSb.length() - 2) == str.charAt(str.length() - 1))
                return true;
            sb.reverse();
            recomposedSb.insert(i, sb.toString());
            return true;
        }
        return false;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


    @Override
    public void show() {
        System.out.println(recompose("hCemicarBlohtesr"));
        System.out.println(recompose("KiKdaola"));
        System.out.println(recompose("AhpewTxin"));
    }


    private class Data {
        private String str;
        private int loopIndex;
        private int nucleiIndex;
        private StringBuilder stringBuilder;

        Data(String str, int loopIndex, int nucleiIndex, StringBuilder stringBuilder) {
            this.str = str;
            this.loopIndex = loopIndex;
            this.nucleiIndex = nucleiIndex;
            this.stringBuilder = stringBuilder;
        }

        String getStr() {
            return str;
        }

        int getLoopIndex() {
            return loopIndex;
        }

        int getNucleiIndex() {
            return nucleiIndex;
        }

        void setNucleiIndex(int nucleiIndex) {
            this.nucleiIndex = nucleiIndex;
        }

        StringBuilder getStringBuilder() {
            return stringBuilder;
        }

    }
}


