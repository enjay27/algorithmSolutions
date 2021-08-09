package linkedList;

public class SinglyLinkedList {

    private Node head;

    public void addFirst(String data) {
        head = new Node(data, head);
    }

    public Node getLast() {
        for (Node curNode = head; curNode != null ; curNode = curNode.link) {
            if (curNode.link == null) {
                return curNode;
            }
        }
        return null;
    }

    public void addLast(String data) {
        if (head == null) {
            addFirst(data);
            return;
        }
        Node lastNode = getLast();
        lastNode.link = new Node(data, head);
    }

    public Node find(String data) {
        for (Node curNode = head; curNode != null ; curNode = curNode.link) {
            if (curNode.data.equals(data)) {
                return curNode;
            }
        }
        return null;
    }

    public Node getPrevious(Node target) {
        for (Node curNode = head; curNode != null ; curNode = curNode.link) {
            if (curNode.link == target) {
                return curNode;
            }
        }
        return null;
    }

    public void deleteNode(String data) {
        Node targetNode = find(data);
        if (targetNode == null) {
            throw new IllegalStateException();
        }

        Node preNode = getPrevious(targetNode);

        if (preNode == null) {
            head = targetNode.link;
        } else {
            preNode.link = targetNode.link;
        }
        targetNode.link = null;
    }

    public void printList() {
        System.out.print("L = ( ");
        for (Node curNode = head; curNode != null; curNode = curNode.link) {
            System.out.print(curNode.data + " ");
        }
        System.out.println(")");
    }
}
