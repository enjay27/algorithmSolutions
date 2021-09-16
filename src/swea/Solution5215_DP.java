package swea;

import java.util.Scanner;

public class Solution5215_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            int number = sc.nextInt();
            int limit = sc.nextInt();

            int[] scores = new int[number + 1];
            int[] calories = new int[number + 1];
            for (int i = 1; i <= number; i++) {
                scores[i] = sc.nextInt();
                calories[i] = sc.nextInt();
            }

            int[][] memo = new int[number + 1][limit + 1];

            for (int i = 1; i <= number; i++) {
                for (int j = 1; j <= limit; j++) {
                    if (calories[i] <= j) {
                        int a = memo[i - 1][j];
                        int b = scores[i] + memo[i - 1][j - calories[i]];
                        memo[i][j] = Math.max(a, b);
                    } else {
                        memo[i][j] = memo[i - 1][j];
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, memo[number][limit]);
        }

    }
}
