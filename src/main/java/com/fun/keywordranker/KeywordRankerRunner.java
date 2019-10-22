package com.fun.keywordranker;

import com.InputFetcher;

public class KeywordRankerRunner {

    /*
     * Given a file with a lot of words,
     * find the first ten words which occur frequently in the file.
     *
     * Assume the File to be 1 Megabyte initially.
     *
     * What happens if the file is of 1 Terabyte.
     *
     * Now the file has become a continous or an infinite stream of data.
     *
     */
    public static void main(String args[]) {

        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-small");
        String inputData = inputFetcher.getInputDataAsString();
        String[] inputDataArray = inputData.split(",");

        System.out.println("Input Name ==> delimited-data-file-small");
        System.out.println("Input Size ==> " + inputFetcher.getInputSize());
        System.out.println("Input Length ==> " + inputDataArray.length);


    }
}
