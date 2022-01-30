package GroupWork;

import DataStructure.LinkedList.OurLinkedList;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
Question #20
Shift Linked List
Difficulty Hard Category :Linked Lists
Write a function that takes in the head of a Singly Linked List and an integer k , shifts the list in
place (i.e., doesn't create a brand-new list) by k positions, and returns its new head. Shifting a
Linked List means moving its nodes forward or backward and wrapping them around the list
where appropriate. For example, shifting a Linked List forward by one position would make its tail
become the new head of the linked list. Whether nodes are moved forward or backward is
determined by whether k is positive or negative. Each LinkedList node has an integer value as well
as a next node pointing to the next node in the list or to None / null if it's the tail of the list. You
can assume that the input Linked List will always have at least one node; in other words, the head
will never be None / null .
Sample Input
head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0 k = 2
Sample Output
4 -> 5 -> 0 -> 1 -> 2 -> 3 // the new head node with value 4
 */

public class Algo_20_Shift_LinkedList {
    @DataProvider(name = "input")
    public Object[][] dataMethod() {
        OurLinkedList list = new OurLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        return new Object[][]{
                {list, 2},
            //    {list, 4},
            //    {list, -2},
        };
    }

    @Test(dataProvider = "input")
    public void test(OurLinkedList list1, int k){
        myShiftList(list1, k).printLinkedList();    // sends the latest list as an argument
     //   shiftLinkedList(list1, k).printLinkedList();    // doesn't work for backward shift
    }

    OurLinkedList myShiftList(OurLinkedList list, int k){   // best solution for me
        OurLinkedList.Node p1 = list.first;
        OurLinkedList.Node p2 = list.first;
        if (k>=0) {
            for (int i = 1; i <= k; i++) {
                p2 = p2.next;
            }
            while (p2.next != null){
                p1 = p1.next;
                p2 = p2.next;
            }
        } else {
            k = -k;
            for (int i = 1; i < k; i++) {
                p1 = p1.next;
            }
        }
        p2 = p1.next;
        list.last.next = list.first;
        list.last = p1;
        list.last.next = null;
        list.first = p2;
        return list;
    }



    public static OurLinkedList shiftLinkedList(OurLinkedList linkedList, int k){
        if (k==0) return linkedList;
        else if (k>0) {
            OurLinkedList.Node startNode= linkedList.first;
            OurLinkedList.Node endNode=null;
            OurLinkedList.Node current=linkedList.first;
            int i=0;
            while (i<k && current!=null){
                endNode=current;
                current=current.next;
                i++;}
            OurLinkedList.Node prevNode= linkedList.first;
            while(endNode.next!=null){
                prevNode=startNode;
                startNode=startNode.next;
                endNode=endNode.next;
            }
            prevNode.next=null;
            linkedList.last=prevNode;
            endNode.next= linkedList.first;
            linkedList.first=startNode;
            return linkedList;
        }
        else {return linkedList;}
    }

}
