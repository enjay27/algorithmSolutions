package swea;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution1228 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int passwordLength = sc.nextInt();
            List<Integer> passwords = new LinkedList<>();

            for (int i = 0; i < passwordLength; i++) {
                passwords.add(sc.nextInt());
            }

            int commandLength = sc.nextInt();
            for (int i = 0; i < commandLength; i++) {
                sc.next();
                int find = sc.nextInt();
                int number = sc.nextInt();
                for (int j = 0; j < number; j++) {
                    passwords.add(find + j, sc.nextInt());
                }
            }

            System.out.print("#" + test_case);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + passwords.get(i));
            }
            System.out.println();
        }
    }
}
