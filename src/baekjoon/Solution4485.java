package baekjoon;

import java.util.Scanner;

public class Solution4485 {

    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int size;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            size = sc.nextInt();
            if (size == 0) break;

            map = new int[size][size];
            visited = new boolean[size][size];

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
            System.out.println(min);
        }
    }

    static void tracking(int curX, int curY, int curMoney) {
        if (curX < 0 || curX >= size || curY < 0 || curY >= size) {
            return;
        }
        if (visited[curY][curX]) {
            return;
        }
        if (curMoney >= min) {
            return;
        }
        if (curX == size - 1 && curY == size - 1) {
            min = Math.min(curMoney + map[curY][curX], min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            visited[curY][curX] = true;
            tracking(curX + moveX[i], curY + moveY[i], curMoney + map[curY][curX]);
            visited[curY][curX] = false;
        }
    }
}
