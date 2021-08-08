package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution2999 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        List<Integer> divisor = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(input.length()); i++) {
            if (input.length() % i == 0) {
                divisor.add(i);
            }
        }

        int colSize;
        if (divisor.isEmpty()) {
            colSize = input.length();
        } else {
            colSize = divisor.stream().reduce(0, (a, b) -> a < b ? b : a);
        }

        int rowSize = input.length() / colSize;

        char[][] inputArr = new char[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                inputArr[i][j] = input.charAt(i * colSize + j);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                bw.write(inputArr[j][i]);
            }
        }
        bw.flush();
    }
}
