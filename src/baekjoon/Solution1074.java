package baekjoon;

import java.util.Scanner;

public class Solution1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int y = sc.nextInt();
        int x = sc.nextInt();

        char[] binaryY = Integer.toBinaryString(y).toCharArray();
        char[] binaryX = Integer.toBinaryString(x).toCharArray();

        int numY = 0;
        for (int i = binaryY.length - 1; i >= 0; i--) {
            char c = binaryY[binaryY.length - i - 1];
            if (c == '1') {
                numY += 2 * Math.pow(4, i);
            }
        }

        int numX = 0;
        for (int i = binaryX.length - 1; i >= 0; i--) {
            char c = binaryX[binaryX.length - i - 1];
            if (c == '1') {
                numX += Math.pow(4, i);
            }
        }

        System.out.println(numX + numY);
    }
}
