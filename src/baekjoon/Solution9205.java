package baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution9205 {

    static Point[] points;
    static int storeNumber;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 0; tc < test; tc++) {
            storeNumber = sc.nextInt();
            points = new Point[storeNumber + 2];
            for (int i = 0; i < storeNumber + 2; i++) {
                points[i] = new Point();
                points[i].x = sc.nextInt();
                points[i].y = sc.nextInt();
            }

            int[] distance = new int[storeNumber + 2];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[0] = 0;
            boolean[] visited = new boolean[storeNumber + 2];
            for (int count = 0; count < storeNumber + 1; count++) {
                int minIndex = -1;
                int minDistance = Integer.MAX_VALUE;

                for (int i = 0; i < distance.length; i++) {
                    if (visited[i]) continue;
                    if (minDistance > distance[i]) {
                        minIndex = i;
                        minDistance = distance[i];
                    }
                }
                if (minIndex == -1) break;
                visited[minIndex] = true;

                for (int i = 0; i < storeNumber + 2; i++) {
                    if (visited[i]) continue;
                    int compareDistance = distance(points[minIndex], points[i]);
                    if (compareDistance > 1000) continue;
                    if (distance[i] > compareDistance) {
                        distance[i] = compareDistance;
                    }
                }
            }

            String result = distance[storeNumber + 1] == Integer.MAX_VALUE ? "sad" : "happy";
            System.out.println(result);
        }
    }

    static int distance(Point from, Point to) {
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }
}
