package swea;

import java.util.*;

public class Solution1861_graph {
    static Map<Integer, List<Integer>> graph;
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {1, -1, 0, 0};
    static int max;
    static int size;
    static int[][] map;
    static int start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int test_case = 1; test_case <= test; test_case++) {
            //nanoTime
            long startTime = System.nanoTime();

            size = sc.nextInt();
            map = new int[size][size];
            graph = new HashMap<>();
            max = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    graph.put(map[i][j], new ArrayList<>());
                    for (int k = 0; k < 4; k++) {
                        int curX = j + moveX[k];
                        int curY = i + moveY[k];
                        if (curX < size && curX >= 0 && curY < size && curY >= 0) {
                            if (map[i][j] + 1 == map[curY][curX])
                                graph.get(map[i][j]).add(map[curY][curX]);
                        }
                    }
                }
            }

            for (int i = 1; i <= size * size; i++) {
                recursive(i, i, 0);
            }

            System.out.printf("#%d %d %d\n", test_case, start, max + 1);

            long estimatedTime = System.nanoTime() - startTime;

            System.out.println("걸린 시간 : " + estimatedTime/1000000000.0 + " milli seconds");
        }
    }

    static void recursive(int startNum, int curNum, int moveCount) {

        if (graph.get(curNum).isEmpty()) {
            if (max < moveCount) {
                start = startNum;
                max = moveCount;
            } else if (max == moveCount) {
                start = Math.min(startNum, start);
            }
            return;
        }

        recursive(startNum, curNum + 1, moveCount + 1);
    }
}
