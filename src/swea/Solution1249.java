package swea;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution1249 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {-1, 0, 1, 0};

        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int size = sc.nextInt();

            int[][] map = new int[size][size];
            for (int i = 0; i < size; i++) {
                String input = sc.next();
                map[i] = input.chars().map(a -> a - 48).toArray();
            }
            boolean[][] visited = new boolean[size][size];
            int[][] depth = new int[size][size];
            for (int[] ints : depth) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            depth[0][0] = map[0][0];

            Queue<Depth> queue = new PriorityQueue<>((a, b) -> a.depth - b.depth);
            queue.offer(new Depth(0, 0, map[0][0]));
            for (int count = 0; count < size * size - 1; count++) {
                Depth poll = queue.poll();
                if (poll == null) break;

                visited[poll.y][poll.x] = true;

                for (int i = 0; i < 4; i++) {
                    int movedX = poll.x + moveX[i];
                    int movedY = poll.y + moveY[i];
                    if (movedX < 0 || movedX >= size || movedY < 0 || movedY >= size) continue;
                    if (visited[movedY][movedX]) continue;
                    if (depth[movedY][movedX] > poll.depth + map[movedY][movedX]) {
                        depth[movedY][movedX] = poll.depth + map[movedY][movedX];
                        queue.offer(new Depth(movedX, movedY, poll.depth + map[movedY][movedX]));
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, depth[size - 1][size - 1]);

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

    static class Depth {
        int x;
        int y;
        int depth;

        public Depth(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
