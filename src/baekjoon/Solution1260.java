package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution1260 {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int start = sc.nextInt();
        visited = new boolean[vertexCount + 1];

        for (int i = 0; i < edgeCount; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        dfs(start);
        bw.flush();

        Arrays.fill(visited, false);
        bw.newLine();
        bfs(start);
        bw.flush();
    }

    static void dfs(int startVertex) throws IOException {
        if (visited[startVertex]) return;

        visited[startVertex] = true;

        bw.write(startVertex + " ");

        List<Integer> vertexes = graph.getOrDefault(startVertex, Collections.emptyList());
        vertexes.sort(Comparator.comparingInt(a -> a));
        for (Integer vertex : vertexes) {
            dfs(vertex);
        }
    }

    static void bfs(int startVertex) throws IOException {
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.offer(startVertex);
        while (!queue.isEmpty()) {
            Integer curVertex = queue.poll();
            bw.write(curVertex + " ");
            for (Integer vertex : graph.getOrDefault(curVertex, Collections.emptyList())) {
                if (visited[vertex]) continue;
                visited[vertex] = true;
                queue.offer(vertex);
            }
        }
    }
}
