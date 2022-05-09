package groupWork;

import dataStructure.LinkedList.OurLinkedList;

/**
Question #18
Sum of Linked Lists
Difficulty : Easy Category :Linked Lists
You're given two Linked Lists of potentially unequal length. Each Linked List represents a
non-negative integer, where each node in the Linked List is a digit of that integer, and the
first node in each Linked List always represents the least significant digit of the integer.
Write a function that returns the head of a new Linked List that represents the sum of the
integers represented by the two input Linked Lists. Each LinkedList node has an integer value
as well as a next node pointing to the next node in the list or to None / null if it's the tail of
the list. The value of each LinkedList node is always in the range of 0 - 9 .
Note: your function must create and return a new Linked List, and you're not allowed to
modify either of the input Linked Lists.
Sample Input
linkedListOne = 2 -> 4 -> 7 -> 1 // represents 1742 as a number
linkedListTwo = 9 -> 4 -> 5
Sample Output
1 -> 9 -> 2 -> 2
// linkedListOne represents 1742
// linkedListTwo represents 549
// 1742 + 549 = 2291
 */
public class Algo_18_SumOfTwoLinkedList {
    public static void main(String[] args) {
        OurLinkedList list1 = new OurLinkedList();
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(7);
        list1.addLast(1);

        OurLinkedList list2 = new OurLinkedList();
        list2.addLast(9);
        list2.addLast(4);
        list2.addLast(5);

        list1.printLinkedList();
        list2.printLinkedList();

        mySum(list1, list2).printLinkedList();

    }

    // my solution
    static OurLinkedList mySum(OurLinkedList list1, OurLinkedList list2){   // good solution for me
        OurLinkedList result = new OurLinkedList();
        int temp = 0;

        OurLinkedList.Node c1 = list1.first;
        OurLinkedList.Node c2 = list2.first;
        while (c1 != null || c2 != null){
            int a1 = 0, a2 = 0;
            if (c1 != null){
                a1 = c1.value;
                c1 = c1.next;
            }
            if (c2 != null){
                a2 = c2.value;
                c2 = c2.next;
            }
            result.addLast((a1 + a2 + temp) % 10);
            temp = (a1 + a2) / 10;
        }
        return result;
    }

    public static OurLinkedList sumOfLinkedLists(OurLinkedList linkedListOne, OurLinkedList linkedListTwo) {

        OurLinkedList newLinkedList = new OurLinkedList();

        int carry = 0;//Elde için variable
        OurLinkedList.Node currentOne = linkedListOne.first;
        OurLinkedList.Node currentTwo = linkedListTwo.first;
        while (currentOne != null || currentTwo != null || carry != 0) {
            int valueOne = (currentOne != null) ? currentOne.value : 0;
            int valueTwo = (currentTwo != null) ? currentTwo.value : 0;
            int sumOfValues = valueOne + valueTwo + carry;
            int newValue = sumOfValues % 10; // toplamda aşağıya yazılan kalan değer,
            // ondalık kısmı ise elde oluyor
            newLinkedList.addLast(newValue);
            carry = sumOfValues / 10;// elde değeri toplamın ondalık basamağı
            currentOne = (currentOne != null) ? currentOne.next : null;
            currentTwo = (currentTwo != null) ? currentTwo.next : null;
        }
        newLinkedList.printLinkedList();
        return newLinkedList;
    }

    //    *************************************************************
    public OurLinkedList sumLists(OurLinkedList list1, OurLinkedList list2) {
        int totalSum = convertToInt(list1) + convertToInt(list2);
        return insertList(totalSum);
    }

    private int convertToInt(OurLinkedList list) {
        int sum = 0;
        OurLinkedList.Node current = list.first;
        for (int i = 1; current != null; i *= 10) {
            sum += current.value * i;
            current = current.next;
        }
        return sum;
    }

    private OurLinkedList insertList(int sum) {
        OurLinkedList list = new OurLinkedList();
        while (sum != 0) {
            list.addLast(sum % 10);
            sum /= 10;
        }
        return list;
    }

}
