package DataStructure.LinkedList;

// optional exercise
// Check the singly linked list1 if it is Palindrome (Without a stack)

public class _isPalindromeTest {
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

    System.out.println("is palindrome : " + list1.isPalindrome());

    }
}
