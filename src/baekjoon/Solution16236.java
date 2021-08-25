package baekjoon;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Solution16236 {
    static int[][] map;
    static boolean[][] visited;
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
        visited = new boolean[size][size];
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

        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
        minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] < level && map[i][j] > 0)
                    tracking(j, i, j, i, 0);
            }
        }
    }

    static void tracking(int startX, int startY, int curX, int curY, int curDistance) {
        if (curX < 0 || curX >= size || curY < 0 || curY >= size) return;

        if (visited[curY][curX]) return;

        if (map[curY][curX] == 9) {
            if (minDistance > curDistance) {
                fishList.clear();
                minDistance = curDistance;
                fishList.add(new Point(startX, startY));
            } else if (minDistance == curDistance) {
                if (!fishList.contains(new Point(startX, startY))) {
                    fishList.add(new Point(startX, startY));
                }
            }
            return;
        }

        if (map[curY][curX] > level) return;

        visited[curY][curX] = true;

        for (int i = 0; i < 4; i++) {
            tracking(startX, startY, curX + moveX[i], curY + moveY[i], curDistance + 1);
        }

        visited[curY][curX] = false;
    }
}
