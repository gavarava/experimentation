package com.algorithms.graphs;

public class DepthFirstSearch {

    public static int findLargestValueInGraph(AcyclicGraph acyclicGraph) {
        int biggestElement = 0;
        int rootValue = acyclicGraph.getNodeValue();

        biggestElement = getBiggest(biggestElement, rootValue);

        for (AcyclicGraph node : acyclicGraph.getConnectedNodes()) {
            int nodeValue = node.getNodeValue();

            if (nodeValue > biggestElement) {
                biggestElement = nodeValue;
            }

            if (!node.isLeafNode()) {
                int biggestFromChildren = findLargestValueInGraph(node);
                biggestElement = getBiggest(biggestElement, biggestFromChildren);
            }
        }
        return biggestElement;
    }

    private static int getBiggest(int currentBiggest, int elementToBeChecked) {
        return currentBiggest < elementToBeChecked ? elementToBeChecked : currentBiggest;
    }
}
