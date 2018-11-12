package com.learning.arrays;

public class Task12274 {

    /**
     * method gets odd characters from the array line and connects them in a word
     *
     * @param array 2 dimensional char array that you want work with
     * @return
     */
    public StringBuilder getOddWords(char[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("reference to null is not acceptable");
        }

        StringBuilder result = new StringBuilder("odd word is: ");
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[i].length; j = j + 2) {
                result.append(array[i][j]);
            }
            result.append(" ");
        }
        return result;
    }
}
