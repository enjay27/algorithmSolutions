package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1922 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfComputer = sc.nextInt();
        int numberOfEdge = sc.nextInt();

        int[][] graph = new int[numberOfComputer][numberOfComputer];
        for (int i = 0; i < numberOfEdge; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();
            graph[from][to] = cost;
            graph[to][from] = cost;
        }

        boolean[] visited = new boolean[numberOfComputer];
        int[] distance = new int[numberOfComputer];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        for (int count = 0; count < numberOfComputer - 1; count++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < distance.length; j++) {
                if (visited[j]) continue;
                if (distance[j] < minDistance) {
                    minDistance = distance[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < numberOfComputer; j++) {
                if (visited[j]) continue;
                if (graph[minIndex][j] == 0) continue;
                if (distance[j] > graph[minIndex][j]) {
                    distance[j] = graph[minIndex][j];
                }
            }
        }

        int sum = 0;
        for (int num : distance) {
            sum += num;
        }

        System.out.println(sum);

    }
}
