package dataStructure.LinkedList;

public class InsertInOrder {

    public static void main(String[] args) {

        var list1 = new OurLinkedList();

        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
        list1.addLast(9);

/*
        list1.insertInOrder(5);
        list1.insertInOrder(0);
        list1.insertInOrder(10);
        list1.printLinkedList();
*/
        var list = new MyLinkedList<Integer>();
        for (int i=1; i<= 8; i++) list.addLast(i);

        insertInOrder(list1, 5);
        list1.printLinkedList();
    }

    public static void insertInOrder(OurLinkedList list, int item) {
        OurLinkedList.Node node = new OurLinkedList.Node(item);
        OurLinkedList.Node current = list.first;
        if (list.isEmpty()) list.first = list.last = node;
        else if (item < list.first.value) {
            node.next = list.first;
            list.first = node;
        } else {
            while (current != list.last && item > current.next.value ) {
                current = current.next;
            }
            if (current == list.last){
                current.next = node;
                list.last = node;
            } else {
                node.next = current.next;
                current.next = node;
            }
        }
    }

}
