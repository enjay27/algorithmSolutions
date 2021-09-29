package baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution17136 {
    static int[][] map = new int[10][10];
    static List<Point> points = new ArrayList<>();
    static int[] limit = {0, 5, 5, 5, 5, 5};
    static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    points.add(new Point(j, i));
                }
            }
        }

        tracking(0, 0);
        minCount = minCount == Integer.MAX_VALUE ? -1 : minCount;
        System.out.println(minCount);
    }

    static void print() {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static void tracking(int index, int curCount) {
        while (index < points.size()) {
            int curX = points.get(index).x;
            int curY = points.get(index).y;
            if (map[curY][curX] == 1) {
                break;
            }
            index++;
        }
        if (index >= points.size()) {
            minCount = Math.min(curCount, minCount);
            return;
        }
        if (isFinished()) {
            minCount = Math.min(curCount, minCount);
            return;
        }

        int curX = points.get(index).x;
        int curY = points.get(index).y;

        for (int i = 5; i >= 1; i--) {
            if (limit[i] == 0) continue;
            boolean isCovered = cover_loop(curX, curY, i);
            if (!isCovered) continue;
            limit[i]--;
            tracking(index + 1, curCount + 1);
            limit[i]++;
            reveal_loop(curX, curY, i);
        }
    }

    static boolean isFinished() {
        boolean isFinished = true;
        for (Point point : points) {
            if (map[point.y][point.x] != 2) {
                isFinished = false;
                break;
            }
        }
        return isFinished;
    }


    static boolean cover_recursive(int curX, int curY, int size) {
        if (curX < 0 || curX >= 10 || curY < 0 || curY >= 10) {
            return false;
        }
        if (size == 0) {
            return true;
        }
        if (map[curY][curX] != 1) {
            return false;
        }

        boolean isPossible = cover_recursive(curX + 1, curY + 1, size - 1) &&
                cover_recursive(curX + 1, curY, size - 1) &&
                cover_recursive(curX, curY + 1, size - 1);
        if (isPossible) {
            map[curY][curX] = 2;
        }

        return isPossible;
    }

    static boolean cover_loop(int curX, int curY, int size) {
        boolean isPossible = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (curX + j >= 10 || curY + i >= 10) {
                    isPossible = false;
                    break;
                }
                if (map[curY + i][curX + j] != 1) {
                    isPossible = false;
                    break;
                }
            }
        }

        if (isPossible) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[curY + i][curX + j] = 2;
                }
            }
        }

        return isPossible;
    }

    static void reveal_loop(int curX, int curY, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[curY + i][curX + j] = 1;
            }
        }
    }

    static void reveal(int curX, int curY, int size) {
        if (curX < 0 || curX >= 10 || curY < 0 || curY >= 10) {
            return;
        }
        if (size == 0) {
            return;
        }
        if (map[curY][curX] != 2) {
            return;
        }

        reveal(curX + 1, curY + 1, size - 1);
        reveal(curX + 1, curY, size - 1);
        reveal(curX, curY + 1, size - 1);
        map[curY][curX] = 1;
    }
}
