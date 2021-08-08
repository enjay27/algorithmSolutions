package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution15649 {

    static int size;
    static int pick;
    static List<List<Integer>> permutations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        pick = sc.nextInt();
        List<Integer> nums = new ArrayList<>();

        permutation(nums, 1);
        for (List<Integer> permutation : permutations) {
            for (int num : permutation) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static List<Integer> permutation(List<Integer> nums, int index) {

        if (nums.size() == pick) {
            permutations.add(new ArrayList<>(nums));
            return nums;
        }

        for (int i = 1; i <= size; i++) {
            if (nums.contains(i)) {
                continue;
            }
            nums.add(i);
            permutation(nums, index + 1);
            nums.remove(nums.size() - 1);
        }

        return nums;
    }
}
