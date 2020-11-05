package com.kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bufferedReader.readLine());
        int caseCount = 0;
        while (tests > 0) {
            String[] inputLine = bufferedReader.readLine().split(" ");
            int nHouses = Integer.parseInt(inputLine[0]);
            int budget = Integer.parseInt(inputLine[1]);
            int count = 0;

            String[] opportunity = bufferedReader.readLine().split(" ");
            Integer[] arr = new Integer[opportunity.length];
            for (int i = 0; i < opportunity.length; i++) {
                arr[i] = Integer.parseInt(opportunity[i]);
            }
            Arrays.sort(arr);
            for (Integer integer : arr) {
                if ((budget - integer) >= 0) {
                    budget = budget - integer;
                    count++;
                }
            }
            caseCount++;
            System.out.println("Case #" + caseCount + ": " + count);

            tests--;
            if (tests == 0) bufferedReader.close();
        }
    }
}
