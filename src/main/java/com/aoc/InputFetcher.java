package com.aoc;

import static org.apache.commons.io.FileUtils.readFileToString;

import java.io.File;
import java.io.IOException;

public class InputFetcher {

    private String filePath;

    public InputFetcher(String filePath) {
        this.filePath = filePath;
    }

    public String getInputData() {
        try {
            File file = new File(this.getClass().getClassLoader().getResource(filePath).getPath());
            return readFileToString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
