package swea;

import java.util.Scanner;

public class Solution1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[] arr = new int[100];
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int[] avgArr = new int[100];
        int avg = sum / 100;
        int absSum = 0;
        for (int i = 0; i < 100; i++) {
            avgArr[i] = arr[i] - avg;
            absSum += Math.abs(avgArr[i]);
        }

        if (absSum / 2 < count) {
            if (sum % 10 != 0)
                System.out.println(1);
            else
                System.out.println(0);
        } else {

        }

    }
}
