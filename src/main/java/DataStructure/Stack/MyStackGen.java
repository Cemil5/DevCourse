package DataStructure.Stack;

import java.util.ArrayList;

public class  MyStackGen <E> {

    ArrayList<Integer> arraysList;
    class Node {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() { return value; }

        public void setValue(E value) { this.value = value;  }

        public Node getNext() { return next;  }

        public void setNext(Node next) { this.next = next; }
    }

    private Node bottom;
    private Node top;
    private int size;

    public MyStackGen() {
        this.bottom = null;
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return bottom == null;
    }

    public void push(E item){
        var node = new Node(item);
      //  System.out.println("adding an item : " + item);
        if (isEmpty()) { bottom = top = node; }
        else {
            top.next = node;
            top = node;
        }
        size++;

    }
    public E pop(){
        Node current = bottom;
     //   System.out.println("deleting an item from the last: ");
        if (bottom == top) bottom = top = null;
        else {
            var previous = bottom;
            while (current.next!=null){
                previous = current;
                current = current.next;
            }
            previous.next = null;
            top = previous;
            size--;
        }
        return current.value;
    }

    public E peek(){
        return top.value;
    }

    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        var current = bottom;
        var i = 0;
        while (current != null){
            array[i++] = current.value;
            current = current.next;
        }
        return array;
    }


}
