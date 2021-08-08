package swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int size = sc.nextInt();
            Stack<Character> stack = new Stack<>();

            char[] chars = new char[size];
            chars = sc.next().toCharArray();

            int isValid = 1;
            for (char aChar : chars) {
                if (aChar == '(' || aChar == '[' || aChar == '{' || aChar == '<') {
                    stack.push(aChar);
                }
                if (aChar == ')' || aChar == ']' || aChar == '}' || aChar == '>') {
                    char compare = '\0';
                    switch (aChar) {
                        case ')':
                            compare = '(';
                            break;
                        case ']':
                            compare = '[';
                            break;
                        case '}':
                            compare = '{';
                            break;
                        case '>':
                            compare = '<';
                            break;
                    }
                    if (stack.pop() != compare) {
                        isValid = 0;
                        break;
                    }
                }
            }

            System.out.println("#" + test_case + " " + isValid);

        }
    }
}
