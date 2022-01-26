package DataStructure.Canvas_Q_A;

import DataStructure.LinkedList.OurLinkedList;

public class LinkedList_Shift {

   /*
   Write a function that takes in the head of a Singly Linked List and an integer k, shifts the list
in place (i.e., doesn't create a brand new list) by k positions, and returns its new head.
Shifting a Linked List means moving its nodes forward or backward and wrapping them
around the list where appropriate. For example, shifting a Linked List forward by one
position would make its tail become the new head of the linked list. Whether nodes are
moved forward or backward is determined by whether k is positive or negative. Each
LinkedList node has an integer value as well as a next node pointing to the next node in the
list or to None / null if it's the tail of the list. You can assume that the input Linked List will
always have at least one node; in other words, the head will never be None / null.
    */

    public static void main(String[] args) {

        var list1 = new OurLinkedList();

        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
        list1.addLast(9);

        list1.shiftList(list1, -2);

    }

}
