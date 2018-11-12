package com.learning.arrays;

public class Task12270 {

    /**
     * Method get 4 chars from corners of the 2 dimensional array
     * and return them
     *
     * @param array 2 dimensional char array that you want work with
     * @return StringBuilder representation of result
     */
    public StringBuilder getCorners(char[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("reference to null is not acceptable");
        } else if (array.length < 2 || array[0].length < 2 || array[array.length - 1].length < 2) {
            throw new IllegalArgumentException("length of arrays must be more than 1");
        }

        StringBuilder result = new StringBuilder("Symbols from corners: ");
        char[] answer = {array[0][0],
                array[0][array[0].length - 1],
                array[array.length - 1][0],
                array[array.length - 1][array[array.length - 1].length - 1]};
        return result.append(answer);
    }
}
