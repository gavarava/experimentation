package com.fun.keywordranker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

import com.InputFetcher;
import java.util.HashMap;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AdvancedKeywordRanker_HighPerformanceTest {

    private static final long RUNNINGTIME_MEASURED_FROM_PREVIOUS_TESTS = 279815L;

    @Test
    void shouldReduceInputArrayForEveryRepeatingElementFound() {
        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        String[] input = inputFetcher.getInputDataAsArrayOfStrings();
        AdvancedKeywordRanker advancedKeywordRanker = new AdvancedKeywordRanker(input);
        System.out.println("Input Size = " + input.length);
        // System.out.println("Input Array: " + Arrays.asList(input).toString());

        AdvancedKeywordRankerOptimizationInfo result = advancedKeywordRanker
            .calculateFrequencyOfElementAndReduceInputArray(input, input[1], 0);

        String[] reducedArray = result.getReducedArray();

        assertThat(reducedArray.length, is(input.length - 1));
        assertThat(result.getFrequencyOfElement(), is(getExpectedFrequencyOfWord(input, 1)));
        System.out.println("Frequency of Element under test = " + result.getFrequencyOfElement());

        //System.out.println("Shortened Input Array:" + Arrays.asList(reducedArray).toString());
    }

    private long getExpectedFrequencyOfWord(String[] input, int index) {
        KeywordRanker keywordRanker = new KeywordRanker(input);
        return keywordRanker.calculateFrequencyOfWord(input[index]);
    }

    @Disabled
    @Test
    void shouldCalculateFrequencyOfEveryWordInLargeArray_With_Better_Performance() {

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        String[] inputData = inputFetcher.getInputDataAsArrayOfStrings();
        KeywordRanker advancedKeywordRanker = new AdvancedKeywordRanker(inputData);

        long startTime = System.currentTimeMillis();
        HashMap<String, Long> result = advancedKeywordRanker.calculateFrequencyOfEachUniqueWordInTheArray();
        long endTime = System.currentTimeMillis();

        System.out.println("Length of Input = " + inputData.length);
        long runningTime = endTime
            - startTime;

        System.out.println(
            "shouldCalculateFrequencyOfEveryWordInArray Using ARRAY: Running time in milliseconds == > " + runningTime);
        System.out.println("No of unique keywords found = " + result.keySet().size());

        printOnlyIfFeasible(inputData, result);

        assertThat(result.size(), not(0));
        assertThat(runningTime, is(lessThan(RUNNINGTIME_MEASURED_FROM_PREVIOUS_TESTS)));
    }

    private void printOnlyIfFeasible(String[] inputData, HashMap<String, Long> result) {
        if (inputData.length < 10000 && result.keySet().size() < 100) {
            System.out.println("" + result);
        }
    }
}
