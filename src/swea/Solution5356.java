package swea;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution5356 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            char[][] input = new char[5][];
            for (int i = 0; i < 5; i++) {
                input[i] = sc.next().toCharArray();
            }

            bw.write("#" + tc + " ");
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i < input[j].length) {
                        bw.write(input[j][i]);
                    }
                }
            }
            bw.newLine();
            bw.flush();
        }
    }
}
