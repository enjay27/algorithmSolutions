package baekjoon;

import java.util.*;

public class Solution15685 {
    static int[][] map = new int[101][101];
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int curveNumber = sc.nextInt();
        for (int i = 0; i < curveNumber; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int direction = sc.nextInt();
            int generation = sc.nextInt();
            makeDragonCurve(x, y, direction, 0, generation, new ArrayList<>());
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] + map[i + 1][j + 1] + map[i + 1][j] + map[i][j + 1] == 4) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static void makeDragonCurve(int x, int y, int direction, int curGeneration, int generation, List<Integer> moveList) {
        if (curGeneration > generation) {
            return;
        }

        int curX = x;
        int curY = y;
        map[curY][curX] = 1;
        if (moveList.isEmpty()) {
            curX += moveX[direction];
            curY += moveY[direction];
            map[curY][curX] = 1;
            moveList.add(direction);
        } else {
            Stack<Integer> stack = new Stack<>();
            for (int i = moveList.size() - 1; i >= 0; i--) {
                Integer dir = moveList.get(i);
                int rotate = dir + 1;// + direction;
                if (rotate < 0) {
                    rotate += 4;
                }
                rotate %= 4;
                curX += moveX[rotate];
                curY += moveY[rotate];
                map[curY][curX] = 1;
                stack.push(rotate);
            }
            moveList.addAll(stack);
        }

        makeDragonCurve(curX, curY, direction, curGeneration + 1, generation, moveList);
    }
}
