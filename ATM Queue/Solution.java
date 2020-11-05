package com.kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bufferedReader.readLine());
        int caseCounter = 1;
        while (tests > 0) {
            String[] firstLine = bufferedReader.readLine().split(" ");
            int people = Integer.parseInt(firstLine[0]);
            Integer amount = Integer.parseInt(firstLine[1]);
            String[] secondLine = bufferedReader.readLine().split(" ");

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < people; i++) {
                queue.add(Integer.parseInt(secondLine[i]));
            }
            Queue<Integer> id = new ArrayDeque<>();
            for (int i = 1; i <= people; i++) {
                id.add(i);
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Case #").append(caseCounter++).append(":");

            while ((queue.peek() != null) && (id.peek() != null)) {
                if ((amount - queue.peek()) >= 0) {
                    stringBuilder.append(" ").append(id.peek());
                    queue.poll();
                    id.poll();
                } else if ((amount - queue.peek()) < 0) {
                    Integer buff = queue.poll() - amount;
                    Integer idBuff = id.poll();
                    queue.add(buff);
                    id.add(idBuff);
                }
            }

            System.out.println(stringBuilder);

            tests--;
            if (tests == 0) bufferedReader.close();
        }
    }
}
