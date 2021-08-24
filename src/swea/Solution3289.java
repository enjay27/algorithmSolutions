package swea;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution3289 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= test; tc++) {
            int numbers = sc.nextInt();
            int operateCount = sc.nextInt();

            make(numbers);

            bw.write("#" + tc + " ");
            for (int i = 0; i < operateCount; i++) {
                int type = sc.nextInt();
                int first = sc.nextInt();
                int second = sc.nextInt();

                if (type == 0) {
                    union(first, second);

                } else if (type == 1) {
                    int result = search(first, second);
                    bw.write(String.valueOf(result));
                }
            }
            bw.newLine();
            bw.flush();
        }
    }

    private static void make(int numbers) {
        parents = new int[numbers + 1];
        for (int i = 1; i <= numbers; i++) {
            parents[i] = i;
        }
    }

    private static int search(int first, int second) {
        first = findRoot(first);

        second = findRoot(second);

        if (first == second) return 1;
        else return 0;
    }

    private static void union(int first, int second) {
        first = findRoot(first);

        second = findRoot(second);

        parents[first] = parents[second];
    }

    static int findRoot(int index) {
        if (index == parents[index]) {
            return index;
        }

        int root = findRoot(parents[index]);
        parents[index] = root;

        return root;
    }

}
