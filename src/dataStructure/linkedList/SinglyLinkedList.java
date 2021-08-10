package dataStructure.linkedList;

public class SinglyLinkedList<T> {

    private Node<T> head;

    public void addFirst(T data) {
        head = new Node<>(data, head);

    }

    public Node<T> getLast() {
        for (Node<T> curNode = head; curNode != null ; curNode = curNode.link) {
            if (curNode.link == null) {
                return curNode;
            }
        }
        return null;
    }

    public void addLast(T data) {
        if (head == null) {
            addFirst(data);
            return;
        }
        Node<T> lastNode = getLast();
        lastNode.link = new Node<>(data);
    }

    public Node<T> find(T data) {
        for (Node<T> curNode = head; curNode != null ; curNode = curNode.link) {
            if (curNode.data.equals(data)) {
                return curNode;
            }
        }
        return null;
    }

    public Node<T> getPrevious(Node<T> target) {
        for (Node<T> curNode = head; curNode != null ; curNode = curNode.link) {
            if (curNode.link == target) {
                return curNode;
            }
        }
        return null;
    }

    public void deleteNode(T data) {
        Node<T> targetNode = find(data);
        if (targetNode == null) {
            throw new IllegalStateException();
        }

        Node<T> preNode = getPrevious(targetNode);

        if (preNode == null) {
            head = targetNode.link;
        } else {
            preNode.link = targetNode.link;
        }
        targetNode.link = null;
    }

    public void printList() {
        System.out.print("L = ( ");
        for (Node<T> curNode = head; curNode != null; curNode = curNode.link) {
            System.out.print(curNode.data + " ");
        }
        System.out.println(")");
    }
}
