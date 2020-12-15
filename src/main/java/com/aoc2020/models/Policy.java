package com.aoc2020.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.Value;

@AllArgsConstructor
@Builder
@Value
@ToString
public class Policy {

  char constraintValue;
  int lowerLimit;
  int upperLimit;

  public static Policy parsePolicy(String policyString) {
    String[] contents = policyString.split(" ");
    String limitsString = contents[0];
    String[] limits = limitsString.split("-");
    return Policy.builder()
        .lowerLimit(Integer.parseInt(limits[0]))
        .upperLimit(Integer.parseInt(limits[1]))
        .constraintValue(contents[1].charAt(0))
        .build();
  }
}
