package baekjoon;

import java.util.*;

public class Solution14501 {
    static int remainDay;
    static int[] requireDays;
    static int[] benefits;
    static int[] memoization;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        remainDay = sc.nextInt();
        requireDays = new int[remainDay];
        benefits = new int[remainDay];

        for (int i = 0; i < remainDay; i++) {
            requireDays[i] = sc.nextInt();
            benefits[i] = sc.nextInt();
        }

        memoization = new int[remainDay + 1];
        for (int i = remainDay - 1; i >= 0; i--) {
            if (requireDays[i] + i > remainDay) {
                memoization[i] = memoization[i + 1];
                continue;
            }

            int differ = memoization[i + 1] - memoization[i + requireDays[i]];
            if (differ < benefits[i]) {
                memoization[i] += memoization[i + 1] + benefits[i] - differ;
            } else {
                memoization[i] = memoization[i + 1];
            }
        }

        System.out.println(memoization[0]);
        System.out.println(Arrays.toString(memoization));
    }
}
