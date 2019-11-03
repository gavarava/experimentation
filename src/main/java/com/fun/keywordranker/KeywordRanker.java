package com.fun.keywordranker;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class KeywordRanker {

    private String[] arrayOfKeywordsToBeRanked;
    private List<String> listOfKeywordsToBeRanked;

    public KeywordRanker(String[] arrayOfKeywordsToBeRanked) {
        this.arrayOfKeywordsToBeRanked = arrayOfKeywordsToBeRanked;
    }

    public KeywordRanker(List<String> inputAsList) {
        this.listOfKeywordsToBeRanked = inputAsList;
    }

    public KeywordRanker() {
    }

    public HashMap<String, Long> calculateFrequencyOfEachUniqueWordInTheArray() {
        HashMap<String, Long> output = new HashMap<>();
        for (int i = 0; i < arrayOfKeywordsToBeRanked.length; i++) {
            output.put(arrayOfKeywordsToBeRanked[i], calculateFrequencyOfWord(arrayOfKeywordsToBeRanked[i]));
        }
        return output;
    }

    public long calculateFrequencyOfWord(String word) {
        int frequency = 0;
        for (String element : arrayOfKeywordsToBeRanked) {
            if (word.equals(element)) {
                frequency++;
            }
        }
        return frequency;
    }

    public HashMap<String, Long> calculateFrequencyOfEachUniqueWordInTheList() {
        HashMap<String, Long> output = new HashMap<>();
        for (int i = 0; i < listOfKeywordsToBeRanked.size(); i++) {
            output.put(listOfKeywordsToBeRanked.get(i),
                calculateFrequencyOfWordUsingList(listOfKeywordsToBeRanked.get(i)));
        }
        return output;
    }

    /**
     * BEST TIME COMPLEXITY , increment the counts in hashmap as you keep travelling the array
     * So its linear time complexity
     */
    public HashMap<String, Long> calculateFrequencyOfEachWordInArrayDuringTraversal(
        String[] arrayOfKeywordsToBeRanked) {
        HashMap<String, Long> result = new HashMap<>();
        for (String element : arrayOfKeywordsToBeRanked) {
            if (result.containsKey(element)) {
                long elementCount = result.get(element);
                result.put(element, ++elementCount);
            } else {
                result.put(element, 1L);
            }
        }
        return result;
    }

    public HashMap<String, Long> calculateFrequencyOfEachWordInArrayDuringTraversal(
        List<String> arrayOfKeywordsToBeRanked) {
        HashMap<String, Long> result = new HashMap<>();
        for (String element : arrayOfKeywordsToBeRanked) {
            if (result.containsKey(element)) {
                long elementCount = result.get(element);
                result.put(element, ++elementCount);
            } else {
                result.put(element, 1L);
            }
        }
        return result;
    }

    public long calculateFrequencyOfWordUsingList(String word) {
        int frequency = 0;
        for (String element : listOfKeywordsToBeRanked) {
            if (word.equals(element)) {
                frequency++;
            }
        }
        return frequency;
    }

    public String[] getArrayOfKeywordsToBeRanked() {
        return arrayOfKeywordsToBeRanked;
    }

    public List<String> getListOfKeywordsToBeRanked() {
        return listOfKeywordsToBeRanked;
    }

}
