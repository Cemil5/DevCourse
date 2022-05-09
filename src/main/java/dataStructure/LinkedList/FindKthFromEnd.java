package dataStructure.LinkedList;

import java.util.NoSuchElementException;

public class FindKthFromEnd {

//  Finding the Kth node from the end in one pass where you don’t know the size of the list1.
    public static void main(String[] args) {

        var list = new MyLinkedList<Integer>();
        for (int i=1; i<= 9; i++) list.addLast(i);

        System.out.println(findingKthValueFromEnd(list, 2).value);
    }

    public static MyLinkedList<Integer>.Node findingKthValueFromEnd(MyLinkedList<Integer> list, int k){
        if (list.isEmpty()) throw new NoSuchElementException("list is empty");

        MyLinkedList<Integer>.Node node1 = list.first;
        MyLinkedList<Integer>.Node node2 = list.first;
        while (k>1 || node1.next != null){
            node1 = node1.next;
            if (k>1){
                if (node1 == null) throw new IllegalArgumentException("k is bigger than list size");
                k--;
            }
            else { node2 = node2.next; }
        }
        return node2;
    }
}
