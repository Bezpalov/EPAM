package com.learning.arrays;

public class Task12271 {
    private Integer min = Integer.MAX_VALUE;
    private Integer max = Integer.MIN_VALUE;

    private void getMinAndMax(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
    }

    public String getWord(char[][] array, int numOfLine, int... numbers) {
        if (array == null || numbers == null) {
            throw new IllegalArgumentException("reference to null is not acceptable");
        } else if (numOfLine >= array.length || numOfLine < 0) {
            throw new IllegalArgumentException("invalid number of line, should be positive and less than array length ");
        }
        getMinAndMax(numbers);
        if (array[numOfLine].length <= max || min < 0) {
            throw new IllegalArgumentException("invalid indexes: " + min + ", " + max);
        }

        char[] chars = new char[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            chars[i] = array[numOfLine][numbers[i]];
        }
        return new String(chars);
    }
}
