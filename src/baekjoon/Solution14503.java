package baekjoon;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution14503 {
    static int height;
    static int width;
    static int[][] area;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        area = new int[height][width];
        visited = new boolean[height][width];

        Point point = new Point();
        point.y = sc.nextInt();
        point.x = sc.nextInt();
        int direction = sc.nextInt();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(0, 2);
        map.put(2, 0);
        map.put(3, 1);

        boolean isRun = true;
        while (isRun) {
            if (!visited[point.y][point.x])
                count++;
            visited[point.y][point.x] = true;
            for (int i = 1; i <= 4; i++) {
                isRun = detecting(point.x, point.y, direction - i);
                if (isRun) {
                    direction -= i;
                    if (direction < 0) direction += 4;
                    break;
                }
            }
            if (isRun) {
                point.x += moveX[direction];
                point.y += moveY[direction];
            }
            if (!isRun && area[point.y + moveY[map.get(direction)]][point.x + moveX[map.get(direction)]] == 0) {
                point.y += moveY[map.get(direction)];
                point.x += moveX[map.get(direction)];
                isRun = true;
            }
        }

        System.out.println(count);

    }

    static boolean detecting(int curX, int curY, int curDirection) {
        if (curDirection < 0) curDirection += 4;
        curX += moveX[curDirection];
        curY += moveY[curDirection];

        if (curX < 0 || curY < 0 || curX >= width || curY >= height) return false;

        if (visited[curY][curX]) return false;

        return area[curY][curX] != 1;
    }
}
