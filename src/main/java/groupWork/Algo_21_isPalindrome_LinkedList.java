package groupWork;

import dataStructure.LinkedList.OurLinkedList;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
Question #21
Palindrome Linked List
Difficulty Easy Category :Linked Lists
Given the head of a singly linked list, return true if it is a palindrome.
Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false
 */
public class Algo_21_isPalindrome_LinkedList {
    @DataProvider(name = "input")
    public Object[][] dataMethod() {
        OurLinkedList list = new OurLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        OurLinkedList list1 = new OurLinkedList();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        return new Object[][]{
             //   {list, true},
                {list1, false},
                //    {list, -2},
        };
    }

    @Test(dataProvider = "input")
    public void test(OurLinkedList list, Boolean expected){
      //  reverse(list).printLinkedList();
        System.out.println(isPalindrome(list));

    }

    boolean isPalindrome(OurLinkedList list){
        OurLinkedList reversed = reverse(list);
        OurLinkedList.Node current = list.first;
        OurLinkedList.Node revCur = reversed.first;
        while (current != null){
            if (current.value != revCur.value) return false;
            current = current.next;
            revCur = revCur.next;
        }
        return true;
    }

    public static OurLinkedList reverse(OurLinkedList list) {
        OurLinkedList reversed = new OurLinkedList();
        OurLinkedList.Node prev = list.first;
        OurLinkedList.Node current = list.first.next;
        while (current != null) {
            OurLinkedList.Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        reversed.last = list.first;
        reversed.last.next = null;
        reversed.first = prev;
        return reversed;
    }
}
