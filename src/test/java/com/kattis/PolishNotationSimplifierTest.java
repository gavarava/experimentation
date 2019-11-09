package com.kattis;

import static com.kattis.PolishNotationSimplifier.simplify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.InputFetcher;
import org.junit.jupiter.api.Test;

class PolishNotationSimplifierTest {

    @Test
    void testCostantExpression_UYNBALANCED() {
        String input = "+ + 1 + 3 3";
        long startTimeMillisec = System.currentTimeMillis();
        String result = simplify(
            input);
        long endTimeMillisec = System.currentTimeMillis();
        System.out.println(input + " -- EXECUTION TIME = " + (endTimeMillisec - startTimeMillisec) + " milliseconds");
        assertThat(result, is("7"));
        System.out.println(result);
    }

    @Test
    void testVariableExpressionWithConstants_UYNBALANCED() {
        String input = "+ + x + 3 3";
        long startTimeMillisec = System.currentTimeMillis();
        String result = simplify(
            input);
        long endTimeMillisec = System.currentTimeMillis();
        System.out.println(input + " -- EXECUTION TIME = " + (endTimeMillisec - startTimeMillisec) + " milliseconds");
        assertThat(result, is("+ + x 6"));
        System.out.println(result);
    }

    @Test
    void testVariableExpressionWithConstants() {
        String input = "+ + x y + 3 3";
        long startTimeMillisec = System.currentTimeMillis();
        String result = simplify(
            input);
        long endTimeMillisec = System.currentTimeMillis();
        System.out.println(input + " -- EXECUTION TIME = " + (endTimeMillisec - startTimeMillisec) + " milliseconds");
        assertThat(result, is("+ + x y 6"));
        System.out.println(result);
    }

    @Test
    void testVariableExpressionWithConstants_2() {
        String input = "* - 6 + x -6 - - 9 6 * 0 c";
        long startTimeMillisec = System.currentTimeMillis();
        String result = simplify(
            input);
        long endTimeMillisec = System.currentTimeMillis();
        System.out.println(input + " -- EXECUTION TIME = " + (endTimeMillisec - startTimeMillisec) + " milliseconds");
        assertThat(result, is("* - 6 + x -6 - 3 * 0 c"));
        System.out.println(result);
    }

    @Test
    void testVariableExpressionWithConstants_3_with_values_revealed() {
        // c = 1 x = 1
        String input = "* - 6 + 1 -6 - - 9 6 * 0 1";
        long startTimeMillisec = System.currentTimeMillis();
        String result = simplify(
            input);
        long endTimeMillisec = System.currentTimeMillis();
        System.out.println(input + " -- EXECUTION TIME = " + (endTimeMillisec - startTimeMillisec) + " milliseconds");
        assertThat(result, is(simplify("* - 6 + 1 -6 - 3 * 0 1")));
        System.out.println(result);
    }


    @Test
    void testVariableEXp() {
        String input = "+ x y";
        long startTimeMillisec = System.currentTimeMillis();
        String result = simplify(
            input);
        long endTimeMillisec = System.currentTimeMillis();
        System.out.println(input + " -- EXECUTION TIME = " + (endTimeMillisec - startTimeMillisec) + " milliseconds");
        assertThat(result, is(input));
        System.out.println(result);
    }

    @Test
    void testBasic() {
        String negatives = "+ + + * -2 -1 * -2 -4 -3 - -100 -123";
        System.out.println(simplify(
            negatives));
    }

    @Test
    void testForLongestInputPossible() {
        String input = "- + + * + - + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + - + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * + - + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + - + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + + * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 * * + + + * 2 1 * 0 4 3 - 10 9 10 * + + + * 2 1 * 0 4 3 - 10 9 10 + + 3 4 3";
        input = new StringBuffer("*")
            .append(" ")
            .append(input)
            .append(" ")
            .append(input)
            .toString();
        System.out.println("input size = " + input.split(" ").length);

        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        long startTimeMillisec = System.currentTimeMillis();
        String output = simplify(input);
        long endTimeMillisec = System.currentTimeMillis();
        System.out.println("BIG INP EXECUTION TIME = " + (endTimeMillisec - startTimeMillisec) + " milliseconds");

        System.out.println("OUTPUT___VALUE = " + output);
        if (!output.contains(" ")) {
            System.out.println("Compare Output with Long MAX = " + Long.valueOf(output).compareTo(Long.MAX_VALUE));
        }
    }


    @Test
    void testForNegativeValues() {

        InputFetcher inputFetcher = new InputFetcher("polishnotationfiles/polishnotation3_negatvies", " ");
        String input = inputFetcher.getInputDataAsString();
        System.out.println("input size = " + input.split(" ").length);

        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        String output = simplify(input);
        System.out.println("OUTPUT___VALUE = " + output);
        if (!output.contains(" ")) {
            System.out
                .println("Compare Output with Long MAX = " + Integer.valueOf(output).compareTo(Integer.MAX_VALUE));
        }
    }

    @Test
    void testForPositiveValues() {

        InputFetcher inputFetcher = new InputFetcher("polishnotationfiles/polishnotation3", " ");
        String input = inputFetcher.getInputDataAsString();
        System.out.println("input size = " + input.split(" ").length);

        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        long startTimeMillisec = System.currentTimeMillis();
        String output = simplify(input);
        long endTimeMillisec = System.currentTimeMillis();
        System.out.println("BIG INP EXECUTION TIME = " + (endTimeMillisec - startTimeMillisec) + " milliseconds");
        System.out.println("OUTPUT___VALUE = " + output);
        if (!output.contains(" ")) {
            System.out
                .println("Compare Output with Long MAX = " + Integer.valueOf(output).compareTo(Integer.MAX_VALUE));
        }
    }

}