package recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PowerSet {

    static int size;
    static int pick;
    static int[] arr;
    static Boolean[] selected;
    static List<Boolean[]> check = new ArrayList<>();
    static boolean canAdd = false;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        pick = sc.nextInt();
        arr = new int[size];
        selected = new Boolean[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        List<Integer> nums = new ArrayList<>();

        powerSet(nums, 0);

        bw.flush();
    }

    static void powerSet(List<Integer> nums, int index) throws IOException {

        if (canAdd) {
            if (!check.contains(selected)) {
                for (int num : nums) {
                    bw.write(num + " ");
                }
                bw.newLine();
                canAdd = false;
            }
            return;
        }


        for (int i = 0; i < size; i++) {
            if (!nums.isEmpty()) {
                if (nums.get(nums.size() - 1) > arr[i]) continue;
            }
            selected[i] = true;
            nums.add(arr[i]);
            canAdd = true;
            powerSet(nums, i + 1);
            selected[i] = false;
            nums.remove(nums.size() - 1);
        }

    }
}
