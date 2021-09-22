package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1600 {
    static class MoveCount {
        int horse;
        int normal;

        public MoveCount() {
        }

        public MoveCount(int horse, int normal) {
            this.horse = horse;
            this.normal = normal;
        }

        public int spentMoveCount() {
            return horse + normal;
        }

        public void compareAndChange(MoveCount moveCount) {
            if (moveCount == null) return;
            if (this.spentMoveCount() > moveCount.spentMoveCount()) {
                this.horse = moveCount.horse;
                this.normal = moveCount.normal;
            } else if (this.spentMoveCount() == moveCount.spentMoveCount()) {
                this.horse = Math.min(this.horse, moveCount.horse);
            }
        }

        @Override
        public String toString() {
            return "MoveCount{" +
                    "horse=" + horse +
                    ", normal=" + normal +
                    '}';
        }
    }
    static int horseCount;
    static char[][] map;
    static int width;
    static int height;
    static int moveCount = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveHorseX = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] moveHorseY = {2, -2, 2, -2, 1, -1, 1, -1};
    static MoveCount[][] storedMoveCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        horseCount = sc.nextInt();
        width = sc.nextInt();
        height = sc.nextInt();
        visited = new boolean[height][width];
        map = new char[height][width];
        storedMoveCount = new MoveCount[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char c = sc.next().charAt(0);
                map[i][j] = c;
            }
        }
        tracking(0, 0, 0, 0);
        System.out.println(moveCount);

        storedMoveCount[0][0] = new MoveCount();
        MoveCount memoization = memoization(width - 1, height - 1, 0, 0);
        System.out.println(memoization.normal);
    }

    static void tracking(int curX, int curY, int count, int spentHorse) {
        if (curX < 0 || curX >= width || curY < 0 || curY >= height) {
            return;
        }
        if (map[curY][curX] == '1') {
            return;
        }
        if (visited[curY][curX]) {
            return;
        }
        if (count >= moveCount) {
            return;
        }
        if (curX == width - 1 && curY == height - 1) {
            moveCount = count;
            return;
        }
        visited[curY][curX] = true;
        if (spentHorse < horseCount) {
            for (int i = 0; i < moveHorseX.length; i++) {
                tracking(curX + moveHorseX[i], curY + moveHorseY[i], count + 1, spentHorse + 1);
            }
        }
        for (int i = 0; i < moveX.length; i++) {
            tracking(curX + moveX[i], curY + moveY[i], count + 1, spentHorse);
        }

        visited[curY][curX] = false;
    }

    static MoveCount memoization(int curX, int curY, int count, int spentHorse) {
        if (curX < 0 || curX >= width || curY < 0 || curY >= height) {
            return null;
        }
        if (map[curY][curX] == '1') {
            return null;
        }
        if (storedMoveCount[curY][curX] != null) {
            MoveCount moveCount = storedMoveCount[curY][curX];
            if (moveCount.spentMoveCount() > count) return null;
            else if (moveCount.spentMoveCount() < count) {
                moveCount.normal = count;
                moveCount.horse = spentHorse;
            } else {
                moveCount.horse = Math.min(spentHorse, moveCount.horse);
            }
        } else {
            storedMoveCount[curY][curX] = new MoveCount(999999, 999999);

            if (spentHorse < horseCount) {
                for (int i = 0; i < moveHorseX.length; i++) {
                    MoveCount memoization = memoization(curX + moveHorseX[i], curY + moveHorseY[i], count + 1, spentHorse + 1);
                    storedMoveCount[curY][curX].compareAndChange(memoization);
                }
            }
            for (int i = 0; i < moveX.length; i++) {
                MoveCount memoization = memoization(curX + moveX[i], curY + moveY[i], count + 1, spentHorse);
                storedMoveCount[curY][curX].compareAndChange(memoization);
            }
        }

        return storedMoveCount[curY][curX];
    }
}
