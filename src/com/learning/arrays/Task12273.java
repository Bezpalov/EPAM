package com.learning.arrays;

public class Task12273 {

    public StringBuilder getEvenWords(char[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("reference to null is not acceptable");
        }

        StringBuilder result = new StringBuilder("Even words is: ");
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array[i].length; j = j + 2) {
                result.append(array[i][j]);
            }
            result.append(" ");
        }
        return result;
    }
}
