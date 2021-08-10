package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1233 {
    static char[] tree;
    static int size;
    static int isPossible;
    static List<Character> operators;
    static char prev;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        operators = new ArrayList<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        for (int tc = 1; tc <= 10; tc++) {
            size = sc.nextInt();
            tree = new char[256];
            isPossible = 1;
            prev = '\0';
            sc.nextLine();
            for (int i = 0; i < size; i++) {
                String[] inputs = sc.nextLine().split(" ");
                int index = Integer.parseInt(inputs[0]);
                char input = inputs[1].charAt(0);
                tree[index] = input;

            }
            recursive(1);

            System.out.printf("#%d %d\n", tc, isPossible);
        }
    }

    static void recursive(int index) {
        if (isPossible == 0) {
            return;
        }
        if (index >= 256) {
            return;
        }
        if (tree[index] == '\u0000') {
            return;
        }
        recursive(index * 2);

        if (prev != '\0' && operators.contains(prev) == operators.contains(tree[index])) {
            isPossible = 0;
        }
        prev = tree[index];

        recursive(index * 2 + 1);
    }
}
