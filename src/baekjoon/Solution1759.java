package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1759 {

    static char[] passwords;
    static int length;
    static int total;
    static char[] selected;
    static BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        length = sc.nextInt();
        total = sc.nextInt();

        passwords = new char[total];
        selected = new char[length];

        for (int i = 0; i < total; i++) {
            passwords[i] = sc.next().charAt(0);
        }

        Arrays.sort(passwords);
        permutation(0, 0);
        bw.flush();
    }

    static void permutation(int index, int select) throws IOException {
        if (select == length) {
            int consonantCount = 0;
            int vowelCount = 0;
            for (char c : selected) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowelCount++;
                else consonantCount++;
            }
            if (consonantCount < 2 || vowelCount < 1) return;
            bw.write(selected);
            bw.newLine();
            return;
        }

        if (index - select > total - length) {
            return;
        }

        if (index == total) return;

        selected[select] = passwords[index];
        permutation(index + 1, select + 1);
        permutation(index + 1, select);


    }
}
