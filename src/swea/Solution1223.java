package swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution1223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int length = sc.nextInt();
            String next = sc.next();
            Stack<Character> numbers = new Stack<>();
            int prevResult = 1;
            int result = 0;
            for (int i = 0; i < length; i++) {
                char curChar = next.charAt(i);
                if (curChar == '+') {
                    while (!numbers.isEmpty()) {
                        prevResult *= numbers.pop() - 48;
                    }
                    result += prevResult;
                    prevResult = 1;
                } else if (curChar != '*') {
                    numbers.push(curChar);
                }
            }

            while (!numbers.isEmpty()) {
                prevResult *= numbers.pop() - 48;
            }
            result += prevResult;

            System.out.printf("#%d %d\n", tc, result);

        }
    }
}
