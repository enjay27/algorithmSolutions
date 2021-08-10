package dataStructure.linkedList;

public class Node<T> {

    T data;
    Node<T> link;

    public Node(T data) {
        super();
        this.data = data;
    }

    public Node(T data, Node<T> head) {
        this.data = data;
        this.link = head;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data.toString() + '\'' +
                ", link=" + link.toString() +
                '}';
    }
}
