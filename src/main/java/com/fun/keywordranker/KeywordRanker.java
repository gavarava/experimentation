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

    public HashMap<String, Long> getMapOfFirstTenFrequentKeywords() {
        return (HashMap<String, Long>) Collections.EMPTY_MAP;
    }

    public HashMap<String, Long> calculateFrequencyOfEachUniqueWordInTheArray() {
        HashMap<String, Long> output = new HashMap<>();
        for (int i = 0; i < arrayOfKeywordsToBeRanked.length; i++) {
            output.put(arrayOfKeywordsToBeRanked[i], calculateFrequencyOfWord(arrayOfKeywordsToBeRanked[i]));
        }
        return output;
    }

    public HashMap<String, Long> calculateFrequencyOfEachUniqueWordInTheList() {
        HashMap<String, Long> output = new HashMap<>();
        for (int i = 0; i < listOfKeywordsToBeRanked.size(); i++) {
            output.put(listOfKeywordsToBeRanked.get(i),
                calculateFrequencyOfWordUsingList(listOfKeywordsToBeRanked.get(i)));
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
