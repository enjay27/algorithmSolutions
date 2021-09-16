package baekjoon;

import java.util.Scanner;

public class Solution16637 {

    static int length;
    static char[] inputs;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();

        inputs = sc.next().toCharArray();

        System.out.println(inputs);

        tracking(2, inputs[0] - 48);
        System.out.println(max);
    }

    static void tracking(int curIndex, int curResult) {
        if (curIndex >= length) {
            max = Math.max(curResult, max);
            return;
        }

        char operator = inputs[curIndex - 1];
        int operated = operate(curResult, inputs[curIndex] - 48, operator);
        tracking(curIndex + 2, operated);

        if (curIndex >= length - 2) {
            return;
        }
        int addBracket = operate(inputs[curIndex] - 48, inputs[curIndex + 2] - 48, inputs[curIndex + 1]);
        int bracketOperated = operate(curResult, addBracket, operator);
        tracking(curIndex + 4, bracketOperated);
    }

    static int operate(int a, int b, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
        }
        return result;
    }
}
