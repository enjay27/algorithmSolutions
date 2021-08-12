package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution6808 {

    static int win;
    static int lose;
    static List<Integer> kCards;
    static List<Integer> iCards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {

            kCards = new ArrayList<>();
            iCards = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                kCards.add(sc.nextInt());
            }

            for (int i = 1; i <= 18; i++) {
                if (kCards.contains(i)) continue;
                iCards.add(i);
            }


            win = 0;
            lose = 0;
            permutation(new ArrayList<>());

            System.out.printf("#%d %d %d\n", tc, win, lose);
        }

    }

    static void permutation(List<Integer> nums) {
        if (nums.size() == 9) {
            int score = 0;
            for (int i = 0; i < 9; i++) {
                if (kCards.get(i) > iCards.get(nums.get(i))) {
                    score += kCards.get(i) + iCards.get(nums.get(i));
                } else {
                    score -= kCards.get(i) + iCards.get(nums.get(i));
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
            if (nums.contains(i)) continue;

            nums.add(i);
            permutation(nums);
            nums.remove(nums.size() - 1);
        }
    }

}
