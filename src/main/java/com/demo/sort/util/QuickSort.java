package com.demo.sort.util;

import java.util.Collection;
import java.util.List;

import com.google.common.primitives.Ints;

/**
 * An implementation of the <a href="https://en.wikipedia.org/wiki/Quicksort">Quicksort</a> algorithm.
 */
public class QuickSort {

    public static List<Integer> sort(Collection<? extends Number> ints) {

        int arr[] = Ints.toArray(ints);
        int begin = 0;
        int end = ints.size() - 1;

        quickSort(arr, begin, end);

        return Ints.asList(arr);
    }

    private static void quickSort(int arr[], int begin, int end) {

        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {

        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
}
