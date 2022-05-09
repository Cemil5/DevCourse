package dataStructure.LinkedList;

public class ReverseList {

    //   Reversing the nodes of a singly linked lists in one pass.

     /* Given pointer to the head node of a linked list, the task is to reverse the linked list.
    We need to reverse the list by changing the links between nodes.
    /* Function to reverse the linked list */

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

        System.out.println("Reversed linked list1 ");
        list1 = groupWork.Algo_21_isPalindrome_LinkedList.reverse(list1);
        list1.printLinkedList();

    }
}
