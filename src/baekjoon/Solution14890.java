package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Solution14890 {
    static int size;
    static int length;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        length = sc.nextInt();
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += isPassableRoad(map[i]);
            sum += isPassableVerticalRoad(i);
        }
        System.out.println(sum);
    }

    static int isPassableRoad(int[] road) {
        int runway = 1;
        int prevHeight = road[0];
        for (int i = 1; i < size; i++) {
            if (Math.abs(road[i] - prevHeight) > 1) return 0;
            else {
                if (prevHeight == road[i]) {
                    runway++;
                } else {
                    if (runway < 0) return 0;
                    if (prevHeight < road[i]) {
                        if (runway < length) return 0;
                        runway = 1;
                    } else if (prevHeight > road[i]) {
                        runway = 1 - length;
                    }
                }
            }
            prevHeight = road[i];
        }
        if (runway < 0) return 0;
        return 1;
    }

    static boolean isPassableHorizontalRoad(int index) {
        int runway = 1;
        int prevHeight = map[index][0];
        for (int i = 1; i < size; i++) {
            if (Math.abs(map[index][i] - prevHeight) > 1) return false;
            else {
                if (prevHeight == map[index][i]) {
                    runway++;
                } else {
                    if (runway < 0) return false;
                    if (prevHeight < map[index][i]) {
                        if (runway < length) return false;
                        runway = 1;
                    } else if (prevHeight > map[index][i]) {
                        runway = runway - length + 1;
                    }
                }
            }
            prevHeight = map[index][i];
        }
        return true;
    }

    static int isPassableVerticalRoad(int index) {
        int runway = 1;
        int prevHeight = map[0][index];
        for (int i = 1; i < size; i++) {
            if (Math.abs(map[i][index] - prevHeight) > 1) return 0;
            else {
                if (prevHeight == map[i][index]) {
                    runway++;
                } else {
                    if (runway < 0) return 0;
                    if (prevHeight < map[i][index]) {
                        if (runway < length) return 0;
                        runway = 1;
                    } else if (prevHeight > map[i][index]) {
                        runway = 1 - length;
                    }
                }
            }
            prevHeight = map[i][index];
        }
        if (runway < 0) return 0;
        return 1;
    }
}
