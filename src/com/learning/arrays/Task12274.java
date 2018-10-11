package com.learning.arrays;

public class Task12274 {

    public StringBuilder getOddWords(char[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("reference to null is not acceptable");
        }

        StringBuilder result = new StringBuilder("odd word is ");
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 1; j < array[i].length; j = j + 2) {
                result.append(array[i][j]);
            }
            result.append(" ").append("\n");
        }
        return result;
    }
}
