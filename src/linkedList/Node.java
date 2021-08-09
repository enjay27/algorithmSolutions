package linkedList;

public class Node {

    String data;
    Node link;

    public Node(String data, Node head) {
        this.data = data;
        this.link = head;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", link=" + link +
                '}';
    }
}
