package batch2_Questions;
/*
Tasks:
1. Implement a basic Singly LinkedList from scratch. Node class will hold an integer value as
data.
2. Implement an insert operation on the Singly LinkedList. Insert method will accept an
integer value and add this value to the LinkedList by creating a new node.
3. Implement a method that prints the LinkedList.
4. Explain how we can implement a delete operation with a value.
Discussion:
• Discuss the following complexities after you do the above task.
1. What is the complexity of insertion operation?
2. What would be the complexity of a delete operation with value?
Good luck!
 */

public class LinkedListBasic {

    private static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    Node first;
    Node last;

    public boolean isEmpty(){
        return first == null;
    }

    public void addLast(int value){
        Node node = new Node(value);
        if (isEmpty()){
            first = last = node;
        }
        last.next = node;
        last = last.next;
    }

    public void insertInOrder(int value){
        Node node = new Node(value);
        if (isEmpty()){
            first = last = node;
        } else {
            if (first.value > value){
                node.next = first;
                first = node;
            } else {
                Node current = first;
                while (current != last && current.next.value < node.value) {
                    current = current.next;
                }
                if (current == last){
                    current.next = node;
                    last = node;
                } else {
                    node.next = current.next;
                    current.next = node;
                }
            }
        }
    }

    public void print(){
        Node current = first;
        while (current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {

        LinkedListBasic listBasic = new LinkedListBasic();
        listBasic.addLast(5);
        listBasic.addLast(9);
        listBasic.insertInOrder(3);
        listBasic.insertInOrder(6);
        listBasic.insertInOrder(11);
        listBasic.print();


    }


}
