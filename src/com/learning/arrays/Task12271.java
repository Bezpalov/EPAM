package com.learning.arrays;

public class Task12271 {


    public StringBuilder getWord(char[][] array, int numOfLine, int begin, int end) {
        if (array == null) {
            throw new IllegalArgumentException("reference to null is not acceptable");
        } else if (numOfLine >= array.length || numOfLine < 0) {
            throw new IllegalArgumentException("invalid number of line, should be positive and less than array length ");
        } else if (begin < 0 || end > array[numOfLine].length) {
            throw new IllegalArgumentException("indexes are out of array borders");
        } else if (begin > end) {
            throw new IllegalArgumentException("begin index should be less than end index");
        }

        StringBuilder result = new StringBuilder("a substring from " + numOfLine + " string is ");
        int length = end - begin + 1;
        char[] chars = new char[length];
        for (int i = begin, j = 0; i <= end; i++, j++) {
            chars[j] = array[i][numOfLine];
        }
        return result.append(chars).append("\n");
    }
}
