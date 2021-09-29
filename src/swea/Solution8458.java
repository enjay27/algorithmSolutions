package swea;

import java.awt.*;
import java.util.Scanner;

public class Solution8458 {
    static boolean canComplete = true;
    static long prev = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int size = sc.nextInt();
            long[] points = new long[size];
            int count = 0;
            for (int i = 0; i < size; i++) {
                long x = sc.nextInt();
                long y = sc.nextInt();
                points[i] = Math.abs(x) + Math.abs(y);
                if (points[i] > 450015000) {
                    count = 30000;
                }
            }

            if (canFinished(points)) {

                if (count == 30000) {
                    for (int i = 0; i < points.length; i++) {
                        points[i] -= 450015000;
                        if (points[i] < 0) points[i] %= 2;
                    }
                }

                while (!isFinished(points)) {
                    count++;
                    move(points, count);
                }

                System.out.printf("#%d %d\n", tc, count);
            } else {
                System.out.printf("#%d -1\n", tc);
            }
        }
    }

    static boolean canFinished(long[] points) {
        long l = points[0] % 2;
        boolean canFinished = true;
        for (long point : points) {
            canFinished = canFinished && (l == point % 2);
        }
        return canFinished;
    }

    static boolean isFinished(long[] points) {
        for (long point : points) {
            if (point != 0) {
                return false;
            }
        }
        return true;
    }


    static void move(long[] points, int count) {
        for (int i = 0; i < points.length; i++) {
            points[i] -= count;
            if (points[i] < 0) {
                points[i] %= 2;
            }
        }
    }
}
