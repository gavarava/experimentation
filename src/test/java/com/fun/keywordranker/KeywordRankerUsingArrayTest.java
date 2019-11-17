package com.fun.keywordranker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.InputFetcher;
import java.util.HashMap;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class KeywordRankerUsingArrayTest {

    @Test
    void shouldCalculateFrequencyOfGivenWord() {

        String[] inputDataArray = {"test", "testSomething", "Test", "test"};
        KeywordRanker keywordRanker = new KeywordRanker(inputDataArray);

        long frequencyOfWord = keywordRanker.calculateFrequencyOfWord("test");

        assertThat(frequencyOfWord, is(2L));
    }

    @Test
    void shouldCalculateFrequencyOfEveryWordInArray_UsingArray() {

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-small", ",");
        String[] inputDataArray = inputFetcher.getInputDataAsArrayOfStrings();
        KeywordRanker keywordRanker = new KeywordRanker(inputDataArray);

        long startTime = System.currentTimeMillis();
        HashMap<String, Long> result = keywordRanker.calculateFrequencyOfEachUniqueWordInTheArray();
        long endTime = System.currentTimeMillis();

        System.out.println("Length of Input = " + inputDataArray.length);
        System.out.println(
            "shouldCalculateFrequencyOfEveryWordInArray Using ARRAY: Running time in milliseconds == > " + (endTime
                - startTime));
        System.out.println("No of unique keywords found = " + result.keySet().size());
        System.out.println("" + result);
    }

    /**
     * This test confirmed that the Array has faster performance as against ArrayList when finding out frequency of a
     * word in a huge array.
     */
    @Test
    void shouldCalculateFrequencyOfWordsUsingArray() {
        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        String[] inputDataArray = inputFetcher.getInputDataAsArrayOfStrings();

        KeywordRanker keywordRanker = new KeywordRanker(inputDataArray);

        long startTime = System.currentTimeMillis();
        long frequencyOfFirstWord = keywordRanker.calculateFrequencyOfWord(inputDataArray[0]);
        long frequencyOfSecondWord = keywordRanker.calculateFrequencyOfWord(inputDataArray[1]);
        long frequencyOfNthWord = keywordRanker.calculateFrequencyOfWord(inputDataArray[1156]);
        long frequencyOfFourthWord = keywordRanker.calculateFrequencyOfWord(inputDataArray[3]);

        long endTime = System.currentTimeMillis();

        System.out.println("Length of Input = " + inputDataArray.length);
        System.out.println(
            "shouldCalculateFrequencyOfWordsUsingArray: Running time in milliseconds == > " + (endTime - startTime));
        assertThat(frequencyOfFirstWord, is(4425L));
        assertThat(frequencyOfSecondWord, is(6195L));
        assertThat(frequencyOfNthWord, is(8260L));
        assertThat(frequencyOfFourthWord, is(7080L));
    }

    @Disabled
    @Test
    void shouldCalculateFrequencyOfEveryWordInArray_UsingArray_From_Very_Large_Input() {
        // String[] inputDataArray = {"test", "testSomething", "Test", "test"};
        //String[] inputDataArray = {"test", "testSomething", "test"};

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        String[] inputDataArray = inputFetcher.getInputDataAsArrayOfStrings();
        KeywordRanker keywordRanker = new KeywordRanker(inputDataArray);

        long startTime = System.currentTimeMillis();
        HashMap<String, Long> result = keywordRanker.calculateFrequencyOfEachUniqueWordInTheArray();
        long endTime = System.currentTimeMillis();

        System.out.println("Length of Input = " + inputDataArray.length);
        System.out.println(
            "shouldCalculateFrequencyOfEveryWordInArray Using ARRAY: Running time in milliseconds == > " + (endTime
                - startTime));
        System.out.println("No of unique keywords found = " + result.keySet().size());
        if (inputDataArray.length < 10000 && result.keySet().size() < 100) {
            System.out.println("" + result);
        }
    }

    @Test
    void shouldCalculateUsingEffecientAlgorithm() {
        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        String[] inputDataArray = inputFetcher.getInputDataAsArrayOfStrings();

        KeywordRanker keywordRanker = new KeywordRanker();

        long startTime = System.currentTimeMillis();
        HashMap<String, Long> result = keywordRanker
            .calculateFrequencyOfEachWordInArrayDuringTraversal(inputDataArray);
        long endTime = System.currentTimeMillis();

        System.out.println("Length of Input = " + inputDataArray.length);
        System.out.println(
            "shouldCalculateFrequencyOfWordsUsingArray: Running time in milliseconds == > " + (endTime - startTime));
        System.out.println(result);

    }
}
