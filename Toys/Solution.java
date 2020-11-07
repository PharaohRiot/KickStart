package com.kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int caseCounter = 1;
    private final static String indefinitely = "INDEFINITELY";
    private static int removed = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bufferedReader.readLine());
        while (tests > 0) {
            int numOfToys = Integer.parseInt(bufferedReader.readLine());
            int[] e = new int[numOfToys];
            int[] r = new int[numOfToys];
            int p = numOfToys;
            int x = 0;
            while (p > 0) {
                String[] inputLine = bufferedReader.readLine().split(" ");
                e[x] = Integer.parseInt(inputLine[0]);
                r[x] = Integer.parseInt(inputLine[1]);
                x++;
                p--;
            }
            Object[] sorted = sorter(e, r);
            e = (int[]) sorted[0];
            r = (int[]) sorted[1];

            int check = magic(e, r);
            if (check > -1) {
                Object[] remover = remove(e, r, check);
                e = (int[]) remover[0];
                r = (int[]) remover[1];
                magic(e, r);
            }
            tests--;
            if (tests == 0) bufferedReader.close();
        }
    }

    private static int magic(int[] E, int[] R) {
        boolean[] readyToGoNi = new boolean[R.length];
        Arrays.fill(readyToGoNi, Boolean.FALSE);
        int[] sleepLogicOfNi = new int[R.length];
        int counter = 0;
        int sum = 0;
        fill(sleepLogicOfNi, R);
        int puss = 0;

        if (E.length == 1 && R.length == 1) {
            printer(E[0]);
        } else {
            while (true) {
                for (int i = 0; i < sleepLogicOfNi.length; i++) {
                    if (i + 1 < E.length) {
                        if (sleepLogicOfNi[i] == 0) {
                            sleepLogicOfNi[i] = R[i];
                            readyToGoNi[i] = false;
                            sum += E[i];
                        } else if ((sleepLogicOfNi[i] - E[i + 1]) <= 0) {
                            readyToGoNi[i] = true;
                            sleepLogicOfNi[i] = R[i];
                            sum += E[i];
                        } else {
                            if (counter > 0 && !readyToGoNi[i]) {
                                puss++;
                                if (puss == 2) {
                                    removed++;
                                    return i;
                                }
                                continue;
                            }
                            sleepLogicOfNi[i] = sleepLogicOfNi[i] - E[i + 1];
                            sum += E[i];
                            readyToGoNi[i] = false;
                        }

                    } else {
                        if ((sleepLogicOfNi[i] - E[0]) <= 0) {
                            readyToGoNi[i] = true;
                            sleepLogicOfNi[i] = R[i];
                            sum += E[i];
                        } else {
                            if (counter > 0 && !readyToGoNi[i]) {
                                puss++;
                                if (puss == 2) {
                                    removed++;
                                    return i;
                                }
                                continue;
                            }
                            sleepLogicOfNi[i] = sleepLogicOfNi[i] - E[0];
                            sum += E[i];
                            readyToGoNi[i] = false;
                        }

                    }
                    for (int j = i - 1; j >= 0; j--) {
                        if (!readyToGoNi[j]) {
                            if (sleepLogicOfNi[j] - E[0] <= 0) {
                                sleepLogicOfNi[j] = sleepLogicOfNi[j] - E[0];
                                readyToGoNi[j] = true;
                            }
                        }
                    }
                }
                counter++;
                if (counter > 0) {
                    if (areAllFalse(readyToGoNi)) {
                        printer(sum);
                        break;
                    }
                }
                if (counter > 5 && areAllTrue(readyToGoNi)) {
                    printer();
                    break;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    private static Object[] remove(int[] e, int[] r, int indexToRemove) {
        Object[] result = new Object[2];
        int[] eNew = new int[e.length];
        int[] rNew = new int[e.length];
        for (int i = 0; i < e.length; i++) {
            if (i < indexToRemove) {
                eNew[i] = e[i];
                rNew[i] = r[i];
            } else if (i == indexToRemove) {
                eNew[i] = Integer.MAX_VALUE;
                rNew[i] = Integer.MAX_VALUE;
            } else {
                eNew[i] = e[i];
                rNew[i] = r[i];
            }
        }
        result[0] = Arrays.stream(eNew).filter(x -> x != Integer.MAX_VALUE).toArray();
        result[1] = Arrays.stream(rNew).filter(x -> x != Integer.MAX_VALUE).toArray();
        return result;
    }

    private static void printer(int a) {
        System.out.println("Case #" + caseCounter++ + ": " + removed + " " + a);
        setRemoved();
    }

    private static void printer() {
        System.out.println("Case #" + caseCounter++ + ": " + removed + " " + indefinitely);
        setRemoved();
    }

    private static Object[] sorter(int[] e, int[] r) {
        Object[] resultObject = new Object[2];
        for (int i = 0; i < e.length - 1; i++) {
            if (e[i] > e[i + 1]) {
                int buffE = e[i + 1];
                int buffR = r[i + 1];
                e[i + 1] = e[i];
                r[i + 1] = r[i];
                e[i] = buffE;
                r[i] = buffR;
            }
        }
        resultObject[0] = e;
        resultObject[1] = r;

        return resultObject;
    }

    private static void fill(int[] sleepLogicOfNi, int[] R) {
        System.arraycopy(R, 0, sleepLogicOfNi, 0, sleepLogicOfNi.length);
    }

    private static boolean areAllFalse(boolean[] array) {
        for (boolean b : array)
            if (b)
                return false;
        return true;
    }

    private static boolean areAllTrue(boolean[] array) {
        for (boolean b : array)
            if (!b)
                return false;
        return true;
    }

    public static void setRemoved() {
        removed = 0;
    }
}
