package com.fun.keywordranker;

import java.util.HashMap;
import java.util.List;

public class AdvancedKeywordRanker extends KeywordRanker {

    public AdvancedKeywordRanker(String[] arrayOfKeywordsToBeRanked) {
        super(arrayOfKeywordsToBeRanked);
    }

    public AdvancedKeywordRanker(List<String> inputAsList) {
        super(inputAsList);
    }


    @Override
    public long calculateFrequencyOfWordUsingList(String word) {
        return super.calculateFrequencyOfWordUsingList(word);
    }

    @Override
    public HashMap<String, Long> calculateFrequencyOfEachUniqueWordInTheArray() {
        HashMap<String, Long> output = new HashMap<>();
        String[] arrayOfKeywordsToBeRanked = getArrayOfKeywordsToBeRanked();
        for (int i = 0; i < arrayOfKeywordsToBeRanked.length; i++) {

            AdvancedKeywordRankerOptimizationInfo advancedKeywordRankerOptimizationInfo = calculateFrequencyOfElementAndReduceInputArray(
                arrayOfKeywordsToBeRanked,
                arrayOfKeywordsToBeRanked[i], i);

            output.put(arrayOfKeywordsToBeRanked[i],
                advancedKeywordRankerOptimizationInfo.getFrequencyOfElement());
        }
        return output;
    }

    public AdvancedKeywordRankerOptimizationInfo calculateFrequencyOfElementAndReduceInputArray(String[] inputArray,
        String element, int indexOfElement) {

        int frequencyOfElement = 0;
        int reducedArrayIndex = 0;

        String[] reducedArray = new String[inputArray.length - 1];

        for (int i = indexOfElement; i < inputArray.length; i++) {
            if (inputArray[i].equals(element)) {
                frequencyOfElement++;
            } else {
                reducedArray[reducedArrayIndex] = inputArray[i];
                reducedArrayIndex++;
            }
        }
        AdvancedKeywordRankerOptimizationInfo result = new AdvancedKeywordRankerOptimizationInfo(
            reducedArray);
        result.setFrequencyOfElement(frequencyOfElement);
        return result;
    }
}
