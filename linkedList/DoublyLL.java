package linkedList;

public class DoublyLL {

    // a doubly linked list node references to both of its neibourhood nodes
    private class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    // defining head tail and size to track the LL
    Node head;
    Node tail;
    int size;

    // constructor initialize the LL
    DoublyLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // insertion operations
    public void insertAtHead(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void insertAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insertAtPosition(int val, int position) {
        Node newNode = new Node(val);

        if (position == 1) {
            insertAtHead(val);
            return;
        }

        if (head == null) {
            System.out.println("LL empty!");
            return;
        }

        Node temp = head;

        int count = 1;
        while (count <= position - 2) {
            if (temp == null) {
                System.out.println("invalid position!");
                return;
            }
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            insertAtTail(val);
            return;
        }

        // simply connect now
        newNode.next = temp.next;
        temp.next.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
        size++;

    }

    // deletion operations
    public void deleteAtHead() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            tail = null;
            size = 0;
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteAtTail() {
        if (tail == null) {
            return; // ll is empty
        }
        if (tail == head) {
            head = null;
            tail = null;
            size = 0;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void deleteAtPosition(int position) {

        if (position < 1 || position > size) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            deleteAtHead();
            return;
        }

        if (head == null)
            return;

        Node temp = head;

        int count = 1;
        while (count <= position - 2) {
            if (temp == null) {
                System.out.println("Invalid position!");
                return;
            }
            temp = temp.next;
            count++;
        }

        // only for position = size+1, will the temp.next=null
        // which is already tackled above

        if (temp.next.next == null) {       // if temp comes to the 2nd last node, means last node is to be deleted
            deleteAtTail();
            return;
        }

        // simply isolate the node at given position
        temp.next.next.prev = temp;
        temp.next = temp.next.next;
        size--;
    }

    public void display() {
        Node temp = head;

        System.out.print("START <--> ");
        while (temp != null) {
            System.out.print(temp.val + " <--> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public static void main(String args[]) {

        DoublyLL list = new DoublyLL();

        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(4);

        list.insertAtTail(100);
        list.insertAtPosition(500, 1);

        list.deleteAtHead();
        list.deleteAtTail();
        list.deleteAtPosition(1);
        list.display();

    }

}
