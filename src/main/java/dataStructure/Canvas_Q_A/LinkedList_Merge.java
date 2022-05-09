package dataStructure.Canvas_Q_A;

import dataStructure.LinkedList.OurLinkedList;

public class LinkedList_Merge {
    /*
   Write a function that takes in the heads of two Singly Linked Lists that are in sorted order,
respectively. The function should merge the lists in place (i.e., it shouldn't create a brand
new list) and return the head of the merged list; the merged list should be in sorted order.
Each LinkedList node has an integer value as well as a next node pointing to the next node in
the list or to None / null if it's the tail of the list. You can assume that the input linked lists
will always have at least one node; in other words, the heads will never be None / null.
    */
    public static void main(String[] args) {

        var list1 = new OurLinkedList();
        var list2 = new OurLinkedList();

        list1.addLast(0);
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(6);
        list1.addLast(8);

        list2.addLast(1);
        list2.addLast(3);
        list2.addLast(5);
        list2.addLast(7);
        list2.addLast(9);
        list2.addLast(11);
        list2.addLast(13);

        list1.mergeList(list1, list2);

        list1.printLinkedList();
    }

}
