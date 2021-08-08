package swea;

import java.util.*;

public class Solution5215_Combination {
    static int number;
    static int limit;
    static int maxScore;
    static Stack<Integer> stack;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int test_case = 1; test_case <= test; test_case++) {
            number = sc.nextInt();
            limit = sc.nextInt();
            stack = new Stack<>();

            Burger[] burgers = new Burger[number];
            for (int i = 0; i < number; i++) {
                burgers[i] = new Burger();
                burgers[i].score = sc.nextInt();
                burgers[i].calorie = sc.nextInt();
                burgers[i].efficiency = (double)burgers[i].score / burgers[i].calorie;
            }

            maxScore = 0;

            recursive(burgers, 0, 0, 0);

            System.out.println("#" + test_case + " " + maxScore);
        }
    }

    static class Burger {
        int score;
        int calorie;
        double efficiency;
    }

    static void recursive(Burger[] burgers, int index, int curCal, int curScore) {
        if (curCal > limit) {
            return;
        } else {
            if (maxScore < curScore) {
                maxScore = curScore;
            }
        }
        for (int i = index; i < number; i++) {
            if (stack.contains(i)) continue;

            curCal += burgers[i].calorie;
            curScore += burgers[i].score;
            stack.push(i);
            recursive(burgers, i + 1, curCal, curScore);
            curCal -= burgers[i].calorie;
            curScore -= burgers[i].score;
            stack.pop();
        }

    }

}
