package com.aoc2020;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.aoc2020.models.DataRow;
import com.aoc2020.models.Policy;
import java.util.List;
import org.junit.jupiter.api.Test;

class Puzzle2Test {

  @Test
  void test() {
    List<String> passwordsDb = Utils.readInputAsList("d2-p2-ex", Puzzle2Test.class);
    assertThat(Puzzle2.countValidPasswords(passwordsDb), is(1L));
  }

  @Test
  void testParsePolicy() {
    String passwordRow = "1-3 a: abcde";
    String[] passwordData = passwordRow.split(":");
    var policy = Policy.parsePolicy(passwordData[0]);
    System.out.println(policy);
  }

  @Test
  void testRandom() {
    String passwordRow = "9-10 j: jxjgjjmgjcjzjjjjj";
    var dataRow = DataRow.parse(passwordRow);
    System.out.println(dataRow);
    assertThat(dataRow.compliesWithPolicy(),is(true));
  }

  @Test
  void testParseDataRowAndCompliesWithPolicy() {
    String passwordRow = "1-3 a: abcde";
    var dataRow = DataRow.parse(passwordRow);
    System.out.println(dataRow);
    assertThat(dataRow.compliesWithPolicy(),is(true));
  }

  @Test
  void testParseDataRowAndNotCompliesWithPolicy() {
    String passwordRow = "1-3 b: bcbfg";
    var dataRow = DataRow.parse(passwordRow);
    System.out.println(dataRow);
    assertThat(dataRow.compliesWithPolicy(),is(false));
  }

  @Test
  void testParseDataRowAndNotCompliesWithPolicy_2() {
    String passwordRow = "2-9 c: cccccccccc";
    var dataRow = DataRow.parse(passwordRow);
    System.out.println(dataRow);
    assertThat(dataRow.compliesWithPolicy(),is(false));
  }

  @Test
  void testParseDataRowAndNotCompliesWithPolicy_3() {
    String passwordRow = "2-9 c: caccccccac";
    var dataRow = DataRow.parse(passwordRow);
    System.out.println(dataRow);
    assertThat(dataRow.compliesWithPolicy(),is(false));
  }

}