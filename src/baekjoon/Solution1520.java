package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1520 {

    static int height;
    static int width;
    static int count = 0;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static int[][] storedWayCount;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();

        map = new int[height][width];
        visited = new boolean[height][width];
        storedWayCount = new int[height][width];
        memo = new int[height][width];
        for (int[] ints : storedWayCount) {
            Arrays.fill(ints, -1);
        }
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        downside(0, 0, Integer.MAX_VALUE);

        storedWayCount[0][0] = 1;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                downside_dp(j, i, map[i][j], storedWayCount[i][j]);
//            }
//        }
//        downside_dp(0, 0, Integer.MAX_VALUE, 0);
//        System.out.println(count);
//        System.out.println();
        System.out.println(down(width - 1, height - 1));
//        for (int[] ints : storedWayCount) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }

        int ans = dfs_dp(0, 0, Integer.MAX_VALUE);
        System.out.println(ans);
    }

    static int[][] memo;

    static int dfs_dp(int curX, int curY, int prevHeight) {
        if (curX == height - 1 && curY == width - 1) {
            return 1;
        }
        if (curX < 0 || curX >= width || curY < 0 || curY >= height) {
            return 0;
        }
        if (memo[curY][curX] == -1) {
            return memo[curY][curX];
        }
        memo[curY][curX] = 0;

        if (prevHeight <= map[curY][curX]) return 0;
        visited[curY][curX] = true;
        for (int i = 0; i < 4; i++) {
            memo[curY][curX] = memo[curY][curX] + dfs_dp(curX + moveX[i], curY + moveY[i], map[curY][curX]);
        }
        visited[curY][curX] = false;

        return memo[curY][curX];
    }

    static int down(int curX, int curY) {
        // storedWayCount[Y][X] = down()
        if (curX < 0 || curX >= width || curY < 0 || curY >= height) {
            return 0;
        }
        if (visited[curY][curX]) return 0;
        int sum = 0;
        visited[curY][curX] = true;
        for (int i = 0; i < 4; i++) {
            int movedX = curX + moveX[i];
            int movedY = curY + moveY[i];
            if (movedX < 0 || movedX >= width || movedY < 0 || movedY >= height) {
                continue;
            }
            if (map[curY][curX] >= map[movedY][movedX]) continue;
            if (storedWayCount[movedY][movedX] == -1) {
                storedWayCount[movedY][movedX] = down(movedX, movedY);
            }
            sum += storedWayCount[movedY][movedX];

        }
        return sum;
    }

    static void downside(int curX, int curY, int prevHeight) {
        if (curX == height - 1 && curY == width - 1) {
            count++;
            return;
        }
        if (curX < 0 || curX >= width || curY < 0 || curY >= height) {
            return;
        }
        if (visited[curY][curX]) return;
        if (prevHeight <= map[curY][curX]) return;
        visited[curY][curX] = true;
        for (int i = 0; i < 4; i++) {
            downside(curX + moveX[i], curY + moveY[i], map[curY][curX]);
        }
        visited[curY][curX] = false;
    }

    static void downside_dp(int curX, int curY, int prevHeight, int prevCount) {
        if (prevCount == 0) return;

        for (int i = 0; i < 4; i++) {

            int movedX = curX + moveX[i];
            int movedY = curY + moveY[i];
            if (movedX < 0 || movedX >= width || movedY < 0 || movedY >= height) {
                continue;
            }
            if (prevHeight <= map[movedY][movedX]) continue;

            if (storedWayCount[movedY][movedX] != 0) {
                downside_add(curX, curY, map[curY][curX], prevCount);
            } else {
                storedWayCount[movedY][movedX] += prevCount;
            }
        }
    }

    static void downside_add(int pervX, int pervY, int prevHeight, int prevCount) {
        for (int i = 0; i < 4; i++) {
            int movedX = pervX + moveX[i];
            int movedY = pervY + moveY[i];
            if (movedX < 0 || movedX >= width || movedY < 0 || movedY >= height) {
                continue;
            }
            if (prevHeight <= map[movedY][movedX]) continue;
            storedWayCount[movedY][movedX] += prevCount;
        }
    }

}
