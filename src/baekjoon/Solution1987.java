package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1987 {
    static char[][] map;
    static int height;
    static int width;
    static int maxCount = 0;
    static List<Character> visited = new ArrayList<>();
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();

        map = new char[height][width];
        for (int i = 0; i < height; i++) {
            map[i] = sc.next().toCharArray();
        }

        backTracking(1, 0, 0);
        System.out.println(maxCount);
    }

    static void backTracking(int curCount, int curX, int curY) {
        if (curX < 0 || curX >= width || curY < 0 || curY >= height) {
            return;
        }

        if (visited.contains(map[curY][curX])) {
            return;
        }

        visited.add(map[curY][curX]);
        maxCount = Math.max(maxCount, curCount);

        for (int i = 0; i < 4; i++) {
            backTracking(curCount + 1, curX + moveX[i], curY + moveY[i]);
        }
        visited.remove(visited.size() - 1);
    }
}
