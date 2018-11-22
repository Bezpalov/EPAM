package com.learning.algo;

public interface Sorting {
    /**
     * Method for sorting array in ascending order
     * @param array array for sorting
     * @return sorted array
     */
    int[] sort(int[] array);

    default void swap(int[] array, int from, int to) {
        int temp = array[to];
        array[to] = array[from];
        array[from] = temp;
    }
}
