package baekjoon;

import java.util.*;

public class Solution1753_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int start = sc.nextInt();

        int[] distance = new int[vertexCount + 1];

        Map<Integer, Map<Integer, Queue<Integer>>> graph = new HashMap<>();
        for (int i = 0; i < edgeCount; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).putIfAbsent(to, new LinkedList<>());
            graph.get(from).get(to).add(weight);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer from = queue.poll();
            for (Integer to : graph.getOrDefault(from, Collections.emptyMap()).keySet()) {
                if (distance[to] == 0 && to != start)
                    queue.offer(to);
                int weight = graph.get(from).get(to).poll();
                distance[to] = distance[to] == 0 ? distance[from] + weight : Math.min(distance[to], distance[from] + weight);
//                for (Integer weight : graph.get(from).get(to)) {
//                    distance[to] = distance[to] == 0 ? distance[from] + weight : Math.min(distance[to], distance[from] + weight);
//                }
            }
        }

        for (int i = 1; i <= vertexCount; i++) {
            if (i != start && distance[i] == 0) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}
