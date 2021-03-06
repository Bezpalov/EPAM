package com.learning.arrays;

/**
 * Utility class to help with actions with arrays
 */
public class ArrayHelper {

    /**
     * @return 2 dimensional char array filled pseudo random
     * values from 'a' to 'z'
     */
    public static char[][] getTwoDimensionalArray() {
        char[][] array = new char[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                long element = Math.round(Math.random() * 25);
                array[i][j] = (char) (65 + element);
            }
        }
        return array;
    }

    /**
     * @param array 2 dimensional char array that you want to display
     */
    public static void showArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
    }

    /**
     * @param array 2 dimensional char array that you want work with
     * @return String representation of result
     */
    public String execute(char[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Null is unacceptable");
        }
        showArray(array);
        System.out.println();

        StringBuilder result = new StringBuilder();
        try {
            result.append(new Task12270().getCorners(array)).append("\n");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            int numLine = (int) (Math.round(Math.random() * 5));
            int begin = (int) (Math.round(Math.random() * 2));
            int end = 2 + (int) (Math.round(Math.random() * 2));
            result.append(new Task12271().getWord(array, numLine, begin, end)).append("\n");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            result.append(new Task12272().getLeftToRigth(array)).append("\n");
            result.append(new Task12272().getUpToDown(array)).append("\n");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            result.append(new Task12273().getEvenWords(array)).append("\n");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            result.append(new Task12274().getOddWords(array)).append("\n");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return result.toString();
    }
}
