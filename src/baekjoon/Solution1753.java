package baekjoon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution1753 {
    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File("");
//        for(String fileNames : file.list()) System.out.println(fileNames);
        System.setIn(new FileInputStream("./resources/02.in"));
        Scanner sc = new Scanner(System.in);
        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        int start = sc.nextInt();

        int[] distance = new int[vertexCount + 1];

        Map<Integer, Map<Integer, List<Integer>>> graph = new HashMap<>();
        for (int i = 0; i < edgeCount; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).putIfAbsent(to, new ArrayList<>());
            graph.get(from).get(to).add(weight);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer to : graph.getOrDefault(poll, Collections.emptyMap()).keySet()) {
                if (distance[to] == 0)
                    queue.offer(to);
                for (Integer weight : graph.get(poll).get(to)) {
                    distance[to] = distance[to] == 0 ? distance[poll] + weight : Math.min(distance[to], distance[poll] + weight);
                }
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
