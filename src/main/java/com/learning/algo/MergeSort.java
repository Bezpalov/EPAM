package com.learning.algo;

import java.util.Arrays;

public class MergeSort implements Sorting {
    @Override
    public int[] sort(int[] array) {
        int length = array.length;
        int[] sortedArr;
        if (length < 2)
            return array;
        int separate = length / 2;
        int[] leftArr = Arrays.copyOf(array, separate);
        int[] rigthArr = Arrays.copyOfRange(array, separate, length);
        sortedArr = merge(sort(leftArr), sort(rigthArr));
        return sortedArr;
    }

    /**
     * Method for merging two parts of initial array
     * @param left sorted array that need to be merged
     * @param right sorted array that need to be merged
     * @return sorted array of ints
     */
    private int[] merge(int[] left, int[] right) {
        int[] sortingArr = new int[left.length + right.length];
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < sortingArr.length; i++) {
            if (leftCount == left.length) {
                sortingArr[i] = right[rightCount];
                rightCount++;
            } else if (rightCount == right.length) {
                sortingArr[i] = left[leftCount];
                leftCount++;
            } else if (left[leftCount] < right[rightCount]) {
                sortingArr[i] = left[leftCount];
                leftCount++;
            } else {
                sortingArr[i] = right[rightCount];
                rightCount++;
            }
        }
        return sortingArr;
    }

    @Override
    public String toString() {
        return "MergeSort";
    }
}
