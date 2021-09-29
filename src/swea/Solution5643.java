package swea;

import java.util.*;

public class Solution5643 {
    static int studentNumber;
    static int compareNumber;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            studentNumber = sc.nextInt();
            compareNumber = sc.nextInt();
            Map<Integer, List<Integer>> forwardGraph = new HashMap<>();
            Map<Integer, List<Integer>> reverseGraph = new HashMap<>();
            for (int i = 1; i <= studentNumber; i++) {
                forwardGraph.put(i, new ArrayList<>());
                reverseGraph.put(i, new ArrayList<>());
            }
            for (int i = 0; i < compareNumber; i++) {
                int little = sc.nextInt();
                int tall = sc.nextInt();
                forwardGraph.get(little).add(tall);
                reverseGraph.get(tall).add(little);
            }

            int[] lessNodeCounts = new int[studentNumber + 1];
            int[] greaterNodeCounts = new int[studentNumber + 1];

            for (int i = 1; i <= studentNumber; i++) {
                bfs(i, reverseGraph, lessNodeCounts);
                bfs(i, forwardGraph, greaterNodeCounts);
            }
            int count = 0;
            for (int i = 1; i <= studentNumber; i++) {
                if (lessNodeCounts[i] + greaterNodeCounts[i] == studentNumber - 1)
                    count++;
            }
            System.out.printf("#%d %d\n", tc, count);
        }
    }

    static void bfs(int index, Map<Integer, List<Integer>> graph, int[] nodeCounts) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        boolean[] visited = new boolean[studentNumber + 1];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;
            for (Integer nextNodes : graph.get(poll)) {
                if (visited[nextNodes]) continue;
                nodeCounts[nextNodes]++;
                queue.offer(nextNodes);
                visited[nextNodes] = true;
            }
        }
    }

    static int dfs(int index, Map<Integer, List<Integer>> graph, int[] nodeCounts) {
        if (graph.get(index).isEmpty()) {
            nodeCounts[index] = 0;
            return 1;
        }
        if (nodeCounts[index] == -1) {
            int count = 0;
            for (Integer nextNode : graph.get(index)) {
                count += dfs(nextNode, graph, nodeCounts);
            }
            nodeCounts[index] = count;
        }
        return nodeCounts[index] + 1;
    }
}
