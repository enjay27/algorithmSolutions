package baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution16236_fromShark {
    static int[][] map;
    static int[][] visited;
    static int size;
    static int level = 2;
    static int exp = 0;
    static int minDistance = -1;
    static Point sharkPoint = new Point();
    static List<Point> fishList = new ArrayList<>();
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int input = sc.nextInt();
                map[i][j] = input;
                if (input == 9) {
                    sharkPoint.x = j;
                    sharkPoint.y = i;
                }
            }
        }


        // 우선순위 : 위 -> 왼
        visited = new int[size][size];
        int totalSecond = 0;

        checkPrey();

        while (minDistance != Integer.MAX_VALUE) {

            int top = size;
            int left = size;
            Point hunted = new Point();
            for (int i = 0; i < fishList.size(); i++) {
                Point point = fishList.get(i);
                if (point.y < top) {
                    top = point.y;
                    left = point.x;
                    hunted = point;
                } else if (point.y == top) {
                    if (point.x < left) {
                        left = point.x;
                        hunted = point;
                    }
                }
            }

            map[sharkPoint.y][sharkPoint.x] = 0;
            map[hunted.y][hunted.x] = 9;
            sharkPoint = hunted;
            totalSecond += minDistance;
            exp++;
            if (exp == level) {
                level++;
                exp = 0;
            }
            checkPrey();
        }

        System.out.println(totalSecond);

    }

    static void checkPrey() {

        minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        if (isAvailable()) {
            tracking(sharkPoint.x, sharkPoint.y, 0);
        }
    }

    static boolean isAvailable() {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] > 0 && map[i][j] < level) {
                    result = true;
                    break;
                }
            }
            if (result) break;
        }
        return result;
    }

    static void tracking(int curX, int curY, int curDistance) {
        if (curX < 0 || curX >= size || curY < 0 || curY >= size) return;

        if (visited[curY][curX] <= curDistance) return;
        else visited[curY][curX] = curDistance;

        if (curDistance > minDistance) return;

        if (map[curY][curX] != 9 && map[curY][curX] < level && map[curY][curX] > 0) {
            if (minDistance > curDistance) {
                fishList.clear();
                minDistance = curDistance;
                fishList.add(new Point(curX, curY));
            } else {
                if (visited[curY][curX] != Integer.MAX_VALUE) {
                    fishList.add(new Point(curX, curY));
                }
            }
            return;
        }

        if (map[curY][curX] > level && map[curY][curX] != 9) return;

        for (int i = 0; i < 4; i++) {
            tracking(curX + moveX[i], curY + moveY[i], curDistance + 1);
        }

    }
}
