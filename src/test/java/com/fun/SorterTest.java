package com.fun;

import com.InputFetcher;
import org.junit.jupiter.api.Test;

public class SorterTest {

    @Test
    public void sortUsingBubbleSort() {

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-small", ",");
        int[] arrayOfIntegers = inputFetcher.getInputDataAsArrayOfIntegers();

       // Sorter.sortArrayUsingBubbleSort(bigArray);
        Sorter.sortArrayUsingBubbleSort(arrayOfIntegers);
       // Sorter.printArray(smallArray);
    }

    @Test
    public void sortUsingSimpleSort() {

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-small", ",");
        int[] arrayOfIntegers = inputFetcher.getInputDataAsArrayOfIntegers();

      //  Sorter.sortArray(bigArray);
        Sorter.sortArray(arrayOfIntegers);
      //  Sorter.printArray(smallArray);
    }

    @Test
    public void sortUsingSelectionSort() {

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-small", ",");
        int[] arrayOfIntegers = inputFetcher.getInputDataAsArrayOfIntegers();

        //  Sorter.sortArray(bigArray);
        Sorter.selectionSort(arrayOfIntegers);
        //  Sorter.printArray(smallArray);
    }


}