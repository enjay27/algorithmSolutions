package swea;

import java.awt.*;
import java.util.*;

public class Solution1953 {
    static int width;
    static int height;
    static Point point = new Point();
    static int time;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            height = sc.nextInt();
            width = sc.nextInt();
            point.y = sc.nextInt();
            point.x = sc.nextInt();
            time = sc.nextInt();
            map = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            Queue<Point> queue = new LinkedList<>();
            queue.offer(point);
            Stack<Point> stack = new Stack<>();
            for (int count = 0; count < time; count++) {
                queue.addAll(stack);
                stack.clear();
                while (!queue.isEmpty()) {
                    Point poll = queue.poll();
                    int type = map[poll.y][poll.x];
                    if (type == 9) continue;
                    map[poll.y][poll.x] = 9;
                    for (int i = 0; i < 4; i++) {
                        if (isConnected(type, i)) continue;
                        int nextX = poll.x + moveX[i];
                        int nextY = poll.y + moveY[i];
                        if (nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) continue;
                        if (map[nextY][nextX] == 9 || map[nextY][nextX] == 0) continue;
                        int nextType = map[nextY][nextX];
                        if (isConnected(nextType, i + 2)) continue;
                        stack.push(new Point(nextX, nextY));
                    }
                }
            }

            int count = 0;
            for (int[] ints : map) {
                for (int anInt : ints) {
                    if (anInt == 9) count++;
                }
            }
            System.out.printf("#%d %d\n", tc, count);
        }
    }

    static void print() {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static boolean isConnected(int type, int direction) {
        direction %= 4;
        switch (type) {
            case 2:
                if (direction == 1 || direction == 3) return true;
                break;
            case 3:
                if (direction == 0 || direction == 2) return true;
                break;
            case 4:
                if (direction == 2 || direction == 3) return true;
                break;
            case 5:
                if (direction == 0 || direction == 3) return true;
                break;
            case 6:
                if (direction == 0 || direction == 1) return true;
                break;
            case 7:
                if (direction == 1 || direction == 2) return true;
                break;
        }
        return false;
    }
}
