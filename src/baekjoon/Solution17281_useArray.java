package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution17281_useArray {
    static int[] selected = new int[9];
    static boolean[] visited = new boolean[9];
    static int numberOfInnings;
    static int curBatter = -1;
    static int maxScore = 0;
    static int[][] innings;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numberOfInnings = sc.nextInt();
        innings = new int[numberOfInnings][9];

        for (int i = 0; i < numberOfInnings; i++) {
            for (int j = 0; j < 9; j++) {
                innings[i][j] = sc.nextInt();
            }
        }

        visited[0] = true;
        selected[3] = 0;

        permutation(0);

        System.out.println(maxScore);
    }

    static void permutation(int select) {
        if (select == 9) {
            int score = 0;
            curBatter = -1;
            for (int i = 0; i < numberOfInnings; i++) {
                score += simulateInning(i);
            }
            maxScore = Math.max(score, maxScore);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i]) continue;
            if (select == 3) select++;
            visited[i] = true;
            selected[select] = i;
            permutation(select + 1);
            visited[i] = false;
        }
    }

    static int simulateInning(int curInning) {
        int out = 0;
        boolean[] ground = new boolean[3];
        // 1 2 3 4
        int score = 0;
        while (true) {
            curBatter++;
            if (curBatter == 9) curBatter = 0;
            int type = innings[curInning][selected[curBatter]];
            if (type == 0) {
                out++;
                if (out == 3) break;
                continue;
            }

            score += run(type, ground);
        }
        return score;
    }

    static int run(int type, boolean[] ground) {
        int score = 0;
        // 1->2 2->1

        if (type == 4) {
            score++;
            for (int i = 0; i < 3; i++) {
                if (ground[i]) {
                    score++;
                    ground[i] = false;
                }
            }
        } else {
            for (int i = 2; i >= 3 - type; i--) {
                if (ground[i]) {
                    ground[i] = false;
                    score++;
                }
            }
            for (int i = 2; i >= type; i--) {
                ground[i] = ground[i - type];
                ground[i - type] = false;
            }
            ground[type - 1] = true;
        }

        return score;
    }
}
