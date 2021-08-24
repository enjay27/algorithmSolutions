package swea;

import java.util.*;

public class Solution1238 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int size = sc.nextInt();
            int start = sc.nextInt();
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int i = 0; i < size / 2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                graph.putIfAbsent(from, new ArrayList<>());
                graph.get(from).add(to);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            int[] visited = new int[101];
            visited[start] = 1;

            int max = 0;
            while (!queue.isEmpty()) {
                Integer visit = queue.poll();
                for (Integer integer : graph.getOrDefault(visit, Collections.emptyList())) {
                    if (visited[integer] != 0) continue;
                    visited[integer] = visited[visit] + 1;
                    max = visited[integer];
                    queue.offer(integer);
                }
            }

            int maxIndex = 0;
            for (int i = 1; i < 101; i++) {
                if (visited[i] == max) maxIndex = i;
            }

            System.out.printf("#%d %d\n", tc, maxIndex);
        }
    }
}
