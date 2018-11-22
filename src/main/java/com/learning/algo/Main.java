package com.learning.algo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        new Main().letsStart();

    }

    public void letsStart() {
        Sorting[] sorts = createSetOfSorts();
        int number;
        for (Sorting s: sorts) {
            int[] randomArray = getRandomArray();
            System.out.println(s.toString());
            System.out.println("unsorted: " + Arrays.toString(randomArray));
            int[] sortedArray = s.sort(randomArray);
            System.out.println("sorted: " + Arrays.toString(sortedArray));
            number = (int)(Math.random()*100);
            System.out.println("searching of " + number + " in array");
            System.out.println("Place of a number is: " + new BinarySearch().search(sortedArray, number) +
                    "\n(if -1 than array doesn't contain this number\n");
        }
    }

    public int[] getRandomArray() {
        int[] unsorted = new int[10];

        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = (int)(Math.random()*100);
        }
        return unsorted;
    }

    public Sorting[] createSetOfSorts() {
        Sorting [] sorts = {new BubbleSort(), new MergeSort(), new QuickSort(), new RadixSort()};
        return sorts;
    }
}


