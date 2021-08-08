package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution2493 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] towers = new int[number];

        for (int i = 0; i < number; i++) {
            towers[i] = sc.nextInt();
        }

        int[] receivers = new int[number];
        Stack<Integer> stack = new Stack<>();

        for (int i = towers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (towers[stack.peek()] < towers[i]) {
                    receivers[stack.pop()] = i + 1;
                } else {
                    break;
                }
            }
            stack.add(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int receiver : receivers) {
            bw.write(receiver + " ");
        }

        bw.flush();
    }
}
