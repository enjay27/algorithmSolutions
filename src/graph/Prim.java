package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Prim {
    static int V, E;
    static int[][] adj;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./resources/mst.txt"));
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        adj = new int[V][V];
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj[a][b] = c;
            adj[b][a] = c;
        }
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 정점 선택
        distance[0] = 0;

        for (int count = 0; count < V - 1; count++) {
            // 비용이 가장 적은 정점 선택
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < distance.length; i++) {
                if (visited[i]) continue;
                if (distance[i] < minDistance) {
                    minDistance = distance[i];
                    minIndex = i;
                }
            }
            // minIndex : 방문하지 않은 정점 중 웨이트가 가장 작은 정점
            // minIndex 에 연결되어 있는 정점을 탐색해서 distance 배열을 업데이트하고
            // 그중 가장 적은 비용의 정점으로 이동한다
            visited[minIndex] = true;
            for (int i = 0; i < V; i++) {
                if (visited[i]) continue;
                if (adj[minIndex][i] == 0) continue;
                if (distance[i] > adj[minIndex][i]) {
                    distance[i] = adj[minIndex][i];
                }

            }
        }

        System.out.println("distance = " + Arrays.toString(distance));
    }
}
