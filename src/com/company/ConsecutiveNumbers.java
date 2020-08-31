package com.company;

import java.util.Arrays;


class ConsecutiveNumbers extends Challenge {

    /* function that determines whether elements in an array can be re-arranged to form a
     * consecutive list of numbers where each number appears exactly once.
     * O(n)?
     * */
    private static boolean consecutiveNumbers(int[] numbers) {
        var noDups = Arrays.stream(numbers).distinct();
        if (noDups.count() != numbers.length) return false;

        var consecutive = false;
        Arrays.sort(numbers);

        for (int i = 0, j = 1; i < numbers.length; i++, j++) {
            var curr = numbers[i];
            var next = numbers[j];

            if (!isOneLess(curr, next)) break;

            if (j == numbers.length - 1 && isOneLess(curr, next)) {
                consecutive = true;
                break;
            }
        }
        return consecutive;
    }

    private static boolean isOneLess(int current, int next) {
        return next - current == 1;
    }


    @Override
    public void show() {
        System.out.println(ConsecutiveNumbers.consecutiveNumbers(new int[]{5, 1, 4, 3, 2, 6}));
    }
}
