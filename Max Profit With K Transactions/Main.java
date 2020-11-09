package com.kickstart;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 11, 3, 50, 60, 90};
        int[] array2 = {1, 100, 2, 200, 3, 300, 4, 400, 5, 500};
        int[] array3 = {50, 25, 12, 4, 3, 10, 1, 100};
        int[] array4 = {1, 100, 101, 200, 201, 300, 301, 400, 401, 500};
        int k = 2;
        System.out.println(newMax(array4, k));
    }

    private static void printer(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + "   \t");
            System.out.println();
        }
        System.out.println("--------------------");
    }

    private static String newMax(int[] input, int k) {
        if (input.length == 0 || k < 0) return Integer.MIN_VALUE;   // {5, 11, 3, 50, 60, 90}
        int[][] matrix = new int[input.length][input.length];
        int idx = 0;
        int x = 1;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = x; j < input.length; j++) {
                if (input[j] - input[i] > 0) {
                    matrix[i][idx] = input[j] - input[i];
                    int sum = input[j] - input[i];
                    idx++;
                    printer(matrix);
                } else {
                    matrix[i][idx] = input[j] - input[i];
                    int sum = input[j] - input[i];
                    idx++;
                    printer(matrix);
                }
            }
            x++;
            idx = 0;
        }
        int buff = 0;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 1; j < input.length; j++) {
                if (matrix[i][j] > 0) {
                    buff = matrix[i + 1][j + 1];
                    continue;
                }
            }
        }
//        for(int idy = 0; idy < input.length - 1; idy++) {
//            for (int j = 1; j < input.length; j++) {
//
//            }
//        }
        for (int[] finish : matrix) Arrays.sort(finish);
        printer(matrix);
        return "1, 100, 101, 200, 201, 300, 301, 400, 401, 500   +k5";
    }


    public static int maxProfitWithKTransactions(int[] input, int k) {
        if (input.length == 0 || k < 0) return Integer.MIN_VALUE;
        int[][] toFinish = new int[input.length][k];
        int idx = 0;
        int idy = 0;
        int index = input.length - 2;
        int[] saver = new int[input.length];    // 0 6 0 47 57 87
        int[] helper = new int[input.length];   //-1 0 -1 2 2 2
        Arrays.fill(helper, -1);
        int buff = 0;
        int puss = 0;
        int result = 0;
        for (int i = input.length - 1; i >= 1; i--) {
            for (int j = index; j >= 0; j--) {
                if (input[i] - input[j] > 0) {
                    buff = input[i] - input[j];
                    if (puss == 0) {
                        puss = buff;
                        helper[i] = j;
                    } else if (puss < buff) {
                        puss = buff;
                        helper[i] = j;
                    }
                    if (j == 0) {
                        saver[i] = puss;
                        toFinish[idy][idx] = puss;
                        idy++;
                        puss = 0;
                        index--;
                    }
                }
            }
        }
        idx++;
        for (int i = 0; i < toFinish.length; i++) {
            for (int j = 0; j < toFinish[i].length; j++)
                System.out.print(toFinish[i][j] + " ");
            System.out.println();
        }
        if (k == 1) {
            Arrays.sort(saver);
            return saver[saver.length - 1];
        }
        if(k > 1) {
            while (k - 1 > 0) {
                int killa = 0;
                int[] finish = new int[helper.length];
                for (int j = helper.length - 1; j > 0; j--) {
                    if (helper[j] == -1)
                        continue;
                    for (int i = helper[j] - 1; i > 0; i--) {
                        if (saver[i] == 0)
                            continue;
                        killa = Math.max(saver[i], saver[i - 1]);
                    }
                    if (Integer.compare(killa, saver[j]) == 0) {
                        finish[j] = saver[j];
                        toFinish[idy][idx] = saver[j];
                        idy++;
                    } else {
                        finish[j] = killa + saver[j];
                        toFinish[idy][idx] = killa + saver[j];
                        idy++;
                    }
                }
                idx++;
                k--;
            }
        }
        for (int[] finish : toFinish) Arrays.sort(finish);
        for (int[] finish : toFinish) {
            for (int i : finish) System.out.print(i + " ");
            System.out.println();
        }
        return Integer.MIN_VALUE;
    }

}