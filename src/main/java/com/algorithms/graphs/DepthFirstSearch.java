package com.algorithms.graphs;

public class DepthFirstSearch {

    public static int findLargestValueInGraph(AcyclicGraph acyclicGraph) {
        int biggestElement = 0;
        int rootValue = acyclicGraph.getNodeValue();
        biggestElement = getBiggest(biggestElement, rootValue);
        biggestElement = traverseGraphToGetBiggestElement(acyclicGraph, biggestElement);
        return biggestElement;
    }

    private static int traverseGraphToGetBiggestElement(AcyclicGraph acyclicGraph, int latestBiggestElement) {
        for (AcyclicGraph node : acyclicGraph.getConnectedNodes()) {
            int nodeValue = node.getNodeValue();
            latestBiggestElement = getBiggest(latestBiggestElement, nodeValue);
            latestBiggestElement = getBiggestElementFromRestOfTheGraph(latestBiggestElement, node);
        }
        return latestBiggestElement;
    }

    private static int getBiggestElementFromRestOfTheGraph(int biggestElement, AcyclicGraph node) {
        if (!node.isLeafNode()) {
            int biggestFromChildren = findLargestValueInGraph(node);
            biggestElement = getBiggest(biggestElement, biggestFromChildren);
        }
        return biggestElement;
    }

    private static int getBiggest(int currentBiggest, int elementToBeChecked) {
        return currentBiggest < elementToBeChecked ? elementToBeChecked : currentBiggest;
    }
}
