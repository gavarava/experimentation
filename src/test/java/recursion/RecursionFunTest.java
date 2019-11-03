package recursion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static recursion.RecursionFun.factorial;
import static recursion.RecursionFun.factorialWithIteration;
import static recursion.RecursionFun.sumOfDigitsUsingRecursion;

import org.junit.jupiter.api.Test;

class RecursionFunTest {

    @Test
    void calculateFactorial() {
        long input = 12;
        long startTime = System.currentTimeMillis();
        long factorial = factorial(input);
        System.out.println(factorial);
        long endTime = System.currentTimeMillis();
        System.out.println("TIME With recursion => " + (endTime-startTime));

        long startTime2 = System.currentTimeMillis();
        long factorialWithIteration = factorialWithIteration(input);
        System.out.println(factorialWithIteration);
        long endTime2 = System.currentTimeMillis();
        System.out.println("TIME With Iteration => " + (endTime2-startTime2));
    }

    @Test
    void getSumOfDigits() {
        assertThat(sumOfDigitsUsingRecursion(1234567890), is(45));
    }

}