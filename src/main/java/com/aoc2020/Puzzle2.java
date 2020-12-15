package com.aoc2020;

import com.aoc2020.models.DataRow;
import java.util.List;

public class Puzzle2 {

  public static void main(String[] args) {
    // ANS 711
    System.out.println(countValidPasswords(Utils.readInputAsList("d2-p2-1", Puzzle2.class)));
  }

  public static long countValidPasswords(List<String> passwordsDb) {
    return passwordsDb.stream()
        .map(DataRow::parse)
        .filter(DataRow::compliesWithPolicy)
        .count();
  }
}
