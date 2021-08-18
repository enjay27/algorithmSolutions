package baekjoon;

import java.util.Scanner;

public class Solution2839 {
    static int count = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sugar = sc.nextInt();

        int add = 0;
        if (sugar > 15) {
            add = sugar / 15 - 1;
            sugar = sugar % 15 + 15;
        }
        recursive(sugar, 0);

        if (count == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(add * 3 + count);
        }
    }

    static void recursive(int curSugar, int curCount) {
        if (curSugar == 0) {
            count = Math.min(count, curCount);
            return;
        } else if (curSugar < 0) {
            return;
        }

        recursive(curSugar - 3, curCount + 1);
        recursive(curSugar - 5, curCount + 1);
    }
}
