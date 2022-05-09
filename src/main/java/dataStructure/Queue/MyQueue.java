package dataStructure.Queue;

import java.util.NoSuchElementException;

public class MyQueue {
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

    public MyQueue() {
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
    public Character enqueue(){
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
        if (isEmpty()) throw new NoSuchElementException();
        return first.value;
    }

    public Character dequeue(){
        if (isEmpty()) throw new NoSuchElementException();
        System.out.println("deleting an item from the front : ");
        var current = first;
        if (first == last) first = last = null;
        else {
                first = first.next;
            }
            size--;
        return current.value;
    }

    public int size(){
        return size;
    }

}
