package groupWork;

import dataStructure.LinkedList.OurLinkedList;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
Question #19
Merge Two Sorted Lists
Difficulty : Easy Category :Linked Lists
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of
the first two lists.
Return the head of the merged linked list.
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:
Input: list1 = [], list2 = []
Output: []
Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */
public class Algo_19_MergeOfTwoLinkedList {

    @DataProvider(name = "input")
    public Object[][] dataMethod() {
        OurLinkedList list1 = new OurLinkedList();
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(5);

        OurLinkedList list2 = new OurLinkedList();
        list2.addLast(1);
        list2.addLast(6);
        list2.addLast(7);

        OurLinkedList list3 = new OurLinkedList();
        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(4);

        OurLinkedList list4 = new OurLinkedList();
        list4.addLast(1);
        list4.addLast(3);
        list4.addLast(4);

        OurLinkedList list5 = new OurLinkedList();
        list5.addLast(0);
        OurLinkedList list6 = null;
        return new Object[][]{
                {list1, list2},
                {list3, list4},
                {list5, new OurLinkedList()},
                {new OurLinkedList(), list5},
                {new OurLinkedList(), new OurLinkedList()},
        };
    }

    @Test(dataProvider = "input")
    public void test(OurLinkedList list1, OurLinkedList list2){
        mergeTwo(list1, list2).printLinkedList();
       // mergeTwoLists(list1.first, list2.first);
    }

    static OurLinkedList myMerge(OurLinkedList l1, OurLinkedList l2){
        if (l1.isEmpty() && l2.isEmpty()) return new OurLinkedList();
        else {
            if (l2.isEmpty()) return l1;
            if (l1.isEmpty()) return l2;
        }
        if (l2.first.value < l1.first.value) return myMerge(l2, l1);
        OurLinkedList.Node c1 = l1.first;
        OurLinkedList.Node c2 = l2.first;

        while (c1 != null){
            if ((c1.next != null && c2 != null) && (c1.next.value >= c2.value)) {
                OurLinkedList.Node temp = c1.next;
                c2 = c2.next;
                c1.next = l2.first;
                c1 = c1.next;
                c1.next = temp;
                l2.first = c2;
            } else {
                if ((c1.next != null && c2 != null) ) {
                    c1 = c1.next;
                } else if (c2 != null) {
                    c1.next = c2;
                    c2 = c2.next;
                } else c1 = c1.next;
            }
        }
        return l1;
    }

    static OurLinkedList mergeTwo(OurLinkedList l1, OurLinkedList l2){  // best solution for me
        OurLinkedList.Node prehead = new OurLinkedList.Node(-1);
        OurLinkedList.Node prev = prehead;
        OurLinkedList.Node c1 = l1.first;
        OurLinkedList.Node c2 = l2.first;
        while (c1 != null && c2 != null){
            if (c1.value <= c2.value){
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = c1 == null ? c2 : c1;
        l1.first = prehead.next;
        return l1;
    }

    static OurLinkedList myMerge2(OurLinkedList l1, OurLinkedList l2){
        OurLinkedList.Node c1 = l1.first;
        OurLinkedList.Node c2 = l2.first;
        if (l1.isEmpty()) return l2;
        if (l2.isEmpty()) return l1;
        OurLinkedList.Node c1prev = l1.first;

        while (c1 != null || c2 != null) {
            if ((c1 != null && c2 != null) && (c1.value >= c2.value)) {
                OurLinkedList.Node temp = c1;
                c2 = c2.next;
                if (c1 == l1.first) {
                    l1.first = l2.first;
                    l1.first.next = c1;
                } else {
                    c1 = l2.first;
                    c1prev.next = c1;
                    c1.next = temp;
                }
                l2.first = c2;
            } else {
                if ((c1 != null && c2 != null) && c1.value < c2.value) {
                    c1prev = c1;
                    c1 = c1.next;
                }
                else if (c2 != null) {
                    if (c1 == null) c1 = c2;
                    else c1.next = c2;
                    c1prev.next = c1;
                    c2 = c2.next;
                } else if (c1 != null)
                    c1 = c1.next;

            }
        }
        return l1;
    }


// Definition for singly-linked list.
  public static class Node {
      int val;
      Node next;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node next) { this.val = val; this.next = next; }
 }

    public Node mergeTwoLists(Node l1, Node l2) {
        // maintain an unchanging reference to node ahead of the return node.
        Node prehead = new Node(-1);

        Node prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

public Node mergeTwoLists2(Node list1, Node list2) {
    if (list1==null) return list2;
    else if (list2==null) return list1;
    Node current1 = list1;
    Node newPrev = null;
    Node current2 = list2;
    while (current1 != null && current2 != null) {
        if (current1.val < current2.val) {
            newPrev = current1;
            current1 = current1.next;
        } else {
            if (newPrev != null) newPrev.next =current2;
            newPrev = current2;
            current2 = current2.next;
            newPrev.next = current1;
        }
    }
    if (current1 == null) newPrev.next = current2;
    return list1.val < list2.val ? list1 : list2;
}


}
