package com.aoc2020;

import static com.aoc2020.Puzzle3.readForestStrip;
import static com.aoc2020.Puzzle3.traverseAndCountTrees;

import org.junit.jupiter.api.Test;

class Puzzle3Test {

  @Test
  void traverseForest() {
    traverseAndCountTrees(readForestStrip(Utils.readInputAsList("d3-ex", Puzzle3.class)));
  }

}