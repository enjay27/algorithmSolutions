package baekjoon;

import java.util.Scanner;

public class Solution3040 {

    static int[] dwarfs;
    static int[] selected;
    static boolean isEnd = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dwarfs = new int[9];
        selected = new int[7];
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = sc.nextInt();
        }

        combination(selected, 0, 0, 0);
    }

    static void combination(int[] selected, int curNumber, int index, int select) {
        if (isEnd) {
            return;
        }

        if (curNumber > 100)
            return;

        if (index - select > 2) {
            return;
        }

        if (select == 7) {
            if (curNumber == 100) {
                for (int i : selected) {
                    System.out.println(i);
                }
                isEnd = true;
            }
            return;
        }

        if (index == 9) {
            return;
        }

        combination(selected, curNumber, index + 1, select);
        selected[select] = dwarfs[index];
        combination(selected, curNumber + selected[select], index + 1, select + 1);
    }
}
