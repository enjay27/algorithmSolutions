package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution7236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            int size = sc.nextInt();
            char[][] map = new char[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = sc.next().charAt(0);
                }
            }

            int max = 0;
            int[] moveX = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] moveY = {-1, -1, 0, 1, 1, 1, 0, -1};
            for (int i = 1; i < size - 1; i++) {
                for (int j = 1; j < size - 1; j++) {
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        if (map[i + moveY[k]][j + moveX[k]] == 'W') count++;
                    }
                    max = Math.max(count, max);
                }
            }

            if (max == 0) max = 1;
            System.out.printf("#%d %d\n", tc, max);
        }
    }
}
