package swea;

import java.util.*;

public class Solution7465 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            int vertexCount  = sc.nextInt();
            int edgeCount = sc.nextInt();
            Map<Integer, List<Integer>> graph = new HashMap<>();
            boolean[] visited = new boolean[vertexCount + 1];
            int count = 0;

            for (int i = 0; i < edgeCount; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                graph.putIfAbsent(from, new ArrayList<>());
                graph.putIfAbsent(to, new ArrayList<>());
                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= vertexCount; i++) {
                if (!visited[i]) {
                    count++;
                    queue.offer(i);
                }
                visited[i] = true;
                while (!queue.isEmpty()) {
                    Integer from = queue.poll();
                    for (Integer to : graph.get(from)) {
                        if (visited[to]) continue;
                        queue.offer(to);
                        visited[to] = true;
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, count);
        }
    }
}
