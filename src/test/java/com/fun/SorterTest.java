package com.fun;

import com.InputFetcher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SorterTest {

    @Disabled
    @Test
    public void sortUsingBubbleSort() {

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        int[] arrayOfIntegers = inputFetcher.getInputDataAsArrayOfIntegers();

       // Sorter.sortArrayUsingBubbleSort(bigArray);
        Sorter.sortArrayUsingBubbleSort(arrayOfIntegers);
       // Sorter.printArray(smallArray);
    }

    @Disabled
    @Test
    public void sortUsingSimpleSort() {

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        int[] arrayOfIntegers = inputFetcher.getInputDataAsArrayOfIntegers();

      //  Sorter.sortArray(bigArray);
        Sorter.sortArray(arrayOfIntegers);
      //  Sorter.printArray(smallArray);
    }

    @Disabled
    @Test
    public void sortUsingSelectionSort() {

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        int[] arrayOfIntegers = inputFetcher.getInputDataAsArrayOfIntegers();

        //  Sorter.sortArray(bigArray);
        Sorter.selectionSort(arrayOfIntegers);
        //  Sorter.printArray(smallArray);
    }


}