package DataStructure.LinkedList;

import java.util.NoSuchElementException;

public class OurLinkedList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node first;
    public Node last;

    public OurLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        Node current = first;
        int size = 0;
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }

    public void addLast(int item){
        var node = new Node(item);
     //   System.out.println("adding an item : " + item);
        if (isEmpty()) first  = last = node;
        else {
            last.next = node;
            last = node;
        }
    }

    public void insertInOrder(int item) {
        var node = new Node(item);
        Node current = first;
        if (isEmpty()) first = last = node;
        else if (item < first.value) {
            node.next = first;
            first = node;
        } else {
            while (current != last && item > current.next.value ) {
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

    public void myinsertInOrder(int item) {
        var node = new Node(item);
        Node current = first.next;
        Node prev = null;
        if (isEmpty()) first = last = node;
        else if (item < first.value) {
            node.next = first;
            first = node;
        } else {
            while (item >= current.value && current != last) {
                prev = current;
                current = current.next;
            }
            if (current != last) {
                Node temp = current;
                current = node;
                node.next = temp;
                prev.next = node;
            } else {
                last.next = node;
                last = node;
            }
        }
    }

    public void deleteLast(){
        if (isEmpty()) throw new NoSuchElementException();
        System.out.println("deleting an item from the last: ");
        if (first == last) first = last = null;
        else {
            var previous = first;
            var current = first;
            while (current.next!=null){
                previous = current;
                current = current.next;
            }
            previous.next = null;
            last = previous;
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

    public Node findingKthValueFromEnd(int k){
        if (isEmpty()) throw new NoSuchElementException();

        Node node1 = first;
        Node node2 = first;
        while (k>1 || node1.next != null){
            node1 = node1.next;
            if (k>1){
                if (node1 == null) throw new IllegalArgumentException();
                k--;
            }
            else {
                node2 = node2.next;
            }
        }
        return  node2;
    }

    public void findMiddleElement(){
        if (first == null) throw new NoSuchElementException("given list is empty");

        Node node1 = first;
        Node middle = first;

        while (node1 != last && node1.next != last){
            node1 = node1.next.next;
            middle = middle.next;
        }

        if (node1 == last){
            System.out.println("middle element = " + middle.value);
        } else {
            System.out.println("middle elements = " + middle.value + " and " +  middle.next.value);
        }
    }

    public void MyFindMiddleElement(){
        if (first == null) throw new NoSuchElementException();

        Node node1 = first;
        Node middle = first;
        Node middleEven = null;
        int size = 1;

        while (node1.next != null){
            node1 = node1.next;
            middleEven = middle;
            middle = middle.next;
            size++;
            if (node1.next != null){
                node1 = node1.next;
                size++;
            }
        }
        System.out.println("size = " + size);
        if (size % 2 != 0){
            System.out.println("middle element = " + middle.value);
        } else {
            System.out.println("middle elements = " + middleEven.value + " and " +  middle.value);
        }
    }


    public Node findLoopOrigin(){
        if (isEmpty()) throw new IllegalArgumentException("no list");
        Node slow = first.next, fast = first.next.next;

        while (fast.next.next !=null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = first;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public OurLinkedList mergeList(OurLinkedList list1, OurLinkedList list2){

        Node current1 = list1.first;
        Node current2 = list2.first;
        Node temp;

        while (current2 != null) {
            if (current1.next == null || current1.next.value > current2.value) {
                temp = current1.next;
                current1.next = new Node(current2.value);
                current1 = current1.next;
                current1.next = temp;
                if (temp == null) list1.last = current1;
                current2 = current2.next;
            } else current1 = current1.next;
        }
        return list1;
    }

    public OurLinkedList shiftList(OurLinkedList list, int k){
        Node newLast;
        if (k>0) newLast = list.findingKthValueFromEnd(k+1);
        else {
            Node current = list.first;
            for (int i=1; i< (-k); i++){
                current = current.next;
            }
            newLast = current;
        }

        Node newFirst = newLast.next;

        newLast.next = null;
        last.next = first;
        first = newFirst;
        last = newLast;
      //  list.printLinkedList();
        return list;
    }

    public static Node shiftLinkedList(Node head, int k) {
        int listLength = 1;
        Node listTail = head;
        while (listTail.next != null) {
            listTail = listTail.next;
            listLength++;
        }
        int offset = Math.abs(k) % listLength;
        if (offset == 0) return head;
        int newTailPosition = k > 0 ? listLength - offset : offset;
        Node newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null;
        listTail.next = head;
        return newHead;
    }


    public OurLinkedList sortDescending(OurLinkedList list) {
        list.printLinkedList();
        Node current = list.first;
        Node node = list.first;
        Node prev = list.first;;
        OurLinkedList result = new OurLinkedList();
        int max = list.first.value;
        int size = size();
        while (size > 1) {
            while (current.next != null) {
                if (max < current.next.value) {
                    max = current.next.value;
                    node = current.next;
                    prev = current;
                }
                current = current.next;
            }

            prev.next = node.next;
            result.addLast(max);
            size--;

            if (max == list.first.value) {
                list.first = list.first.next;
            }
            current = list.first;
            max = list.first.value;
        }
        result.addLast(list.first.value);
        list.first = null;

     //   list.printLinkedList();
     //   result.printLinkedList();
        return result;
    }

}
