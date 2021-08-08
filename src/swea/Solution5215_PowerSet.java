package swea;

import java.util.*;

public class Solution5215_PowerSet {

    static int[] scores;
    static int[] calories;
    static Stack<Integer> stack;
    static int number;
    static int limit;
    static List<Stack<Integer>> select;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int test_case = 1; test_case <= test; test_case++) {
            stack = new Stack<>();
            select = new ArrayList<>();
            number = sc.nextInt();
            limit = sc.nextInt();

            scores = new int[number];
            calories = new int[number];
            for (int i = 0; i < number; i++) {
                scores[i] = sc.nextInt();
                calories[i] = sc.nextInt();
            }

            recursive(0);

            int maxScore = 0;
            for (int i = 0, selectSize = select.size(); i < selectSize; i++) {
                Stack<Integer> indexes = select.get(i);
                int calorie = 0;
                int score = 0;
                for (Integer index : indexes) {
                    calorie += calories[index];
                    score += scores[index];
                }
                if (calorie <= limit) {
                    if (maxScore < score) {
                        maxScore = score;
                    }
                }
            }
            System.out.println("#" + test_case + " " + maxScore);
        }
    }

    static void recursive(int index) {

        if (index > number) {
            return;
        }

        if (select.contains(stack)) {
            return;
        } else {
            if (!stack.isEmpty()) {
                Stack<Integer> objects = new Stack<>();
                objects.addAll(stack);
                select.add(objects);
            }
        }


        for (int i = index; i < number; i++) {
            stack.push(i);
            recursive(i + 1);
            stack.pop();
        }
    }
}
