package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int x = 0;
        int y = 0;
        int dir = 1;
        int[][] arr = new int[size][size];
        int curNum = 2;
        arr[0][0] = 1;
        while (curNum <= size * size) {

            switch (dir) {
                case 1:
                    if (x < size - 1) {
                        if (arr[y][x + 1] == 0) {
                            x++;
                        } else {
                            dir++;
                            continue;
                        }
                    } else {
                        dir++;
                        continue;
                    }
                    break;
                case 2:
                    if (y < size - 1) {
                        if (arr[y + 1][x] == 0) {
                            y++;
                        } else {
                            dir++;
                            continue;
                        }
                    } else {
                        dir++;
                        continue;
                    }
                    break;
                case 3:
                    if (x > 0) {
                        if (arr[y][x - 1] == 0) {
                            x--;
                        } else {
                            dir++;
                            continue;
                        }
                    } else {
                        dir++;
                        continue;
                    }
                    break;
                case 4:
                    if (y > 0) {
                        if (arr[y - 1][x] == 0) {
                            y--;
                        } else {
                            dir++;
                            continue;
                        }
                    } else {
                        dir++;
                        continue;
                    }
                    break;
            }
            if (dir > 4) {
                dir = 1;
                continue;
            }
            arr[y][x] = curNum;
            curNum++;
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
