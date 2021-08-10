package baekjoon;

import java.util.Scanner;

public class Solution2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[][] paper = new int[100][100];
        for (int i = 0; i < number; i++) {
            int left = sc.nextInt();
            int down = sc.nextInt();
            for (int k = 90 - down; k < 100 - down; k++) {
                for (int j = left; j < left + 10; j++) {
                    paper[k][j] = 1;
                }
            }
        }

        int curArea = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == 1) curArea++;
            }
        }

        System.out.println(curArea);
    }
}
