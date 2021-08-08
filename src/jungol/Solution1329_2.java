package jungol;

import java.util.Scanner;

public class Solution1329_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();

        if (height % 2 == 0 || height > 100) {
            System.out.println("INPUT ERROR!");
            return;
        }
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j < height; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
