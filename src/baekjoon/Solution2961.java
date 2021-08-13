package baekjoon;

import java.util.Scanner;

public class Solution2961 {

    static int numbers;
    static int[][] ingredients;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        numbers = sc.nextInt();

        ingredients = new int[numbers][2];
        for (int i = 0; i < numbers; i++) {
            ingredients[i][0] = sc.nextInt();
            ingredients[i][1] = sc.nextInt();
        }

        powerSet(1, 0, 0, 0);

        System.out.println(min);

    }

    static void powerSet(int sour, int bitter, int index, int select) {
        if (select != 0) {
            int difference = Math.abs(sour - bitter);
            min = Math.min(difference, min);
        }

        if (index == numbers) {
            return;
        }

        powerSet(sour * ingredients[index][0], bitter + ingredients[index][1], index + 1, select + 1);
        powerSet(sour, bitter, index + 1, select);

    }
}
