package jungol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        List<Integer[]> refrigerators = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            int min = sc.nextInt();
            int max = sc.nextInt();
            boolean isNeededToAdd = true;
            for (Integer[] refrigerator : refrigerators) {
                int savedMin = refrigerator[0];
                int savedMax = refrigerator[1];
                if (Math.min(savedMax, max) > Math.max(savedMin, min)) {
                    refrigerator[0] = Math.max(savedMin, min);
                    refrigerator[1] = Math.min(savedMax, max);
                    isNeededToAdd = false;
                    break;
                }
            }
            if (isNeededToAdd) {
                refrigerators.add(new Integer[]{min, max});
            }
        }

        System.out.println(refrigerators.size());
    }
}
