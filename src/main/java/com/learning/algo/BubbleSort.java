package com.learning.algo;

import java.util.Arrays;

public class BubbleSort implements Sorting {
    @Override
    public int[] sort(int[] array) {
            int length = array.length;
            int[] sortingArray = Arrays.copyOf(array, length);

            while(length > 0) {
                for (int i = 1; i < length; i++) {
                    if (sortingArray[i - 1] > sortingArray[i])
                        swap(sortingArray, i - 1, i);
                }
                length--;
            }
            return sortingArray;
    }

    @Override
    public String toString() {
        return "BubbleSort";
    }
}
