package com.aoc2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The first part was easy to solve: Select when digits are in increasing order & contain one set of adjacent digits
 * which are same. Second part build up on the first, but was a bit difficult to solve initially. It became clear when
 * the requirement was expressed as a mathematical function f(N*x) such that N is number of repititions & value of f(Nx)
 * is considered to be distincts available. Then created a table with all possible elimination scenarios. Coded only the
 * scenarios which didnt satisfy the criterias that if K number of distincts are present then there cannot be more than
 * a certain number of repeating digits. Example If 2 distincts & only one has a count of 4 then obviously there is none
 * for the criteria needed.
 */
public class SecureContainer {

    public static final int RANGE_MIN = 138307;
    public static final int RANGE_MAX = 654504;
    public static final int TOTAL_VALUES = RANGE_MAX - RANGE_MIN;

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(TOTAL_VALUES);

        for (int i = RANGE_MIN; i <= RANGE_MAX; i++) {
            if (doesDigitsStaySameOrIncreasingOrder(i)) {
                list.add(i);
            }
        }

        System.out.println(list);
        System.out.println(list.size());

    }

    public static boolean doesDigitsStaySameOrIncreasingOrder(int number) {
        String numberAsString = String.valueOf(number);
        long distinctsCount = countOfAllDistinctElementsInString(numberAsString);
        if (distinctsCount == 6 || distinctsCount == 1) {
            return false;
        }

        boolean foundBiggerPrevious = false;
        if (distinctsCount < 6) {
            List<Integer> allDigits = Arrays.stream(numberAsString
                .split(""))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
            // 588899

            int previousInt = 0;
            for (Integer currentInt : allDigits) {
                if (previousInt > currentInt) {
                    foundBiggerPrevious = true;
                }
                previousInt = currentInt;
            }

            if (!foundBiggerPrevious) {

                Map<String, Integer> elementsToCountMap = new HashMap<>();
                for (String eachElement : numberAsString.split("")) {
                    int countOfGivenElementInString = countOfGivenElementInString(eachElement, numberAsString);
                    if (countOfGivenElementInString == 5) {
                        foundBiggerPrevious = true;
                        break;
                    }

                    if (distinctsCount == 3 && countOfGivenElementInString == 4) {
                        foundBiggerPrevious = true;
                        break;
                    }

                    if (distinctsCount == 4 && countOfGivenElementInString == 4) {
                        foundBiggerPrevious = true;
                        break;
                    }

                    if (distinctsCount == 4 && countOfGivenElementInString == 3) {
                        foundBiggerPrevious = true;
                        break;
                    }

                    if (distinctsCount == 2 && countOfGivenElementInString == 3) {
                        foundBiggerPrevious = true;
                        break;
                    }

                    elementsToCountMap.put(eachElement, countOfGivenElementInString);
                }
                // System.out.println(elementsToCountMap);
            }
        } else {
            return false;
        }
        return !foundBiggerPrevious;
    }


    public static int countOfGivenElementInString(String elementToFind, String completeString) {
        return Math.toIntExact(Arrays.stream(completeString.split("")).filter(s -> s.equals(elementToFind)).count());
    }

    public static int countOfAllDistinctElementsInString(String completeString) {
        return Math.toIntExact(Arrays.stream(completeString.split("")).distinct().count());
    }

}
