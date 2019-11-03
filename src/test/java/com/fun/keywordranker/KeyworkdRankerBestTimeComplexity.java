package com.fun.keywordranker;

import com.InputFetcher;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

public class KeyworkdRankerBestTimeComplexity {

    @Test
    void shouldCalculateUsingEffecientAlgorithm_WITH_ARRAY() {
        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        String[] inputDataArray = inputFetcher.getInputDataAsArrayOfStrings();

        KeywordRanker keywordRanker = new KeywordRanker();

        long startTime = System.currentTimeMillis();
        HashMap<String, Long> result = keywordRanker
            .calculateFrequencyOfEachWordInArrayDuringTraversal(inputDataArray);
        long endTime = System.currentTimeMillis();

        System.out.println("Length of Input = " + inputDataArray.length);
        System.out.println(
            "shouldCalculateUsingEffecientAlgorithm_WITH_ARRAY: Running time in milliseconds == > " + (endTime - startTime));
        System.out.println(result);

    }

    @Test
    void shouldCalculateUsingEffecientAlgorithm_WITH_LIST() {
        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-1megabyte", ",");
        List<String> inputDataArray = inputFetcher.getInputDataAsListOfStrings();

        KeywordRanker keywordRanker = new KeywordRanker();

        long startTime = System.currentTimeMillis();
        HashMap<String, Long> result = keywordRanker
            .calculateFrequencyOfEachWordInArrayDuringTraversal(inputDataArray);
        long endTime = System.currentTimeMillis();

        System.out.println("Length of Input = " + inputDataArray.size());
        System.out.println(
            "shouldCalculateUsingEffecientAlgorithm_WITH_LIST: Running time in milliseconds == > " + (endTime - startTime));
        System.out.println(result);

    }

}
