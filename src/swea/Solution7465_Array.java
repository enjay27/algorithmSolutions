package swea;

import java.util.*;

public class Solution7465_Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            int vertexCount  = sc.nextInt();
            int edgeCount = sc.nextInt();
            boolean[][] graph = new boolean[vertexCount][vertexCount];
            boolean[] visited = new boolean[vertexCount];
            int count = 0;

            for (int i = 0; i < edgeCount; i++) {
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;

                graph[from][to] = true;
                graph[to][from] = true;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < vertexCount; i++) {
                if (!visited[i]) {
                    count++;
                    queue.offer(i);
                }
                visited[i] = true;
                while (!queue.isEmpty()) {
                    Integer from = queue.poll();
                    boolean[] booleans = graph[from];
                    for (int j = 0; j < booleans.length; j++) {
                        if (!booleans[j]) continue;
                        if (visited[j]) continue;
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, count);
        }
    }
}
