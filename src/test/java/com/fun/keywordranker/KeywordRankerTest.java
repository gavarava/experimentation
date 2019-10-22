package com.fun.keywordranker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.InputFetcher;
import java.util.List;
import org.junit.jupiter.api.Test;

;

class KeywordRankerTest {

    @Test
    void shouldCalculateFrequencyOfWordsUsingArray() {
        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        String[] inputDataArray = inputFetcher.getInputDataAsArrayOfStrings();

        KeywordRanker keywordRanker = new KeywordRanker(inputDataArray);

        long startTime = System.currentTimeMillis();
        long frequencyOfFirstWord = keywordRanker.calculateFrequencyOfWord(inputDataArray[0]);
        long endTime = System.currentTimeMillis();

        System.out.println("shouldCalculateFrequencyOfWordsUsingArray: Running time in milliseconds == > " + (endTime-startTime));
        assertThat(frequencyOfFirstWord, is(4425L));
    }

    @Test
    void shouldCalculateFrequencyOfWordsUsingList() {
        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        List<String> inputAsList = inputFetcher.getInputDataAsListOfStrings();
        KeywordRanker keywordRanker = new KeywordRanker(inputAsList);

        long startTime = System.currentTimeMillis();
        long frequencyOfFirstWord = keywordRanker.calculateFrequencyOfWordUsingList(inputAsList.get(0));
        long endTime = System.currentTimeMillis();

        System.out.println("shouldCalculateFrequencyOfWordsUsingList: Running time in milliseconds == > " + (endTime-startTime));
        assertThat(frequencyOfFirstWord, is(4425L));
    }
}
