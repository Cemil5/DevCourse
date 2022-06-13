package phoneProblem;

import java.util.ArrayList;

public class PhoneBook {

    PNode head;
    PNode tail;
    int size;

    public PhoneBook() {
    }

    public void add(String firstName, String lastName, String email, String phoneNumber) {
        PNode newNode = new PNode(firstName, lastName, email, phoneNumber);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;

    }

    public PNode findByName(String firstName) throws Exception {

        PNode current = head;
        while (current != null) {
            if (current.firstName.equals(firstName)) {
                return current;
            }
            current = current.next;
        }
        throw new Exception("no such element");
    }

    public ArrayList<PNode> findAllByLastName(String lastName) throws Exception {
        ArrayList<PNode> list = new ArrayList<>();
        PNode current = head;
        while (current != null) {
            if (current.lastName.equals(lastName)) {
                list.add(current);
            }
            current = current.next;
        }
        return list;
    }

    public void deleteByLastName(String lastName) {
        PNode current = head;
        PNode previous = head;

        if (isEmpty())
            throw new RuntimeException("Phone Book is empty.");

        while (current != null) {
            if (current.lastName.equals(lastName)) {
                if (current == head) {
                    if (size == 1) {
                        head = tail = null;
                    } else {
                        head = current.next;
                        current.next = null;
                    }
                } else if (current == tail) {
                    tail = previous;
                    previous.next = null;
                } else {
                    previous.next = current.next;
                    current.next = null;
                }
                size--;
            }
            previous = current;
            current = current.next;
        }
    }

    public void deleteAllMatchingLastName(String lastName) {
        PNode current = head;
        PNode previous = head;

        if (isEmpty())
            throw new RuntimeException("Phone Book is empty.");

        boolean isDeleted = false;
        while (current != null) {
            if (current.lastName.equals(lastName)) {
                if (current == head) {
                    if (size == 1) {
                        head = tail = null;
                    } else {
                        head = current.next;
                        previous = head;
                        current.next = null;
                    }
                } else if (current == tail) {
                    tail = previous;
                    previous.next = null;
                } else {
                    previous.next = current.next;
                    current.next = null;
                }
                size--;
                isDeleted = true;
            }
            if (isDeleted) {
                current = previous.next;
                isDeleted = false;
            } else {
                previous = current;
                current = current.next;
            }
        }
    }

    public void printNodes() {
        PNode current = head;

        while (current != null) {
            System.out.print(current.firstName + "=>");
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}

