package com.kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bufferedReader.readLine());

        while (tests > 0) {
            String[] firstLineInput = bufferedReader.readLine().split(" ");
            String[] secondLineInput = bufferedReader.readLine().split(" ");
            int excercises = Integer.parseInt(firstLineInput[0]);
            int expandExercises = Integer.parseInt(firstLineInput[1]);
            int[] intervals = new int[excercises];

            for (int i = 0; i < excercises; i++) {
                intervals[i] = Integer.parseInt(secondLineInput[i]);
            }

            int[] result = helper(intervals, expandExercises);

            // to do
//            if kx == 0.xx
//            return count max diff;

            // to do
//            if 2 / 2 = 0
//                    add to end

            System.out.println(Arrays.toString(result));

            tests--;
            if (tests == 0) bufferedReader.close();
        }
    }

    private static int[] helper(int[] input, int expandExercises) {       // created this method for less time complexity
        while (expandExercises > 0) {
            input = updateArray(input, findMaxDiff(input));
            expandExercises--;
        }
        return input;
    }

    private static int[] updateArray(int[] originalArray, int[] diffmaxNposition) {
        int[] updatedArray = new int[originalArray.length + 1];
        int max = diffmaxNposition[0];
        int[] result = new int[2];
        result[0] = max / 2;                // to add
        result[1] = diffmaxNposition[1];    // position

        for (int i = 0; i < originalArray.length; i++) {
            if (i < result[1] + 1)
                updatedArray[i] = originalArray[i];
            else if (i == result[1] + 1) {
                updatedArray[i] = originalArray[i - 1] + result[0];
                updatedArray[i + 1] = originalArray[i];
            } else
                updatedArray[i + 1] = originalArray[i];
        }
        return updatedArray;
    }

    private static int[] findMaxDiff(int[] input) {
        int[] maxDiffnPosition = new int[2];
        int maxDiff = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if (maxDiff < Math.abs(input[i] - input[i + 1])) {
                maxDiffnPosition[0] = Math.abs(input[i] - input[i + 1]);
                maxDiffnPosition[1] = i;
                maxDiff = Math.abs(input[i] - input[i + 1]);
            }
        }
        return maxDiffnPosition;
    }
}

