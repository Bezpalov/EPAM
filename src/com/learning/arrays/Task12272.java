package com.learning.arrays;

import java.util.ArrayList;
import java.util.List;

public class Task12272 {

    public String getLeftToRigth(char[][] array) {
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
        return new String(list.toArray().toString());
    }

    public String getUpToDown(char[][] array) {
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
        return new String(list.toArray().toString());
    }
}
