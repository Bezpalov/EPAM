package com.learning.arrays;

public class Task12270 {

    public String getCorners(char[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("reference to null is not acceptable");
        } else if (array.length < 2 || array[0].length < 2 || array[array.length -1].length < 2) {
            throw new IllegalArgumentException("length of arrays must be more than 1");
        }

        char[] result = {array[0][0],
                array[0][array[0].length - 1],
                array[array.length - 1][0],
                array[array.length - 1][array[array.length - 1].length - 1]};
        return new String(result);
    }
}
