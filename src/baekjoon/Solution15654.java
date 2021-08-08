package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution15654 {

    static int size;
    static int pick;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        pick = sc.nextInt();
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        List<Integer> nums = new ArrayList<>();

        dupPermutation(nums, 1);

        bw.flush();
    }

    static void dupPermutation(List<Integer> nums, int index) throws IOException {

        if (nums.size() == pick) {
            for (int num : nums) {
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < size; i++) {
            if (nums.contains(arr[i])) continue;
            nums.add(arr[i]);
            dupPermutation(nums, index + 1);
            nums.remove(nums.size() - 1);
        }

    }
}
