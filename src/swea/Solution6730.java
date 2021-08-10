package swea;

import java.util.Scanner;

public class Solution6730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int test_case = 1; test_case <= test; test_case++) {
            int number = sc.nextInt();
            int prev = sc.nextInt();
            int cur;
            int up = 0;
            int down = 0;
            for (int i = 0; i < number - 1; i++) {
                cur = sc.nextInt();
                if (cur < prev) {
                    down = Math.max(down, prev - cur);
                } else if (cur > prev) {
                    up = Math.max(up, cur - prev);
                }
                prev = cur;
            }

            System.out.printf("#%d %d %d\n", test_case, up, down);

        }
    }
}
