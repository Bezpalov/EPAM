package com.learning.algo;

import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting {
    @Override
    public int[] sort(int[] array) {
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        boolean flag = false;
        int tmp = -1, divisor = 1;
        while (!flag) {
            flag = true;
            for (Integer i : array) {
                tmp = i / divisor;
                buckets[tmp % 10].add(i);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }
            int a = 0;
            for (int b = 0; b < 10; b++) {
                for (Integer i : buckets[b]) {
                    array[a++] = i;
                }
                buckets[b].clear();
            }
            divisor *= 10;
        }
        return array;
    }

    @Override
    public String toString() {
        return "RadixSort";
    }
}
