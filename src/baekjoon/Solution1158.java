package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution1158 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int delete = sc.nextInt();

        int[] arr = new int[size];
        int curIndex = delete;
        arr[curIndex - 1] = 1;
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<" + curIndex);
        for (int i = 0; i < size - 1; i++) {
            int limit = delete;
            while (limit > 0) {
                curIndex++;
                if (curIndex > size) {
                    curIndex = 1;
                }
                if (arr[curIndex - 1] == 0) {
                    limit--;
                }
            }
            arr[curIndex - 1] = 1;
            bw.write(", " + curIndex);
        }
        bw.write(">");
        bw.flush();
    }
}
