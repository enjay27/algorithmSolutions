package swea;

import java.util.Scanner;

public class Solution4013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {

            int[][] magnets = new int[4][8];
            int[] top = {0, 0, 0, 0};

            int commandNumber = sc.nextInt();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    magnets[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < commandNumber; i++) {
                int magnet = sc.nextInt() - 1;
                int rotate = -sc.nextInt();
                int rightMagnet = magnet + 1;
                int rightRotate = -rotate;
                int rightIndex = (top[magnet] + 2) % 8;
                while (rightMagnet < 4) {
                    int index = (top[rightMagnet] + 6) % 8;
                    if (magnets[rightMagnet][index] == magnets[rightMagnet - 1][rightIndex]) break;
                    rightIndex = (top[rightMagnet] + 2) % 8;
                    top[rightMagnet] = (top[rightMagnet] + rightRotate) % 8;
                    if (top[rightMagnet] < 0) {
                        top[rightMagnet] += 8;
                    }
                    rightRotate = -rightRotate;
                    rightMagnet++;
                }
                int leftMagnet = magnet - 1;
                int leftRotate = -rotate;
                int leftIndex = (top[magnet] + 6) % 8;
                while (leftMagnet >= 0) {
                    int index = (top[leftMagnet] + 2) % 8;
                    if (magnets[leftMagnet][index] == magnets[leftMagnet + 1][leftIndex]) break;
                    leftIndex = (top[leftMagnet] + 6) % 8;
                    top[leftMagnet] = (top[leftMagnet] + leftRotate) % 8;
                    if (top[leftMagnet] < 0) {
                        top[leftMagnet] += 8;
                    }
                    leftRotate = -leftRotate;
                    leftMagnet--;
                }
                top[magnet] = (top[magnet] + rotate) % 8;
                if (top[magnet] < 0) {
                    top[magnet] += 8;
                }
            }

            int score = 0;
            for (int i = 0; i < 4; i++) {
                if (magnets[i][top[i]] == 1) {
                    score += Math.pow(2, i);
                }
            }
            System.out.printf("#%d %d\n", tc, score);
        }
    }
}
