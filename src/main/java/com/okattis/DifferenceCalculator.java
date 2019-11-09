package com.okattis;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DifferenceCalculator {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println(Math.abs(a-b));
        }
    }


}
