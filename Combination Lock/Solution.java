package com.kickstart;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int caseCounter = 1;
        long toPrint = 0;
        for (int test = 0; test < tests; test++) {
            int n = sc.nextInt();
            int w = sc.nextInt();
            int[] input = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                input[j] = sc.nextInt();
                sum += input[j];
            }
            if (n > 1) {
                int here = 0;
                Arrays.sort(input);
                long firstHalf = Integer.MIN_VALUE;
                for (int i = 0; i < input.length - 1; i++) {
                    long abs = Math.abs(input[i] - input[i + 1]);
                    if (abs >= firstHalf) {
                        firstHalf = abs;
                        here = i;
                    }
                }
                long secondHalf = Math.abs(((w - input[input.length - 1]) + input[0]));
                if (firstHalf < secondHalf) {
                    toPrint = countMovesForFirstHalf(input[here - 1] + (firstHalf / n), input);
                } else {
                    toPrint = countMovesForSecondHalf(secondHalf / 2, input, here, w);
                }
            }
            System.out.println("Case #" + caseCounter++ + ": " + toPrint);
        }
        sc.close();
    }

    private static int countMovesForFirstHalf(long countTo, int[] arrayInput) {
        int counter = 0;
        for (int j : arrayInput) {
            counter += Math.abs(j - countTo);
        }
        return counter;
    }

    private static int countMovesForSecondHalf(long countTo, int[] arrayInput, int tohere, int w) {
        int counter = 0;
        for (int i = 0; i < arrayInput.length; i++) {
            if (i <= tohere)
                counter += Math.abs(arrayInput[i] - countTo);
            else
                counter += Math.abs(w - arrayInput[i] + countTo);
        }
        return counter;
    }
}
