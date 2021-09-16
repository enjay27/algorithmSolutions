package baekjoon;

import java.util.*;

public class Solution17281 {
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
        Queue<Boolean> ground = new LinkedList<>();
        ground.offer(false);
        ground.offer(false);
        ground.offer(false);
        // 1 2 3 4
        int score = 0;
        while (true) {
            curBatter++;
            if (curBatter == 9) curBatter = 0;
            if (innings[curInning][selected[curBatter]] == 0)
                out++;
            if (out == 3) break;

            if (innings[curInning][selected[curBatter]] == 1) {
                ground.offer(true);
                if (ground.poll()) {
                    score++;
                }
            }
            else if (innings[curInning][selected[curBatter]] == 2) {
                ground.offer(true);
                ground.offer(false);
                for (int i = 0; i < 2; i++) {
                    if (ground.poll()) {
                        score++;
                    }
                }
            }
            else if (innings[curInning][selected[curBatter]] == 3) {
                ground.offer(true);
                ground.offer(false);
                ground.offer(false);
                for (int i = 0; i < 3; i++) {
                    if (ground.poll()) {
                        score++;
                    }
                }
            } else if (innings[curInning][selected[curBatter]] == 4) {
                ground.offer(true);
                ground.offer(false);
                ground.offer(false);
                ground.offer(false);
                for (int i = 0; i < 4; i++) {
                    if (ground.poll()) {
                        score++;
                    }
                }
            }
        }
        return score;
    }

    static int run(int type, Queue<Boolean> ground) {
        int score = 0;
        ground.offer(true);
        for (int i = 0; i < type - 1; i++) {
            ground.offer(false);
        }
        for (int i = 0; i < 4; i++) {
            if (ground.poll()) score++;
        }
        return score;
    }
}
