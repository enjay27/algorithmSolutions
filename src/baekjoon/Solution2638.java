package baekjoon;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution2638 {
    static int height;
    static int width;
    static int[][] cheese;
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveX = {0, 1, 0, -1};
    static boolean[][] outerArea;
    static Stack<Point> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        cheese = new int[height][width];
        outerArea = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cheese[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        while (true) {

            for (boolean[] booleans : outerArea) {
                Arrays.fill(booleans, false);
            }

            for (int i = 0; i < height; i++) {
                innerCheck(0, i);
                innerCheck(width - 1, i);
            }

            for (int i = 0; i < width; i++) {
                innerCheck(i, 0);
                innerCheck(i, height - 1);
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    melting(j, i);
                }
            }
            if (stack.isEmpty()) break;

            count++;

            while (!stack.isEmpty()) {
                Point pop = stack.pop();
                cheese[pop.y][pop.x] = 0;
            }
        }

        System.out.println(Arrays.deepToString(cheese));
        System.out.println("count = " + count);
    }

    static void innerCheck(int curX, int curY) {
        if (curX < 0 || curX >= width || curY < 0 || curY >= height) return;
        if (cheese[curY][curX] == 1) return;
        if (outerArea[curY][curX]) return;

        outerArea[curY][curX] = true;

        for (int i = 0; i < 4; i++) {
            innerCheck(curX + moveX[i], curY + moveY[i]);
        }
    }

    static void melting(int curX, int curY) {
        if (cheese[curY][curX] == 0) return;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int movedX = curX + moveX[i];
            int movedY = curY + moveY[i];
            if (movedX < 0 || movedX >= width || movedY < 0 || movedY >= height) continue;
            if (cheese[movedY][movedX] == 0 && outerArea[movedY][movedX]) count++;
        }

        if (count >= 2) {
            stack.push(new Point(curX, curY));
        }
    }
}
