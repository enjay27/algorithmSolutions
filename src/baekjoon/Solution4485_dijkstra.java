package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution4485_dijkstra {

    static int[] moveX = {0, -1, 0, 1};
    static int[] moveY = {-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int[][] distance;
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = 1;
        while (true) {
            size = sc.nextInt();
            if (size == 0) break;

            map = new int[size][size];
            visited = new boolean[size][size];
            distance = new int[size][size];
            for (int[] ints : distance) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            distance[0][0] = map[0][0];
            PriorityQueue<Distance> distanceQueue = new PriorityQueue<>();
            distanceQueue.offer(new Distance(0, 0, map[0][0]));
            for (int count = 0; count < size * size - 1; count++) {
                Distance poll = distanceQueue.poll();
                if (poll == null) break;
                int x = poll.x;
                int y = poll.y;
                visited[y][x] = true;

                for (int i = 0; i < 4; i++) {
                    int movedX = x + moveX[i];
                    int movedY = y + moveY[i];
                    if (movedX < 0 || movedX >= size || movedY < 0 || movedY >= size) {
                        continue;
                    }
                    if (visited[movedY][movedX]) continue;
                    if (distance[movedY][movedX] > poll.dist + map[movedY][movedX]) {
                        distance[movedY][movedX] = poll.dist + map[movedY][movedX];
                        distanceQueue.offer(new Distance(movedX, movedY, distance[movedY][movedX]));
                    }
                }
            }
            System.out.printf("Problem %d: %d\n", tc, distance[size - 1][size - 1]);
            tc++;
        }
    }

    static class Distance implements Comparable<Distance> {
        int x;
        int y;
        int dist;

        public Distance(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Distance o) {
            return this.dist - o.dist;
        }
    }
}
