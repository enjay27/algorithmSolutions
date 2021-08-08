package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution15650 {
    static int size;
    static int pick;
    static List<List<Integer>> combinations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        pick = sc.nextInt();
        List<Integer> nums = new ArrayList<>();

        combination(nums, 1);
        for (List<Integer> combination : combinations) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static List<Integer> combination(List<Integer> nums, int index) {

        if (nums.size() == pick) {
            combinations.add(new ArrayList<>(nums));
            return null;
        }

        for (int i = index; i <= size; i++) {
            if (nums.contains(i)) {
                continue;
            }
            nums.add(i);
            combination(nums, i + 1);
            nums.remove(nums.size() - 1);
        }

        return nums;
    }
}
