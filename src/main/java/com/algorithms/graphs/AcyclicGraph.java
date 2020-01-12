package com.algorithms.graphs;

import java.util.List;

public class AcyclicGraph {

    private Integer nodeValue;
    private List<AcyclicGraph> connectedNodes;

    public AcyclicGraph(List<AcyclicGraph> connectedNodes, Integer nodeValue) {
        this.connectedNodes = connectedNodes;
        this.nodeValue = nodeValue;
    }

    public List<AcyclicGraph> getConnectedNodes() {
        return connectedNodes;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public boolean isLeafNode() {
        return connectedNodes == null;
    }
}
