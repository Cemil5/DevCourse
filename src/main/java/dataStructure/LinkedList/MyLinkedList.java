package dataStructure.LinkedList;

public class MyLinkedList<T>{

    public class Node{
        Node next;
        T value;
        public Node(T value){
            this.value = value;
        }
    }

    Node first;
    Node last;

    public int size(){
        Node current = first;
        int size = 0;
        while (current != null){
            size++;
            current = current.next;
        }
        return size; }

    public boolean isEmpty(){
        return first == null;
    }

    public void addLast(T item){
        var node = new Node(item);
      //  System.out.println("adding an item : " + item);
        if (isEmpty()) first  = last = node;
        else {
            last.next = node;
            last = node;
        }
    }

    public void printLinkedList(){
        Node current = first;
        String comma = "LinkedList : ";
        while (current != null){
            System.out.print(comma + current.value);
            comma = ", ";
            current = current.next;
        }
        System.out.println();
    }

}
