package swea;

import java.util.Scanner;

public class Solution9229 {

    static int[] snacks;
    static int number;
    static int limit;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int test_case = 1; test_case <= test; test_case++) {
            number = sc.nextInt();
            limit = sc.nextInt();
            max = -1;
            snacks = new int[number];
            for (int i = 0; i < number; i++) {
                snacks[i] = sc.nextInt();
            }
            recursive(0, 0, 0);
            System.out.printf("#%d %d\n", test_case, max);
        }
    }

    public static void recursive(int index, int select, int curSnack) {
        if (select == 2) {
            if (max < curSnack && limit >= curSnack) {
                max = curSnack;
            }
            return;
        }
        if (index == number) {
            return;
        }
        if (curSnack > limit) {
            return;
        }

        recursive(index + 1, select + 1, curSnack + snacks[index]);
        recursive(index + 1, select, curSnack);
    }
}
