package linkedList;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast("마인");

        System.out.println(list.getLast());
        list.printList();
    }
}
