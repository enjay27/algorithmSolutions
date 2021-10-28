package swea;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution6109 {
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveX = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> moveMap = new HashMap<>();
        moveMap.put("up", 0);
        moveMap.put("right", 1);
        moveMap.put("down", 2);
        moveMap.put("left", 3);

        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int size = sc.nextInt();
            int move = moveMap.get(sc.next().trim());

            int[][] map = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            boolean[][] isNewTile = new boolean[size][size];
            switch (move) {
                case 0:
                    for (int i = 1; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            if (map[i][j] == 0) continue;
                            for (int k = i; k > 0; k--) {
                                if (map[k + moveY[move]][j] == 0) {
                                    map[k + moveY[move]][j] = map[k][j];
                                    map[k][j] = 0;
                                } else {
                                    if (isNewTile[k + moveY[move]][j]) break;
                                    if (map[k][j] == map[k + moveY[move]][j]) {
                                        map[k + moveY[move]][j] *= 2;
                                        isNewTile[k + moveY[move]][j] = true;
                                        map[k][j] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 1:
                    for (int j = size - 2; j >= 0; j--) {
                        for (int i = 0; i < size; i++) {
                            if (map[i][j] == 0) continue;
                            for (int k = j; k < size - 1; k++) {
                                if (map[i][k + moveX[move]] == 0) {
                                    map[i][k + moveX[move]] = map[i][k];
                                    map[i][k] = 0;
                                } else {
                                    if (isNewTile[i][k + moveX[move]]) break;
                                    if (map[i][k] == map[i][k + moveX[move]]) {
                                        map[i][k + moveX[move]] *= 2;
                                        isNewTile[i][k + moveX[move]] = true;
                                        map[i][k] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    for (int i = size - 2; i >= 0; i--) {
                        for (int j = 0; j < size; j++) {
                            if (map[i][j] == 0) continue;
                            for (int k = i; k < size - 1; k++) {
                                if (map[k + moveY[move]][j] == 0) {
                                    map[k + moveY[move]][j] = map[k][j];
                                    map[k][j] = 0;
                                } else {
                                    if (isNewTile[k + moveY[move]][j]) break;
                                    if (map[k][j] == map[k + moveY[move]][j]) {
                                        map[k + moveY[move]][j] *= 2;
                                        isNewTile[k + moveY[move]][j] = true;
                                        map[k][j] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    for (int j = 1; j < size; j++) {
                        for (int i = 0; i < size; i++) {
                            if (map[i][j] == 0) continue;
                            for (int k = j; k > 0; k--) {
                                if (map[i][k + moveX[move]] == 0) {
                                    map[i][k + moveX[move]] = map[i][k];
                                    map[i][k] = 0;
                                } else {
                                    if (isNewTile[i][k + moveX[move]]) break;
                                    if (map[i][k] == map[i][k + moveX[move]]) {
                                        map[i][k + moveX[move]] *= 2;
                                        isNewTile[i][k + moveX[move]] = true;
                                        map[i][k] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
            }

            System.out.println("#" + tc);
            print(map);

        }
    }

    static void print(int[][] map) {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
