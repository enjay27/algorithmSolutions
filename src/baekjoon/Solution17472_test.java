package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Solution17472_test {
    static int[][] map;
    static int height;
    static int width;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        height = sc.nextInt();
        width = sc.nextInt();

        map = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int landCount = 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 1) {
                    landCount++;
                    landTracking(j, i, landCount);
                }
            }
        }

        int[][] graph = new int[landCount - 1][landCount - 1];

        for (int i = 0; i < height; i++) {
            int from = -1;
            int to = -1;
            int count = 0;
            for (int j = 0; j < width; j++) {
                if (map[i][j] != 0 && from == -1) {
                    from = map[i][j] - 2;
                } else if (map[i][j] - 2 == from) {
                    count = 0;
                } else if (map[i][j] == 0) {
                    if (from != -1)
                        count++;
                } else {
                    to = map[i][j] - 2;
                    if (from != -1 && to != -1 && count > 1) {
                        if (graph[from][to] == 0) {
                            graph[from][to] = count;
                            graph[to][from] = count;
                        } else {
                            graph[from][to] = Math.min(graph[from][to], count);
                            graph[to][from] = Math.min(graph[to][from], count);
                        }
                    }
                    from = to;
                }
            }
        }

        for (int i = 0; i < width; i++) {
            int from = -1;
            int to = -1;
            int count = 0;
            for (int j = 0; j < height; j++) {
                if (map[j][i] != 0 && from == -1) {
                    from = map[j][i] - 2;
                } else if (map[j][i] - 2 == from) {
                    count = 0;
                } else if (map[j][i] == 0) {
                    if (from != -1)
                        count++;
                } else {
                    to = map[j][i] - 2;
                    if (from != -1 && to != -1 && count > 1) {
                        if (graph[from][to] == 0) {
                            graph[from][to] = count;
                            graph[to][from] = count;
                        } else {
                            graph[from][to] = Math.min(graph[from][to], count);
                            graph[to][from] = Math.min(graph[to][from], count);
                        }
                    }
                    from = to;
                    count = 0;
                }
            }

        }

        boolean isPossible = true;
        for (int[] ints : graph) {
            int sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            if (sum == 0) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            boolean[] visited = new boolean[landCount - 1];
            int[] distance = new int[landCount - 1];
            Arrays.fill(distance, Integer.MAX_VALUE);

            distance[0] = 0;
            int minIndex = -1;
            for (int count = 0; count < landCount - 2; count++) {
                int minDistance = Integer.MAX_VALUE;
                minIndex = -1;
                for (int i = 0; i < distance.length; i++) {
                    if (visited[i]) continue;
                    if (distance[i] < minDistance) {
                        minDistance = distance[i];
                        minIndex = i;
                    }
                }

                if (minIndex == -1) {
                    break;
                }
                visited[minIndex] = true;
                for (int i = 0; i < landCount - 1; i++) {
                    if (visited[i]) continue;
                    if (graph[minIndex][i] == 0) continue;
                    if (distance[i] > graph[minIndex][i]) {
                        distance[i] = graph[minIndex][i];
                    }

                }
            }

            if (minIndex == -1) {
                System.out.println(-1);
            } else {
                int sum = 0;
                for (int i : distance) {
                    sum += i;
                }
                System.out.println(sum);
            }
        } else {
            System.out.println(-1);
        }
    }

    static void landTracking(int curX, int curY, int number) {
        if (curX < 0 || curX >= width || curY < 0 || curY >= height) {
            return;
        }

        if (map[curY][curX] != 1) return;

        map[curY][curX] = number;

        for (int i = 0; i < 4; i++) {
            landTracking(curX + moveX[i], curY + moveY[i], number);
        }

    }
}
