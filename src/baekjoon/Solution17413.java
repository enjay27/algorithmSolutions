package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Solution17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String s = sc.nextLine() + " ";

        final char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean isBracket = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '>' || chars[i] == '<' || i == chars.length - 1 || chars[i] == ' ') {
                if (!isBracket) {
                    for (int j = i - stack.size(); j < i; j++) {
                        chars[j] = stack.pop();
                    }
                }
                if (chars[i] == '<') {
                    isBracket = true;
                } else if (chars[i] == '>') {
                    isBracket = false;
                }
            } else {
                if (!isBracket)
                    stack.push(chars[i]);
            }

        }

        System.out.println(String.valueOf(chars));


    }
}
