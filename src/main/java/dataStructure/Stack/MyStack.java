package dataStructure.Stack;

import java.util.NoSuchElementException;

public class MyStack {
    class Node {
        public char value;
        public Node next;

        public Node(char value) {
            this.value = value;
        }
    }

    public Node first;
    public Node last;
    public int size;

    public MyStack() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(char item){
        var node = new Node(item);
        System.out.println("adding an item : " + item);
        if (isEmpty()) { first  = last = node; }
        else {
            last.next = node;
            last = node;
        }
        size++;

    }
    public Character pop(){
        Node current = first;
        if (isEmpty()) throw new NoSuchElementException();
        System.out.println("deleting an item from the last: ");
        if (first == last) first = last = null;
        else {
            var previous = first;
            while (current.next!=null){
                previous = current;
                current = current.next;
            }
            previous.next = null;
            last = previous;
            size--;
        }
        return current.value;
    }

    public Character peek(){
        Node current = last;;
        if (isEmpty()) throw new NoSuchElementException();
        return current.value;
    }



}
