package dataStructure.linkedList;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addLast("마인");
        list.addFirst("ㅁ");
        list.addLast("ㅇ");

        list.printList();
    }
}
