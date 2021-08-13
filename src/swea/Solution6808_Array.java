package swea;

import java.util.Scanner;

public class Solution6808_Array {

    static int win;
    static int lose;
    static int[] kCards;
    static int[] iCards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {

            kCards = new int[9];
            iCards = new int[9];
            for (int i = 0; i < 9; i++) {
                kCards[i] = sc.nextInt();
            }

            int index = 0;
            for (int i = 1; i <= 18; i++) {
                boolean isContains = false;
                for (int j = 0; j < 9; j++) {
                    if (kCards[j] == i) isContains = true;
                }

                if (!isContains) {
                    iCards[index] = i;
                    index++;
                }
            }

            win = 0;
            lose = 0;
            permutationV2(0, new int[9], new boolean[9]);

            System.out.printf("#%d %d %d\n", tc, win, lose);
        }
    }

    static void permutationV2(int selected, int[] sel, boolean[] added) {

        if (selected == sel.length) {
            int score = 0;
            for (int i = 0; i < sel.length; i++) {
                if (kCards[i] > sel[i]) {
                    score += kCards[i] + sel[i];
                } else {
                    score -= kCards[i] + sel[i];
                }
            }
            if (score > 0) {
                win++;
            } else if (score < 0) {
                lose++;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if(!added[i]) {
                added[i]=true;
                sel[selected]=iCards[i];
                permutationV2(selected + 1, sel, added);
                added[i]=false;
            }
        }

    }
}

