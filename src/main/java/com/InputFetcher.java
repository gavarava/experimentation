package com;

import static org.apache.commons.io.FileUtils.readFileToString;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFetcher {

    private String filePath;
    private String delimiter;

    public InputFetcher(String filePath) {
        this.filePath = filePath;
    }

    public InputFetcher(String filePath, String delimiter) {
        this.filePath = filePath;
        this.delimiter = delimiter;
    }

    /**
     * Implement own collector to check performance implication
     */
    private static <T> Collector<T, ?, List<T>> toList(int size) {
        return Collectors.toCollection(() -> new ArrayList<T>(size));
    }

    public long getInputSize() {
        File file = new File(this.getClass().getClassLoader().getResource(filePath).getPath());
        return file.length();
    }

    public String getInputDataAsString() {
        try {
            URL resource = this.getClass().getClassLoader().getResource(filePath);
            if (resource != null) {
                File file = new File(resource.getPath());
                return readFileToString(file);
            } else {
                File file = new File(filePath);
                return readFileToString(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] getInputDataAsArrayOfStrings() {
        try {
            File file = new File(this.getClass().getClassLoader().getResource(filePath).getPath());
            String fileAsString = readFileToString(file);
            return fileAsString.split(delimiter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int[] getInputDataAsArrayOfIntegers() {
        try {
            File file = new File(this.getClass().getClassLoader().getResource(filePath).getPath());
            String fileAsString = readFileToString(file);
            String[] array = fileAsString.split(delimiter);
            int[] input = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                String element = array[i];
                if (element.contains("+")) {
                    element = element.replace("+", "");
                } else if (element.contains("-")) {
                    element = element.replace("-", "");
                }
                input[i] = Integer.parseInt(element);
            }
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getInputDataAsListOfStrings() {
        String inputData = getInputDataAsString();
        String[] arrayFromInputString = inputData.split(delimiter);
        int inputDataListSize = arrayFromInputString.length;
        return Stream.of(arrayFromInputString).collect(toList(inputDataListSize));
        //return Stream.of(arrayFromInputString).collect(Collectors.toList());     // Slower than when we specify size ?? Results unpredictable with 1 MB file
    }

}

