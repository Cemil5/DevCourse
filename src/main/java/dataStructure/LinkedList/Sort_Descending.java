package dataStructure.LinkedList;

// optional exercise
// Sort the singly linked list1 of integers in descending order without using any sort algorithm.
public class Sort_Descending {
    public static void main(String[] args) {

        var list1 = new OurLinkedList();

        list1.addLast(9);
        list1.addLast(11);
        list1.addLast(8);
        list1.addLast(5);
        list1.addLast(4);
        list1.addLast(15);

        var list5 = list1.sortDescending(list1);
        System.out.println("main result:");
        list5.printLinkedList();

//*******************************************************
        var list2 = new MyLinkedList<Integer>();

        list2.addLast(9);
        list2.addLast(11);
        list2.addLast(8);
        list2.addLast(5);
        list2.addLast(4);
        list2.addLast(15);

        sortDescending(list2);
    }



    public static void sortDescending(MyLinkedList<Integer> list){
        list.printLinkedList();
        MyLinkedList<Integer>.Node current = list.first;
        MyLinkedList<Integer>.Node node = list.first;
        MyLinkedList<Integer>.Node prev = list.first;;
        MyLinkedList<Integer> result = new MyLinkedList<>();
        int max = list.first.value;
        int size = list.size();
        while (size > 1){
            while (current.next != null) {
                if (max < current.next.value) {
                    max = current.next.value;
                    node = current.next;
                    prev = current;
                }
                current = current.next;
            }

            prev.next = node.next;
            result.addLast(max);
            size--;

            if (max == list.first.value){
                list.first = list.first.next;
            }
            current =list.first;
            max = list.first.value;
        }
        result.addLast(list.first.value);
        list.first=null;

        list.printLinkedList();
        result.printLinkedList();
    }

}
