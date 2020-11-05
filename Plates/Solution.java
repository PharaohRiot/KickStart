package com.kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bufferedReader.readLine());
        int caseCounter = 1;

        while (tests > 0) {
            String[] firstLineInput = bufferedReader.readLine().split(" ");
            int nStacks = Integer.parseInt(firstLineInput[0]);
            int kBeauty = Integer.parseInt(firstLineInput[1]);
            int pMax = Integer.parseInt(firstLineInput[2]);
//            Integer[][] intDoubleArr = new Integer[nStacks][kBeauty];
//            for (int i = 0; i < nStacks; i++) {
//                String[] beautyArr = bufferedReader.readLine().split(" ");
//                for (int j = 0; j < kBeauty; j++) {
//                    intDoubleArr[i][j] = Integer.parseInt(beautyArr[j]);
//                    calMax(intDoubleArr, nStacks, kBeauty, pMax);
//                }
//            }
            List<List<Integer>> platesGroup = new ArrayList<>();
            for (int i = 0; i < nStacks; i++) {
                List<Integer> stackOfPlates = new ArrayList<>();
                String[] inputLine = bufferedReader.readLine().split(" ");
                for (int j = 0; j < kBeauty; j++) {
                    stackOfPlates.add(Integer.parseInt(inputLine[j]));
                }
                platesGroup.add(stackOfPlates);
            }

            int result = Collections.max(listCollectionOfResults(platesGroup, pMax, kBeauty));
            System.out.println("Case #" + caseCounter++ + ": " + " " + result);

            tests--;
            if (tests == 0) bufferedReader.close();
        }
    }

    private static List<Integer> listCollectionOfResults(List<List<Integer>> platesGroup, int pMax, int kBeauty) {
        List<Integer> resultStats = new ArrayList<>();
        logic(platesGroup, resultStats, pMax, 0, 0, kBeauty);
        return resultStats;
    }

    private static void logic(List<List<Integer>> platesGroup, List<Integer> resultStats, int pMax, int currentStackInPlatesGroup, int sum, int kBeauty) {
        if (pMax < 0)
            return;
        if (pMax == 0 || platesGroup.size() == currentStackInPlatesGroup + 1) {
            int result = getValueFromStack(platesGroup.get(currentStackInPlatesGroup), pMax) + sum;
            if (result > 0) {
                resultStats.add(result);
            }
            return;
        }
        for (int i = 0; i <= kBeauty; i++) {
            int value = getValueFromStack(platesGroup.get(currentStackInPlatesGroup), i);
            logic(platesGroup, resultStats, pMax - i, currentStackInPlatesGroup + 1, sum + value, kBeauty);
        }
    }

    private static int getValueFromStack(List<Integer> stack, int toPosition) {
        if (stack.size() < toPosition)
            return -1;
        int sum = 0;
        for (int i = 0; i < toPosition; i++) {
            sum += stack.get(i);
        }
        return sum;
    }
}
