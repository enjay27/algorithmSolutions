package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4485_memoization {

    static int[] moveX = {0, -1, 0, 1};
    static int[] moveY = {-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int[][] memo;
    static int size;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = 1;
        while (true) {
            size = sc.nextInt();
            if (size == 0) break;

            map = new int[size][size];
            visited = new boolean[size][size];
            memo = new int[size][size];
            for (int[] ints : memo) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            min = 0;

            for (int i = 0; i < size; i++) {
                min += map[i][0];
                min += map[size - 1][i];
            }
            min -= map[size - 1][0];

            tracking(0, 0, 0);
            System.out.printf("Problem %d: %d\n", tc, memo[size - 1][size - 1]);
            tc++;
        }
    }

    static void tracking(int curX, int curY, int curMoney) {
        if (curX < 0 || curX >= size || curY < 0 || curY >= size) {
            return;
        }
        if (visited[curY][curX]) {
            return;
        }
        if (memo[curY][curX] < curMoney + map[curY][curX]) {
            return;
        }

        memo[curY][curX] = Math.min(curMoney + map[curY][curX], memo[curY][curX]);

        for (int i = 0; i < 4; i++) {
            visited[curY][curX] = true;
            tracking(curX + moveX[i], curY + moveY[i], curMoney + map[curY][curX]);
            visited[curY][curX] = false;
        }
    }

    static int memoizationV1(int desX, int desY) {
        if (desX < 0 || desX >= size || desY < 0 || desY >= size) {
            return -1;
        }
        if (visited[desY][desX]) {
            return -1;
        }
        if (desX == 0 && desY == 0) {
            return map[desY][desX];
        }

        if (memo[desY][desX] == 0) {
            int min = 100;
            for (int i = 0; i < 4; i++) {
                visited[desY][desX] = true;
                int memoization = memoizationV1(desX + moveX[i], desY + moveY[i]);
                if (memoization == -1) continue;
                min = Math.min(min, memoization);
                visited[desY][desX] = false;
            }
            memo[desY][desX] = min + map[desY][desX];
        }

        return memo[desY][desX];
    }

    static int memoizationV2(int curX, int curY) {
        if (curX < 0 || curX >= size || curY < 0 || curY >= size) {
            return -1;
        }
        if (memo[curY][curX] == -1) {
            return -1;
        }
        return memo[curY][curX];
    }
}
