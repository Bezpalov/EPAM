package com.learning.algo;

public class BinarySearch {
    /**
     * Realization of binary search in sorted array
     * @param array sorted array
     * @param number digit that you need to find
     * @return index of finding number or -1 if array
     *          doesn't contain it
     */
    public int search(int[] array, int number) {
        int begin = 0;
        int end = array.length - 1;
        int answer = -1;

        while (begin <= end) {
            int middle = (end + begin) / 2;
            if (array[middle] == number) {
                answer = middle;
                break;
            } else if (array[middle] > number) {
                end = middle - 1;
            } else if (array[middle] < number) {
                begin = middle + 1;
            }
        }
        return answer;
    }
}
