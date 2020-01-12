package com.algorithms.graphs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DepthFirstSearchTest {

    @Test
    void findLargestElement() {
        AcyclicGraph four = new AcyclicGraph(null, 4);
        AcyclicGraph nine = new AcyclicGraph(Arrays.asList(four), 9);
        AcyclicGraph five = new AcyclicGraph(Arrays.asList(nine), 5);
        AcyclicGraph two = new AcyclicGraph(null, 2);
        AcyclicGraph eleven = new AcyclicGraph(null, 11);
        AcyclicGraph five2 = new AcyclicGraph(Arrays.asList(two), 5);
        AcyclicGraph six = new AcyclicGraph(Arrays.asList(five, eleven), 6);
        AcyclicGraph seven = new AcyclicGraph(Arrays.asList(six, two), 7);
        AcyclicGraph acyclicGraphUnderTest = new AcyclicGraph(Arrays.asList(seven, five2), 2);

        int answer = DepthFirstSearch.findLargestValueInGraph(acyclicGraphUnderTest);
        assertThat(answer, is(11));

    }

}