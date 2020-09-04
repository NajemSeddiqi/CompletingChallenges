package com.company;


public class PoppingBlocks extends Challenge {

    /*
    When two blocks of the same "type" are adjacent to each other, the entire contiguous block
    disappears (pops off). If this occurs, this can allow previously separated blocks to be in
    contact with each other, setting off a chain reaction
     */
    private char[] popOff(char[] charArray) {
        StringBuilder sb = new StringBuilder(new String(charArray));

        int index = getRepeatingIndexOfChar(sb.toString());
        while (index != -1) {
            int indexOfLastRepeatingChar = index;

            while (indexOfLastRepeatingChar < sb.length() && sb.charAt(indexOfLastRepeatingChar) == sb.charAt(index))
                indexOfLastRepeatingChar++;

            sb.delete(index, indexOfLastRepeatingChar);
            index = getRepeatingIndexOfChar(sb.toString());
        }
        return sb.toString().toCharArray();


    }

    private int getRepeatingIndexOfChar(String s) {
        for (var i = 0; i < s.length() - 1; i++) {
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            if (curr == next)
                return i;
        }
        return -1;
    }


    @Override
    public void show() {
        System.out.println(popOff(new char[]{'A', 'B', 'A', 'A', 'A', 'B', 'B', 'C', 'B', 'C',
                'C'}));
    }

}
