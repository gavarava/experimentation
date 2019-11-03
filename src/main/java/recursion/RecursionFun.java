package recursion;

public class RecursionFun {


    public static long factorialWithIteration(long input) {
        if (input == 1 || input == 0) {
            return 1;
        }
        int output = 1;
        for (long i = input; i >= 1; i--) {
            output *= i;
        }
        return output;
    }

    public static long factorial(long input) {
        if (input == 1L || input == 0L) {
            return 1L;
        }
        return input * factorial(input - 1L);
    }


    public static int sumOfDigitsUsingRecursion(int input) {
        if (input == 0) {
            return input;
        }
        return input % 10 + sumOfDigitsUsingRecursion(input / 10);
    }
}
