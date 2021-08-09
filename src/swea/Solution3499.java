package swea;

import java.util.Scanner;

public class Solution3499 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int test_case = 1; test_case <= test; test_case++) {
            int number = sc.nextInt();

            int rows = number / 2 + number % 2;
            String[][] strings = new String[rows][2];

            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < rows; i++) {
                    if (i * 2 + j < number) {
                        strings[i][j] = sc.next();
                    }
                }
            }

            System.out.print("#" + test_case);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < 2; j++) {
                    if (strings[i][j] != null) {
                        System.out.print(" " + strings[i][j]);
                    }
                }
            }
            System.out.println();
        }
    }
}
