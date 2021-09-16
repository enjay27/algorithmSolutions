package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2839_dp {
    static int[] stored;
    static int weight;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        weight = sc.nextInt();
        int size = Math.max(weight + 1, 6);
        stored = new int[size];
        Arrays.fill(stored, 5000);

        stored[3] = 1;
        stored[5] = 1;
        store(weight);
        int result = stored[weight] >= 5000 ? -1 : stored[weight];
        System.out.println(result);
    }

    static int store(int w) {
        if (w < 0) {
            return 5000;
        }

        if (stored[w] >= 5000) {
            int store3 = store(w - 3) + 1;
            int store5 = store(w - 5) + 1;
            stored[w] = Math.min(Math.min(store5, store3), stored[w]);
        }

        return stored[w];
    }

}
