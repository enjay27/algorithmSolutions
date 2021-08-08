package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution15651 {
    static int size;
    static int pick;
    static int[][] dupPermutations;
    static int curIndex = 0;
    static BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        pick = sc.nextInt();
        dupPermutations = new int[(int)Math.pow(size, pick)][pick];

        int[] nums = new int[pick];

        dupPermutation(nums, 0);
        bw.flush();
    }

    static void dupPermutation(int[] nums, int index) throws IOException {

        if (index == pick) {
            for (int num : nums) {
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= size; i++) {
            nums[index] = i;
            dupPermutation(nums, ++index);

            index--;
        }
    }
}
