package swea;

import java.util.Scanner;

public class Solution3234 {

    static int[] weights;
    static boolean[] selected;
    static int number;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            number = sc.nextInt();
            count = 0;
            weights = new int[number];
            selected = new boolean[number];
            for (int i = 0; i < number; i++) {
                weights[i] = sc.nextInt();
            }

            backtracking(0, 0, 0);
            System.out.printf("#%d %d\n", tc, count);
        }
    }

    static void backtracking(int select, int left, int right) {

        if (right > left) return;

        if (select == number) {
            count++;
            return;
        }

        for (int i = 0; i < number; i++) {
            if (selected[i]) continue;

            selected[i] = true;
            backtracking(select + 1, left + weights[i], right);
            backtracking(select + 1, left, right + weights[i]);
            selected[i] = false;
        }
    }
}
