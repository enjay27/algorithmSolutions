package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution2839_greedy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sugar = sc.nextInt();

        int count = 0;
        while (sugar % 5 != 0) {
            sugar -= 3;
            count++;
            if (sugar < 0) {
                count = -1;
                break;
            }
        }
        count += sugar / 5;

        System.out.println(count);
    }
}
