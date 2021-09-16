package swea;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution3124_queue {
    static class Vertex {
        int from;

        public Vertex(int from) {
            this.from = from;
        }

        Queue<Edge> queue = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
    }

    static class Edge {
        int from;
        int to;
        long weight;

        public Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {

            int vertexNumber = sc.nextInt();
            int edgeNumber = sc.nextInt();
            boolean[] visited = new boolean[vertexNumber];
            Vertex[] graph = new Vertex[vertexNumber];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new Vertex(i);
            }
            for (int i = 0; i < edgeNumber; i++) {
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;
                long weight = sc.nextLong();
                Edge edge = new Edge(from, to, weight);
                graph[from].queue.offer(edge);
                graph[to].queue.offer(edge);
            }

            Queue<Edge> distance = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
            distance.offer(new Edge(0,0, 0));
            long[] distanceArr = new long[vertexNumber];
            Arrays.fill(distanceArr, Integer.MAX_VALUE);
            for (int i = 0; i < vertexNumber; i++) {
                Edge minEdge = distance.poll();
                while (visited[minEdge.to] && visited[minEdge.from]) {
                    minEdge = distance.poll();
                }
                if (visited[minEdge.to]) {
                    visited[minEdge.from] = true;
                    distanceArr[minEdge.from] = Math.min(minEdge.weight, distanceArr[minEdge.from]);
                } else {
                    visited[minEdge.to] = true;
                    distanceArr[minEdge.to] = Math.min(minEdge.weight, distanceArr[minEdge.to]);
                }
                minEdge.weight = Integer.MAX_VALUE;

                if (!graph[minEdge.to].queue.isEmpty()) {
                    while (!graph[minEdge.to].queue.isEmpty()) {
                        Edge poll = graph[minEdge.to].queue.poll();
                        if (graph[poll.to].queue.isEmpty() && graph[poll.from].queue.isEmpty()) continue;
                        if (poll.weight != Integer.MAX_VALUE) distance.offer(poll);
                    }
                } else if (!graph[minEdge.from].queue.isEmpty()) {
                    while (!graph[minEdge.from].queue.isEmpty()) {
                        Edge poll = graph[minEdge.from].queue.poll();
                        if (graph[poll.to].queue.isEmpty() && graph[poll.from].queue.isEmpty()) continue;
                        if (poll.weight != Integer.MAX_VALUE) distance.offer(poll);
                    }
                }
            }
            long sum = 0;
            for (long i : distanceArr) {
                sum += i;
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
}
