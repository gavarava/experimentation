package com.fun.keywordranker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.InputFetcher;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class KeywordRankerUsingArrayListTest {

    @Test
    void shouldCalculateFrequencyOfEveryWordInArray_UsingArrayList() {
        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-small", ",");
        List<String> inputDataList = inputFetcher.getInputDataAsListOfStrings();
        KeywordRanker keywordRanker = new KeywordRanker(inputDataList);

        long startTime = System.currentTimeMillis();
        HashMap<String, Long> result = keywordRanker.calculateFrequencyOfEachUniqueWordInTheList();
        long endTime = System.currentTimeMillis();

        System.out.println("Length of Input = " + inputDataList.size());
        System.out.println(
            "shouldCalculateFrequencyOfEveryWordInArray Using LIST: Running time in milliseconds == > " + (endTime
                - startTime));
        System.out.println("No of unique keywords found = " + result.keySet().size());
        System.out.println("" + result);
    }

    @Test
    void shouldCalculateFrequencyOfWordsUsingList() {
        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        List<String> inputAsList = inputFetcher.getInputDataAsListOfStrings();
        KeywordRanker keywordRanker = new KeywordRanker(inputAsList);

        System.out.println("First Word = " + inputAsList.get(0));
        System.out.println("Second Word = " + inputAsList.get(1));
        System.out.println("Nth Word = " + inputAsList.get(1156));
        System.out.println("Fourth Word = " + inputAsList.get(3));

        long startTime = System.currentTimeMillis();
        long frequencyOfFirstWord = keywordRanker.calculateFrequencyOfWordUsingList(inputAsList.get(0));
        long frequencyOfSecondWord = keywordRanker.calculateFrequencyOfWordUsingList(inputAsList.get(1));
        long frequencyOfNthWord = keywordRanker.calculateFrequencyOfWordUsingList(inputAsList.get(1156));
        long frequencyOfFourthWord = keywordRanker.calculateFrequencyOfWordUsingList(inputAsList.get(3));
        long endTime = System.currentTimeMillis();

        System.out.println("Length of Input = " + inputAsList.size());
        System.out.println(
            "shouldCalculateFrequencyOfWordsUsingList: Running time in milliseconds == > " + (endTime - startTime));
        assertThat(frequencyOfFirstWord, is(4425L));
        assertThat(frequencyOfSecondWord, is(6195L));
        assertThat(frequencyOfNthWord, is(8260L));
        assertThat(frequencyOfFourthWord, is(7080L));
    }

    @Test
    @Disabled("BAD PERFORMANCE FOR LARGE INPUT")
    void shouldCalculateFrequencyOfEveryWordInArray_UsingList_From_Very_Large_Input() {

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        List<String> inputDataList = inputFetcher.getInputDataAsListOfStrings();
        KeywordRanker keywordRanker = new KeywordRanker(inputDataList);

        long startTime = System.currentTimeMillis();
        HashMap<String, Long> result = keywordRanker.calculateFrequencyOfEachUniqueWordInTheList();
        long endTime = System.currentTimeMillis();

        System.out.println("Length of Input = " + inputDataList.size());
        System.out.println(
            "shouldCalculateFrequencyOfEveryWordInArray Using LIST: Running time in milliseconds == > " + (endTime
                - startTime));
        System.out.println("No of unique keywords found = " + result.keySet().size());
        if (inputDataList.size() < 10000 && result.keySet().size() < 100) {
            System.out.println("" + result);
        }

        // Takes 279815 milliseconds ie 4.6 seconds
    }
}
