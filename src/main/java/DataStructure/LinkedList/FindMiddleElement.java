package DataStructure.LinkedList;

import java.util.NoSuchElementException;

public class FindMiddleElement {
    /*
Find the middle of a linked list1 in one pass. If the list1 has an even number of nodes, there would be two
middle nodes. (Note: Assume that you don’t know the size of the list1 ahead of time.)
     */
    public static void main(String[] args) {

        var list = new MyLinkedList<Integer>();
        for (int i=1; i<= 8; i++) list.addLast(i);

        System.out.println(findMiddleElement(list));
    }

    public static String findMiddleElement(MyLinkedList<Integer> list){
        if (list.first == null) throw new NoSuchElementException("given list is empty");

        MyLinkedList<Integer>.Node node1 = list.first;
        MyLinkedList<Integer>.Node middle = list.first;

        while (node1 != list.last && node1.next != list.last){
            node1 = node1.next.next;
            middle = middle.next;
        }

        if (node1 == list.last) return "middle element = " + middle.value;
        else return "middle elements = " + middle.value + " and " +  middle.next.value;
    }
}
