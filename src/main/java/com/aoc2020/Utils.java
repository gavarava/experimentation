package com.aoc2020;

import static org.apache.commons.io.IOUtils.readLines;

import java.util.List;
import java.util.stream.LongStream;
import lombok.SneakyThrows;

public class Utils {

  private static final String FOLDER = "aoc-2020/";
  @SneakyThrows
  public static LongStream readInputAsLongStream(String fileName) {
    var fileStream = Utils.class.getClassLoader().getResourceAsStream(FOLDER+fileName);
    List<String> strings = readLines(fileStream, "UTF-8");
    return strings.stream().mapToLong(value -> Long.parseLong(value));
  }

  @SneakyThrows
  public static List<String> readInputAsList(String fileName, Class clazz) {
    var fileStream = clazz.getClassLoader().getResourceAsStream(FOLDER+fileName);
    return readLines(fileStream, "UTF-8");
  }
}
