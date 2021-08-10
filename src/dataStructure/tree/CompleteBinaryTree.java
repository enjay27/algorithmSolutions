package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    private final char[] nodes;
    private final int size;
    private int lastIndex;

    public CompleteBinaryTree(int size) {
        this.size = size;
        nodes = new char[size + 1];
    }

    public void add(char c) {
        if (lastIndex == size) return;

        nodes[++lastIndex] = c;
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);

        int current = 0;
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.println(nodes[current]);
            if (current * 2 <= lastIndex) {
                queue.offer(current * 2);
            }
            if (current * 2 + 1 <= lastIndex) {
                queue.offer(current * 2 + 1);
            }
        }
    }
}
