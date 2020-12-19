package com.aoc2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Puzzle3 {

  public static void main(String[] args) {
    List<List<String>> forestStrip = readForestStrip(Utils.readInputAsList("d3-ex", Puzzle3.class));
    traverseAndCountTrees(forestStrip);
  }

  static List<List<String>> readForestStrip(List<String> fileDataAsList) {
    return fileDataAsList.stream().map(s -> Arrays.asList(s.split(""))).collect(Collectors.toList());
  }

  static void traverseAndCountTrees(List<List<String>> forestStrip) {
    int count = 0;
    for (int j = 0, forestStripSize = forestStrip.size(); j < forestStripSize; j++) {
      List<String> rowOfForestStrip = forestStrip.get(j);// Detect rightmost end then move to next row
      for (int i = 1; i < rowOfForestStrip.size(); i += 3) {
        j++;
        i++;
        if (i == rowOfForestStrip.size()) {
          i = 0;
        }
        if (j == forestStripSize) {
          // Reset Forest Strip
          j = 0;
        }
        try {
          String element_R3D1 = forestStrip.get(j).get(i);
          System.out.println(element_R3D1);
          if ("#".equals(element_R3D1)) {
            count++;
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          System.err.println("j == " + j);
          System.err.println("i == " + i);
        }
      }
    }
    System.out.println("FINAL COUNT = " + count);
  }
}
