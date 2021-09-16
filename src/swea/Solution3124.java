package swea;

import java.util.*;

public class Solution3124 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {

            int vertexNumber = sc.nextInt();
            int edgeNumber = sc.nextInt();
            boolean[] visited = new boolean[vertexNumber + 1];
            int[][] graph = new int[vertexNumber + 1][vertexNumber + 1];
            for (int i = 0; i < edgeNumber; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int weight = sc.nextInt();
                graph[from][to] = weight;
                graph[to][from] = weight;
            }

            int[] distance = new int[vertexNumber + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[1] = 0;
            for (int i = 1; i < vertexNumber; i++) {
                int minIndex = -1;
                int minDistance = Integer.MAX_VALUE;
                for (int j = 1; j < distance.length; j++) {
                    if (visited[j]) continue;
                    if (minDistance > distance[j]) {
                        minDistance = distance[j];
                        minIndex = j;
                    }
                }

                visited[minIndex] = true;

                for (int j = 1; j <= vertexNumber; j++) {
                    if (visited[j]) continue;
                    if (graph[minIndex][j] == 0) continue;
                    if (distance[j] > graph[minIndex][j]) {
                        distance[j] = graph[minIndex][j];
                    }
                }

            }
            long sum = 0;
            for (int i = 1; i < distance.length; i++) {
                sum += distance[i];
            }
            System.out.printf("#%d %d\n", tc, sum);
        }
    }
}
