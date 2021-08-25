package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            int numberOfIslands = sc.nextInt();
            int[] pointsX = new int[numberOfIslands];
            int[] pointsY = new int[numberOfIslands];

            for (int i = 0; i < numberOfIslands; i++) {
                 pointsX[i] = sc.nextInt();
            }
            for (int i = 0; i < numberOfIslands; i++) {
                pointsY[i] = sc.nextInt();
            }

            double taxRate = sc.nextDouble();

            double[][] graph = new double[numberOfIslands][numberOfIslands];
            for (int i = 0; i < numberOfIslands; i++) {
                for (int j = 0; j < numberOfIslands; j++) {
                    if (i == j) continue;
                    graph[i][j] = distance(pointsX, pointsY, i, j);
                }
            }

            double[] distance = new double[numberOfIslands];
            Arrays.fill(distance, Double.MAX_VALUE);
            boolean[] visited = new boolean[numberOfIslands];
            distance[0] = 0;

            for (int from = 0; from < numberOfIslands; from++) {

                double min = Double.MAX_VALUE;
                int index = -1;
                for (int candidate = 0; candidate < numberOfIslands; candidate++) {
                    if (visited[candidate]) continue;
                    if (min > distance[candidate]) {
                        min = distance[candidate];
                        index = candidate;
                    }
                }

                visited[index] = true;
                for (int i = 0; i < numberOfIslands; i++) {
                    if (visited[i]) continue;
                    if (graph[index][i] == 0) continue;
                    if (distance[i] > graph[index][i]) {
                        distance[i] = graph[index][i];
                    }
                }
            }

            double result = 0;
            for (double v : distance) {
                result += v;
            }
            result *= taxRate;

            System.out.println("#" + tc + " " + Math.round(result));
        }
    }

    static double distance(int[] pointsX, int[] pointsY, int a, int b) {
        return Math.pow(pointsX[a] - pointsX[b], 2) + Math.pow(pointsY[a] - pointsY[b], 2);
    }
}
