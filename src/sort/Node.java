package sort;

public class Node {
    int idx;
    int level;

    public Node(int idx, int level) {
        this.idx = idx;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Node{" +
                "idx=" + idx +
                ", level=" + level +
                '}';
    }
}
