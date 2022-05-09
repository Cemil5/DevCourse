package groupWork;

import dataStructure.LinkedList.OurLinkedList;

/**
Question # 17
Description: Remove Duplicates From Linked List
Difficulty: Easy Category: Linked Lists
You're given the head of a Singly Linked List whose nodes are in sorted order with respect to
their values. Write a function that returns a modified version of the Linked List that doesn't
contain any nodes with duplicate values. The Linked List should be modified in place (i.e.,
you shouldn't create a brand-new list), and the modified Linked List should still have its
nodes sorted with respect to their values. Each LinkedList node has an integer value as well
as a next node pointing to the next node in the list or to None / null if it's the tail of the list.
Sample Input
linkedList = 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 // the head node with value 1
Sample Output 1 -> 3 -> 4 -> 5 -> 6 // the head node with value 1
 */
public class Algo_17_RemoveDuplicatesFromLinkedList {
    public static void main(String[] args) {

        OurLinkedList list = new OurLinkedList();
        list.addLast(1);
        list.addLast(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(6);

        list.printLinkedList();
        OurLinkedList.Node current = list.first;
        while (current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
            } else
                current = current.next;
        }
        System.out.println("new list: ");
        list.printLinkedList();



    }
}
