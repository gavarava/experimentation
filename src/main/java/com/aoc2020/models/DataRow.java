package com.aoc2020.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Builder
@Value
public class DataRow {

  String passwordValue;
  Policy policy;

  public static DataRow parse(String dataRowAsString) {
    String[] split = dataRowAsString.split(":");
    String passwordValue = split[1].replaceAll("\\s+", "");
    return DataRow.builder()
        .policy(Policy.parsePolicy(split[0]))
        .passwordValue(passwordValue)
        .build();
  }

  public boolean compliesWithPolicy() {
    var constraintValue = policy.getConstraintValue();
    if (passwordValue.contains(String.valueOf(constraintValue))) {
      var count = countOccurences(passwordValue, constraintValue, 0);
      if (passwordValue.length() == count) {
        return false;
      }
      //if (count >= policy.getLowerLimit() && count <= policy.getUpperLimit()) {
        char[] passwordChars = passwordValue.toCharArray();
        boolean foundAtLowerLimit = constraintValue == (passwordChars[policy.getLowerLimit() - 1]);
        boolean foundAtUpperLimit = constraintValue == (passwordChars[policy.getUpperLimit() - 1]);
        if (foundAtLowerLimit && foundAtUpperLimit) {
          return false;
        }
        if (!foundAtLowerLimit && !foundAtUpperLimit) {
          return false;
        }
        return (foundAtLowerLimit || foundAtUpperLimit);
      }
  //  }
    return false;
  }

  private static int countOccurences(String someString, char searchedChar, int index) {
    if (index >= someString.length()) {
      return 0;
    }
    int count = someString.charAt(index) == searchedChar ? 1 : 0;
    return count + countOccurences(
        someString, searchedChar, index + 1);
  }
}
