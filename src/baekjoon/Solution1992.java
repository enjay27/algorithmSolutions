package baekjoon;

import java.util.Scanner;

public class Solution1992 {
    static int size;
    static char[][] img;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        img = new char[size][size];
        for (int i = 0; i < size; i++) {
            String input = sc.next();
            for (int j = 0; j < size; j++) {
                img[i][j] = input.charAt(j);
            }
        }

        recursive(size, 0, 0, img[0][0]);
    }

    static void recursive(int curBuf, int curX, int curY, char curColor) {
        boolean isSame = true;

        for (int i = curY; i < curY + curBuf; i++) {
            for (int j = curX; j < curX + curBuf; j++) {
                if (curColor != img[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }

        if (isSame) {
            System.out.print(curColor);
        } else {
            System.out.print("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int nextX = curX + j * curBuf / 2;
                    int nextY = curY + i * curBuf / 2;
                    recursive(curBuf / 2, nextX, nextY, img[nextY][nextX]);
                }
            }
            System.out.print(")");
        }
    }
}
