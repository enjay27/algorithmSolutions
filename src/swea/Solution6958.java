package swea;

import java.util.Scanner;

public class Solution6958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int test_case = 1; test_case <= test; test_case++) {
            int people = sc.nextInt();
            int questions = sc.nextInt();

            int max = 0;
            int peopleCount = 0;
            for (int i = 0; i < people; i++) {
                int cur = 0;
                for (int j = 0; j < questions; j++) {
                    if (sc.nextInt() == 1) {
                        cur++;
                    }
                }
                if (cur > max) {
                    max = cur;
                    peopleCount = 1;
                } else if (cur == max) {
                    peopleCount++;
                }
            }

            System.out.printf("#%d %d %d\n", test_case, peopleCount, max);
        }
    }
}
