package baekjoon;

import java.util.Scanner;

public class Solution14499 {
    static int height;
    static int width;
    static int[] moveX = {0, 1, -1, 0, 0};
    static int[] moveY = {0, 0, 0, -1, 1};
    static int[] diceX = {0, 0, 0, 0};
    static int[] diceY = {0, 0, 0, 0};
    static int dicePointX = 0;
    static int dicePointY = 0;
    static StringBuilder sb = new StringBuilder();
    static int curX;
    static int curY;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();

        curX = sc.nextInt();
        curY = sc.nextInt();
        int length = sc.nextInt();

        map = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < length; i++) {
            int direction = sc.nextInt();
            moveDice(direction);
        }
        System.out.println(sb.toString());
    }

    static void moveDice(int direction) {
        if (curX + moveX[direction] >= 0 && curX + moveX[direction] < width && curY + moveY[direction] >= 0 && curY + moveY[direction] < height) {
            curX += moveX[direction];
            curY += moveY[direction];
            if (direction <= 2) {
                moveHorizontal(moveX[direction]);
            } else {
                moveVertical(moveY[direction]);
            }
        }
    }

    static void moveHorizontal(int moveX) {
        dicePointX -= moveX;
        if (dicePointX < 0) {
            dicePointX += 4;
        } else {
            dicePointX %= 4;
        }
        int topValue = diceX[dicePointX];
        sb.append(topValue);
        sb.append("\n");
        int xBottomPoint = (dicePointX + 2) % 4;
        int yBottomPoint = (dicePointY + 2) % 4;

        diceY[dicePointY] = topValue;
        diceX[dicePointX] = topValue;

        boolean isZero = map[curY][curX] == 0;
        if (isZero) {
            map[curY][curX] = diceX[xBottomPoint];
            diceY[yBottomPoint] = diceX[xBottomPoint];
        } else {
            int bottomValue = map[curY][curX];
            diceY[yBottomPoint] = bottomValue;
            diceX[xBottomPoint] = bottomValue;
            map[curY][curX] = 0;
        }
    }

    static void moveVertical(int moveY) {
        dicePointY -= moveY;
        if (dicePointY < 0) {
            dicePointY += 4;
        } else {
            dicePointY %= 4;
        }
        int topValue = diceY[dicePointY];
        sb.append(topValue);
        sb.append("\n");
        int yBottomPoint = (dicePointY + 2) % 4;
        int xBottomPoint = (dicePointX + 2) % 4;

        diceY[dicePointY] = topValue;
        diceX[dicePointX] = topValue;

        boolean isZero = map[curY][curX] == 0;
        if (isZero) {
            map[curY][curX] = diceY[yBottomPoint];
            diceX[xBottomPoint] = diceY[yBottomPoint];
        } else {
            int bottomValue = map[curY][curX];
            diceY[yBottomPoint] = bottomValue;
            diceX[xBottomPoint] = bottomValue;
            map[curY][curX] = 0;
        }
    }
}
