package com.learning.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task12272 {

    public static char[] listToArray(List<Character> list) {

        char[] result = new char[list.size()];
        int i = 0;
        for (Character character : list) {
            result[i] = character;
            i++;
        }
        return result;
    }


    public StringBuilder getLeftToRigth(char[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("reference to null is not acceptable");
        } else if (array.length < 2 || array[0].length < 2 || array[array.length - 1].length < 2) {
            throw new IllegalArgumentException("length of arrays must be more than 1");
        }

        int begin;
        boolean isEven = false;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {

            isEven = !isEven;
            if (isEven) {
                begin = 0;
            } else {
                begin = 1;
            }

            for (int j = begin; j < array[i].length; j = j + 2) {
                list.add(array[j][i]);
            }
        }
        StringBuilder result = new StringBuilder("left to right word is ");
        char[] temp = listToArray(list);
        return result.append(temp).append("\n");
    }

    public StringBuilder getUpToDown(char[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("reference to null is not acceptable");
        } else if (array.length < 2 || array[0].length < 2 || array[array.length - 1].length < 2) {
            throw new IllegalArgumentException("length of arrays must be more than 1");
        }

        int begin;
        boolean isEven = false;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {

            isEven = !isEven;
            if (isEven) {
                begin = 0;
            } else {
                begin = 1;
            }

            for (int j = begin; j < array[i].length; j = j + 2) {
                list.add(array[i][j]);
            }
        }
        StringBuilder result = new StringBuilder("up to down word is ");
        char[] temp = listToArray(list);
        return result.append(temp).append("\n");
    }
}
