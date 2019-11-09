package com.kattis;

import java.util.Scanner;
import java.util.Stack;

public class PolishNotationSimplifier {

    private static final String WHITESPACE = "\\s";
    private static final int DEFAULT_VALUE_OF_OPERAND = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxNumberOfCases = 5;
        int caseCount = 1;
        while (sc.hasNext()) {
            if (maxNumberOfCases == 0) {
                break;
            }
            String prefixExpression = sc.nextLine();
            System.out.println("Case " + caseCount++ + ": " + simplify(prefixExpression));
            maxNumberOfCases--;
        }
    }

    static final String simplify(String prefixExpression) {
        String[] input = prefixExpression.split(WHITESPACE);
        Stack<String> prefixExpressionStack = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            if (!isOperator(input[i])) {
                prefixExpressionStack.push(input[i]);
            } else {
                evaluateOperandsFromTopOfStack(input[i], prefixExpressionStack);
            }
        }
        return convertResultStackToString(prefixExpressionStack).trim();
    }

    private static boolean isOperator(String input) {
        return input.equals("*") || input.equals("+") || input.equals("-");
    }

    private static void evaluateOperandsFromTopOfStack(String operator, Stack<String> expressionStack) {
        if (expressionStack.size() == 1) {
            // If stack contains only one element then pop only once
            String firstOperandString = expressionStack.pop();
            if (isVariableExpression(firstOperandString)) {
                // if any operands are a variable like x then convert whole set of operands & operator into a single stack element
                expressionStack.push(operator + " " + firstOperandString);
            } else {
                Integer firstOperandNumber = Integer.valueOf(firstOperandString);
                Integer evaluation = evaluate(firstOperandNumber, DEFAULT_VALUE_OF_OPERAND, operator);
                expressionStack.push(String.valueOf(evaluation));
            }
        } else {
            String firstOperandString = expressionStack.pop();
            String secondOperandString = expressionStack.pop();
            if (isVariableExpression(firstOperandString) || isVariableExpression(secondOperandString)) {
                // if any operands are a variable like x, y etc then convert whole set of operands & operator into a single stack element
                // this ensures to treat them as a single entity as we cannot operate on them and reduce them, so we reduce them by making them a single entity
                expressionStack.push(operator + " " + firstOperandString + " " + secondOperandString);
            } else {
                // evaluate operands as they are integers
                Integer firstOperandNumber = Integer.valueOf(firstOperandString);
                Integer secondOperandNumber = Integer.valueOf(secondOperandString);
                Integer evaluation = evaluate(firstOperandNumber, secondOperandNumber, operator);
                expressionStack.push(String.valueOf(evaluation));
            }
        }
    }

    private static boolean isVariableExpression(String operandFromStack) {
        try {
            Integer.parseInt(operandFromStack);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static Integer evaluate(Integer firstOperand, Integer secondOperand, String operator) {
        Integer result = 0;
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
        }
        return result;
    }

    private static String convertResultStackToString(Stack<String> stringStack) {
        StringBuilder result = new StringBuilder();
        stringStack.forEach(s -> result.append(s).append(" "));
        return result.toString();
    }
}
