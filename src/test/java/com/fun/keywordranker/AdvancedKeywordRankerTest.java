package com.fun.keywordranker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class AdvancedKeywordRankerTest {

    @Test
    void shouldReduceInputArrayForEveryRepeatingElementFound_WhenOnlyOneElement() {
        String[] input = {"WORDX"};
        AdvancedKeywordRanker advancedKeywordRanker = new AdvancedKeywordRanker(input);
        AdvancedKeywordRankerOptimizationInfo result = advancedKeywordRanker
            .calculateFrequencyOfElementAndReduceInputArray(input, "WORDX", 0);

        String[] reducedArray = result.getReducedArray();

        assertThat(reducedArray.length, is(input.length-1));
        System.out.println(Arrays.asList(reducedArray).toString());
    }

    @Test
    void shouldReduceInputArrayForEveryRepeatingElementFound_WhenOnlyTwoElement() {
        String[] input = {"WORDX", "WORDY"};
        AdvancedKeywordRanker advancedKeywordRanker = new AdvancedKeywordRanker(input);
        AdvancedKeywordRankerOptimizationInfo result = advancedKeywordRanker
            .calculateFrequencyOfElementAndReduceInputArray(input, "WORDX", 0);

        String[] reducedArray = result.getReducedArray();

        assertThat(reducedArray.length, is(input.length-1));
        assertThat(result.getFrequencyOfElement(), is(1L));
        System.out.println(Arrays.asList(reducedArray).toString());
    }

    @Test
    void shouldReduceInputArrayForEveryRepeatingElementFound_WhenBothAreSameElements() {
        String[] input = {"WORDX", "WORDX"};
        AdvancedKeywordRanker advancedKeywordRanker = new AdvancedKeywordRanker(input);
        AdvancedKeywordRankerOptimizationInfo result = advancedKeywordRanker
            .calculateFrequencyOfElementAndReduceInputArray(input, "WORDX", 0);

        String[] reducedArray = result.getReducedArray();

        assertThat(reducedArray.length, is(input.length-1));
        assertThat(result.getFrequencyOfElement(), is(2L));
        System.out.println(Arrays.asList(reducedArray).toString());
    }

    @Test
    void shouldReduceInputArrayForEveryRepeatingElementFound() {
        String[] input = {"WORDX", "WORDY", "WORDZ", "WORDX", "WORDX", "WORDL", "WORDX", "WORDZ"};
        AdvancedKeywordRanker advancedKeywordRanker = new AdvancedKeywordRanker(input);
        AdvancedKeywordRankerOptimizationInfo result = advancedKeywordRanker
            .calculateFrequencyOfElementAndReduceInputArray(input, "WORDX", 0);

        String[] reducedArray = result.getReducedArray();

        assertThat(reducedArray.length, is(input.length - 2));
        System.out.println(Arrays.asList(reducedArray).toString());
    }
}
