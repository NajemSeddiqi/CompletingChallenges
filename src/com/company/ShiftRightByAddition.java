package com.company;


/**
 * a recursive function that mimics the shift right operator and returns the result from the two given integers
 */
public class ShiftRightByAddition extends Challenge {

    int shiftRight(int x, int y) {
        if (y == 0)
            return x;

        while (y > 1) {
            return shiftRight(x / 2, y - 1);
        }

        return (int) Math.floor((x >> 1));
    }

    @Override
    public void show() {
        System.out.println(shiftRight(80, 3));
        System.out.println(shiftRight(-24, 2));
        System.out.println(shiftRight(-5, 1));
    }
}
