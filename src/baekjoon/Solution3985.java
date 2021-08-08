package baekjoon;

import java.util.Scanner;

public class Solution3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int number = sc.nextInt();

        int[] cake = new int[size + 1];
        int[] accurateCake = new int[number + 1];
        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i <= number; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int range = to - from;
            if (max < range) {
                maxIndex = i;
                max = range;
            }
            for (int j = from; j <= to; j++) {
                if (cake[j] == 0) {
                    cake[j]++;
                    accurateCake[i]++;
                }
            }
        }

        int accMax = 0;
        int accMaxIndex = 0;
        for (int i = 1; i <= number; i++) {
            if (accMax < accurateCake[i]) {
                accMax = accurateCake[i];
                accMaxIndex = i;
            }
        }

        System.out.println(maxIndex);
        System.out.println(accMaxIndex);
    }
}
