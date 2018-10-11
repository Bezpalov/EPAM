package com.learning.arrays;

public class ArrayHelper {

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

    public static void showArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public String execute(char[][] array) {

        showArray(array);
        System.out.println();

        StringBuilder result = new StringBuilder();
        try {
            result.append(new Task12270().getCorners(array));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            int numLine = (int) (Math.round(Math.random() * 5));
            int begin = (int) (Math.round(Math.random() * 4));
            int end = (int) (Math.round(Math.random() * 4));
            result.append(new Task12271().getWord(array, numLine, begin, end));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            result.append(new Task12272().getLeftToRigth(array));
            result.append(new Task12272().getUpToDown(array));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            result.append(new Task12273().getEvenWords(array));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            result.append(new Task12274().getOddWords(array));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return result.toString();
    }
}
