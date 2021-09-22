package baekjoon;

import java.util.Scanner;

public class Solution1600_memoization {
    static class Movement {
        int total;
        int horse;

        public Movement() {
        }

        public Movement(int normal, int horse) {
            this.total = normal;
            this.horse = horse;
        }

        public int spentMoveCount() {
            return horse + total;
        }

        public void compareAndChange(int total, int horse) {
            if (this.total > total) {
                this.horse = horse;
                this.total = total;
            } else if (this.total == total) {
                this.horse = Math.max(this.horse, horse);
            }
        }

        public void add(Movement movement) {
            this.horse += movement.horse;
            this.total += movement.total;
        }

        @Override
        public String toString() {
            return "Movement{" +
                    "horse=" + horse +
                    ", total=" + total +
                    '}';
        }
    }

    static int horseCount;
    static int[][] map;
    static int width;
    static int height;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveHorseX = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] moveHorseY = {-2, -1, 1, 2, 2, 1, -1, -2};
    static boolean[][] visited;
    static Movement[][] storedMoveCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        horseCount = sc.nextInt();
        width = sc.nextInt();
        height = sc.nextInt();
        map = new int[height][width];
        storedMoveCount = new Movement[height][width];
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int c = sc.nextInt();
                map[i][j] = c;
            }
        }

        storedMoveCount[0][0] = new Movement(0, horseCount);
        Movement memoization = memoization(width - 1, height - 1, 0, horseCount);
        System.out.println(memoization);
    }

    static Movement memoization(int curX, int curY, int curCount, int restHorse) {
        if (curX < 0 || curX >= width || curY < 0 || curY >= height) {
            return null;
        }
        if (visited[curY][curX]) {
            return null;
        }
        if (map[curY][curX] == 1) {
            return null;
        }
        if (restHorse < 0) {
            return null;
        }

        visited[curY][curX] = true;
        if (storedMoveCount[curY][curX] == null) {
            storedMoveCount[curY][curX] = new Movement(curCount, restHorse);
            for (int i = 0; i < moveX.length; i++) {
                Movement memoization = memoization(curX + moveX[i], curY + moveY[i], curCount + 1, restHorse);
                if (memoization != null)
                    storedMoveCount[curY][curX].compareAndChange(memoization.total + 1, memoization.horse);
            }
            for (int i = 0; i < moveHorseX.length; i++) {
                Movement memoization = memoization(curX + moveHorseX[i], curY + moveHorseY[i], curCount + 1, restHorse - 1);
                if (memoization != null)
                    storedMoveCount[curY][curX].compareAndChange(memoization.total + 1, memoization.horse);
            }
        }
        storedMoveCount[curY][curX].compareAndChange(curCount, restHorse);
        visited[curY][curX] = false;
        return storedMoveCount[curY][curX];
    }
}
