package jungol;

import java.util.Scanner;

public class Solution1719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int type = sc.nextInt();

        if (height % 2 == 0 || height > 100) {
            System.out.println("INPUT ERROR!");
            return;
        }

        switch (type) {
            case 1:
                for (int i = 1; i <= height; i++) {
                    if (i < (height / 2) + 1) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                    } else {
                        for (int j = 0; j < height - i + 1; j++) {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = 1; i <= height; i++) {
                    if (i < (height / 2) + 1) {
                        for (int j = i; j <= height / 2; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i; j++) {
                            System.out.print(i);
                        }
                    } else {
                        for (int j = 0; j <= i - height / 2 - 2; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < height - i + 1; j++) {
                            System.out.print(i);
                        }
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i = 1; i <= height; i++) {
                    if (i < (height / 2) + 1) {
                        for (int j = 1; j < i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < height + 2 - i * 2; j++) {
                            System.out.print("*");
                        }
                    } else {
                        for (int j = 0; j < height - i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = i; j < i * 3 - height; j++) {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                break;
            case 4:
                for (int i = 1; i <= height; i++) {
                    if (i < (height / 2) + 1) {
                        for (int j = 1; j < i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < height - 1 - i; j++) {
                            System.out.print("*");
                        }
                    } else {
                        for (int j = 0; j < height / 2; j++) {
                            System.out.print(" ");
                        }
                        for (int j = i; j < i * 2 - height / 2; j++) {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("INPUT ERROR!");
                break;
        }
    }
}
