package com.learning.algo;

import java.util.Arrays;

public class QuickSort implements Sorting {
    @Override
    public int[] sort(int[] array) {
        if (array.length < 2)
            return array;

        int lenght = array.length;
        int pivot = array[0];
        int left = 1;
        int right = lenght - 1;
        int leftTemp;
        int rightTemp;

        while (left < right) {
            leftTemp = array[left];
            rightTemp = array[right];
            if (leftTemp >= pivot && rightTemp < pivot) {
                swap(array, left, right);
            } else if (leftTemp < pivot && rightTemp > pivot) {
                right--;
                left++;
                continue;
            } else if (leftTemp >= pivot) {
                right--;
                continue;
            } else {
                left++;
                continue;
            }
            left++;
            right--;
        }
        if (pivot > array[right])
            swap(array, right, 0);
        int[] leftHalf = Arrays.copyOf(array, right);
        int[] rightHalf = Arrays.copyOfRange(array, right, lenght);
        leftHalf = sort(leftHalf);
        rightHalf = sort(rightHalf);
        int[] result = new int[leftHalf.length + rightHalf.length];

        for (int i = 0; i < leftHalf.length; i++) {
            result[i] = leftHalf[i];
        }
        int j = 0;
        for (int i = leftHalf.length; i < result.length; i++) {
            result[i] = rightHalf[j];
            j++;
        }
        return result;
    }

    @Override
    public String toString() {
        return "QuickSort";
    }
}
