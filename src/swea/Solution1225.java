package swea;

import java.util.Scanner;

public class Solution1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int test_case = sc.nextInt();

            int[] arr = new int[8];
            for (int j = 0; j < 8; j++) {
                arr[j] = sc.nextInt();
            }

            int curFirstIndex = 0;
            int decrement = 1;
            while (true) {
                arr[curFirstIndex] -= decrement;
                decrement++;
                if (decrement > 5) {
                    decrement = 1;
                }
                if (arr[curFirstIndex] <= 0) {
                    arr[curFirstIndex] = 0;
                    break;
                }

                curFirstIndex++;
                if (curFirstIndex >= 8) {
                    curFirstIndex = 0;
                }
            }

            System.out.print("#" + test_case);
            for (int j = 0; j < 8; j++) {
                int printIndex = curFirstIndex + j + 1;
                if (printIndex >= 8) {
                    printIndex -= 8;
                }
                System.out.print(" " + arr[printIndex]);
            }
            System.out.println();
        }
    }
}
