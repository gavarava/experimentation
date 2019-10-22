package com;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;

class InputFetcherTest {

    private InputFetcher target;

    @Test
    void shouldFetchInputFromFile() throws URISyntaxException {
        target = new InputFetcher("day01-input");
        String inputData = target.getInputDataAsString();
        assertNotNull(inputData);
        assertThat(inputData, is(""));
    }

}