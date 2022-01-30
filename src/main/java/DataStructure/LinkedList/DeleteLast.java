package DataStructure.LinkedList;

public class DeleteLast {
    public static void main(String[] args) {

        var list1 = new MyLinkedList<Integer>();
        for (int i=1; i<= 9; i++) list1.addLast(i);

        list1.printLinkedList();
        System.out.println(list1.size());
        deleteLast(list1);

        list1.printLinkedList();
        System.out.println(list1.size());

    }

    public static void deleteLast(MyLinkedList<Integer> list){
        if (list.isEmpty()) throw new IllegalArgumentException("list is empty");

        if (list.first == list.last) list.first = list.last = null;
        else {
            MyLinkedList<Integer>.Node current = list.first.next;
            while (current.next != list.last) {
                current = current.next;
            }
            current.next = null;
            list.last = current;
        }
    }

}
