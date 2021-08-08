package baekjoon;

import java.util.Scanner;

public class Solution1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            int type = sc.nextInt();
            int index = sc.nextInt();

            switch (type) {
                case 1:
                    int curIndex = index - 1;
                    while (curIndex < size) {
                        if (arr[curIndex] == 1) {
                            arr[curIndex] = 0;
                        } else {
                            arr[curIndex] = 1;
                        }
                        curIndex += index;
                    }
                    break;
                case 2:
                    int range = 0;
                    curIndex = index - 1;
                    while (curIndex - range >= 0 && curIndex + range < size) {
                        if (arr[curIndex + range] == arr[curIndex - range]) {
                            if (arr[curIndex + range] == 1) {
                                arr[curIndex + range] = 0;
                                arr[curIndex - range] = 0;
                            } else {
                                arr[curIndex + range] = 1;
                                arr[curIndex - range] = 1;
                            }
                        } else {
                            break;
                        }
                        range++;
                    }
                    break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1)
                System.out.print(" ");
            if (i % 20 == 19) System.out.println();
        }
    }
}
