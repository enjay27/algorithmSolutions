package swea;

import java.util.Scanner;

public class Solution4615 {
    static int[][] map;
    static int size;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int test_case = 1; test_case <= test; test_case++) {
            size = sc.nextInt();
            count = sc.nextInt();

            map = new int[size][size];
            int mid = size / 2;
            map[mid - 1][mid - 1] = 2;
            map[mid][mid] = 2;
            map[mid][mid - 1] = 1;
            map[mid - 1][mid] = 1;

            for (int i = 0; i < count; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int type = sc.nextInt();
                map[y][x] = type;
                recursive(x + 1, y, 1, 0, type);
                recursive(x + 1, y + 1, 1, 1, type);
                recursive(x, y + 1, 0, 1, type);
                recursive(x - 1, y + 1, -1, 1, type);
                recursive(x - 1, y, -1, 0, type);
                recursive(x - 1, y - 1, -1, -1, type);
                recursive(x, y - 1, 0, -1, type);
                recursive(x + 1, y - 1, 1, -1, type);
            }
            int black = 0;
            int white = 0;
            for (int[] ints : map) {
                for (int anInt : ints) {
                    if (anInt == 1) black++;
                    else if (anInt == 2) white++;
                }
            }
            System.out.println("#" + test_case + " " + black + " " + white);
        }
    }

    public static boolean recursive(int x, int y, int incX, int incY, int type) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return false;
        }
        if (map[y][x] == 0) {
            return false;
        } else if (map[y][x] == type) {
            return true;
        }

        if (recursive(x + incX, y + incY, incX, incY, type)) {
            map[y][x] = type;
            return true;
        }
        return false;
    }
}
