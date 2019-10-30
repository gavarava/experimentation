package com.fun;

import java.util.List;

public class Sorter {

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void sortArray(int[] arrayToBeSorted) {
        long startTime = System.currentTimeMillis();
        int inputArraySize = arrayToBeSorted.length;
        System.out.println("SIMPLE Sort: Array Size = " + inputArraySize);

        int outerloopcounter = 0;
        int innerloopcounter = 0;

        for (int i = 0; i < inputArraySize; i++) {
            outerloopcounter++;
            for (int j = i + 1; j < inputArraySize; j++) {
                if (arrayToBeSorted[i] > arrayToBeSorted[j]) {
                    innerloopcounter++;
                    int temp = arrayToBeSorted[i];
                    arrayToBeSorted[i] = arrayToBeSorted[j];
                    arrayToBeSorted[j] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("innerloopcounter = " + innerloopcounter);
        System.out.println("outerloopcounter = " + outerloopcounter);
        System.out.println("SIMPLE Sort: Execution Time = " + (endTime - startTime) + " milliseconds!");
        System.out.println("");
    }

    public static void sortArrayUsingBubbleSort(int[] arrayToBeSorted) {
        long startTime = System.currentTimeMillis();
        int inputArraySize = arrayToBeSorted.length;
        System.out.println("Bubble Sort: Array Size = " + inputArraySize);

        int outerloopcounter = 0;
        int innerloopcounter = 0;

        for (int i = 0; i < inputArraySize - 1; i++) {
            outerloopcounter++;
            for (int j = 0; j < inputArraySize - 1 - i; j++) {
                if (arrayToBeSorted[j] > arrayToBeSorted[j + 1]) {
                    innerloopcounter++;
                    int temp = arrayToBeSorted[j];
                    arrayToBeSorted[j] = arrayToBeSorted[j + 1];
                    arrayToBeSorted[j + 1] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("innerloopcounter = " + innerloopcounter);
        System.out.println("outerloopcounter = " + outerloopcounter);
        System.out.println("Bubble Sort: Execution Time = " + (endTime - startTime) + " milliseconds!");
        System.out.println("");
    }

    public static void selectionSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        int inputArraySize = arr.length;
        int outerloopcounter = 0;
        int innerloopcounter = 0;
        System.out.println("Selection Sort: Array Size = " + inputArraySize);
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < inputArraySize - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < inputArraySize; j++) {
                innerloopcounter++;
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            outerloopcounter++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("innerloopcounter = " + innerloopcounter);
        System.out.println("outerloopcounter = " + outerloopcounter);
        System.out.println("Selection Sort: Execution Time = " + (endTime - startTime) + " milliseconds!");
        System.out.println("");
    }
}