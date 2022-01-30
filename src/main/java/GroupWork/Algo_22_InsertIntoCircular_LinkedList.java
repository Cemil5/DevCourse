package GroupWork;

import DataStructure.LinkedList.OurLinkedList;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
[3,4,1,2]
Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to
the node with value 3, and we need to insert 2 into the list. The new node should be inserted between node 1
and node 3. After the insertion, the list should look like this, and we should still return node 3.
Example 2:
Input: head = [], insertVal = 1
Output: [1]
Explanation: The list is empty (given head is null). We create a new single circular list and return the reference
to that single node.
Example 3:
Input: head = [1], insertVal = 0
Output: [1,0]
 */
public class Algo_22_InsertIntoCircular_LinkedList {
    @DataProvider(name = "input")
    public Object[][] dataMethod() {
        OurLinkedList list = new OurLinkedList();
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(1);
        list.addLast(2);
        list.last.next = list.first;

        OurLinkedList list1 = new OurLinkedList();
        list1.addLast(2);

        return new Object[][]{
                    {list, 2},
                //     {new OurLinkedList(), 5},
               // {list1, 0},
        };
    }

    @Test(dataProvider = "input")
    public void test(OurLinkedList list, int insertVal) {
        list = myInsert(list, insertVal);

        OurLinkedList.Node cur = list.first;
        do {
            System.out.print(cur.value + ", ");
            cur = cur.next;
        } while (cur != list.first);
    }

    public OurLinkedList myInsert(OurLinkedList list, int insertVal) {  // my solution is good enough
        if (list.first == null || list.first.next == null) {
            list.addLast(insertVal);
            list.last.next = list.first;
            return list;
        }
        OurLinkedList.Node insert = new OurLinkedList.Node(insertVal);
        OurLinkedList.Node current = list.first;

        while (insert.value > current.next.value || insert.value < current.value) {
            current = current.next;
            if (current == list.first ) throw new IllegalArgumentException("given value can not be inserted in the middle");
        }
        OurLinkedList.Node temp = current.next;
        current.next = insert;
        insert.next = temp;

        return list;
    }
}
    /*
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }

        Node prev = head;
        Node curr = head.next;
        boolean insertPlaceFound = false;

        do {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                insertPlaceFound = true;
            } else if (prev.val > curr.val) {

                if (insertVal >= prev.val || insertVal <= curr.val)
                    insertPlaceFound = true;
            }//elseif

            if (insertPlaceFound) {
                prev.next = new Node(insertVal, curr);
                return head;
            } //endif

            prev = curr;
            curr = curr.next;

        } while (prev != head);

        prev.next = new Node(insertVal, curr);
        return head;
    }
}
