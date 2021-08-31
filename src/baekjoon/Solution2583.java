package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution2583 {
    static boolean[][] visited;
    static int area = 0;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static int height;
    static int width;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        int numberOfRectangles = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        visited = new boolean[height][width];

        for (int i = 0; i < numberOfRectangles; i++) {
            int left = sc.nextInt();
            int bottom = sc.nextInt();
            int right = sc.nextInt();
            int top = sc.nextInt();
            for (int j = bottom; j < top; j++) {
                for (int k = left; k < right; k++) {
                    visited[j][k] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j]) {
                    area = 0;
                    count++;
                    tracking(j, i);
                    queue.offer(area);
                }
            }
        }

        System.out.println(count);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    static void tracking(int curX, int curY) {
        if (curX < 0 || curX >= width || curY < 0 || curY >= height) return;

        if (visited[curY][curX]) return;

        visited[curY][curX] = true;
        area++;

        for (int i = 0; i < 4; i++) {
            tracking(curX + moveX[i], curY + moveY[i]);
        }
    }
}
