package jungol;

import java.util.Scanner;

public class Solution1681 {
    static int size;
    static int[][] map;
    static int minDistance = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        map = new int[size][size];
        visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        tracking(0, 0, 0);
        System.out.println(minDistance);
    }

    static void tracking(int number, int prevIndex, int curDistance) {
        if (number == size - 1) {
            if (map[prevIndex][0] == 0) return;
            curDistance += map[prevIndex][0];
            minDistance = Math.min(minDistance, curDistance);
            return;
        }

        if (curDistance >= minDistance) {
            return;
        }

        for (int i = 1; i < size; i++) {
            if (visited[i]) continue;
            if (map[prevIndex][i] == 0) continue;
            visited[i] = true;
            tracking(number + 1, i, curDistance + map[prevIndex][i]);
            visited[i] = false;
        }
    }
}
