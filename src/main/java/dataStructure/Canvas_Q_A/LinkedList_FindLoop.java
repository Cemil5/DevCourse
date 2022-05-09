package dataStructure.Canvas_Q_A;

import dataStructure.LinkedList.OurLinkedList;

public class LinkedList_FindLoop {

    /*
    Find Loop (Linked Lists)
This is a very classic interview question. Write a function that takes in the head of a Singly
Linked List that contains a loop (in other words, the list's tail node points to some node in
the list instead of None / null). The function should return the node (the actual node--not
just its value) from which the loop originates in constant space. Each LinkedList node has an
integer value as well as a next node pointing to the next node in the list.
     */

    public static void main(String[] args) {

        var list1 = new OurLinkedList();

    for (int i = 1; i <= 5; i++) {
            list1.addLast(i);
        }

        list1.last.next = list1.findingKthValueFromEnd(2);

        System.out.println(list1.findLoopOrigin().value);



    }

}
