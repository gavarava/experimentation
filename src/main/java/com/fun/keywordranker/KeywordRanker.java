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

    public HashMap<String, Integer> getMapOfFirstTenFrequentKeywords() {
        return (HashMap<String, Integer>) Collections.EMPTY_MAP;
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

}
