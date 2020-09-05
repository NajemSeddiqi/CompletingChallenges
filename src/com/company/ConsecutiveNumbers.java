package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;


/**
 * function that determines whether elements in an array can be re-arranged to form a
 * consecutive list of numbers where each number appears exactly once.
 * O(n)?
 */
class ConsecutiveNumbers extends Challenge {

    private boolean consecutiveNumbers(int[] numbers) {
        IntStream noDups = Arrays.stream(numbers).distinct();
        if (noDups.count() != numbers.length) return false;
        Arrays.sort(numbers);
        return loopThroughNumbersAndVerify(numbers);
    }

    private boolean loopThroughNumbersAndVerify(int[] numbers) {
        var consecutive = false;
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

    private boolean isOneLess(int current, int next) {
        return next - current == 1;
    }

    @Override
    public void show() {
        System.out.println(consecutiveNumbers(new int[]{5, 1, 4, 3, 2, 6}));
    }
}
