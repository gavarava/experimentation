package com.fun.keywordranker;

public class AdvancedKeywordRankerOptimizationInfo {

    private String[] reducedArray;
    private String elementBeingCountedInArray;
    private long frequencyOfElement;

    public AdvancedKeywordRankerOptimizationInfo(String[] reducedArray) {
        this.reducedArray = reducedArray;
    }

    public String[] getReducedArray() {
        return reducedArray;
    }

    public void setFrequencyOfElement(long frequencyOfElement) {
        this.frequencyOfElement = frequencyOfElement;
    }

    public long getFrequencyOfElement() {
        return frequencyOfElement;
    }
}