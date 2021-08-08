package swea;

import java.util.Scanner;

public class Solution1861 {
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};
    static int max;
    static int size;
    static int[][] map;
    static int start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int test_case = 1; test_case <= test; test_case++) {
            //nanoTime
            long startTime = System.nanoTime();

            size = sc.nextInt();
            map = new int[size][size];
            max = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    recursive(map[i][j], map[i][j], j, i, 0);
                }
            }
            System.out.printf("#%d %d %d\n", test_case, start, max + 1);

            long estimatedTime = System.nanoTime() - startTime;

            System.out.println("걸린 시간 : " + estimatedTime/1000000000.0 + " milli seconds");
        }
    }

    static void recursive(int startNum, int prevNum, int curX, int curY, int moveCount) {
        if (moveCount != 0) {
            if (curX < 0 || curY < 0 || curX >= size || curY >= size) {
                return;
            }
            if (prevNum + 1 != map[curY][curX]) {
                return;
            }
        }

        if (max < moveCount) {
            start = startNum;
            max = moveCount;
        } else if (max == moveCount) {
            start = Math.min(startNum, start);
        }

        for (int i = 0; i < 4; i++) {
            recursive(startNum, map[curY][curX], curX + moveX[i], curY + moveY[i], moveCount + 1);
        }
    }
}
