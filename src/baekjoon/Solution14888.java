package baekjoon;

import java.util.Scanner;

public class Solution14888 {
    static int[] nums;
    static int[] operators = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberCount = sc.nextInt();
        nums = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }
        tracking(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void tracking(int index, int curValue) {
        if (index == nums.length) {
            min = Math.min(curValue, min);
            max = Math.max(curValue, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) continue;
            operators[i]--;
            int nextValue = operate(curValue, nums[index], i);
            tracking(index + 1, nextValue);
            operators[i]++;
        }

    }

    static int operate(int prevValue, int value, int operator) {
        switch (operator) {
            case 0:
                return prevValue + value;
            case 1:
                return prevValue - value;
            case 2:
                return prevValue * value;
            case 3:
                return prevValue / value;
        }
        return -1;
    }
}
