package linkedList;

public class SinglyLL {

// defining private class node
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

// head, tail and size to track the linked list
    private Node head;
    private Node tail;
    private int size;

    // constructor to initialize the LL
    public SinglyLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // insertion methods
    public void insertAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) { // if head is null, LL is empty, simply point head & tail to this new node,
            head = newNode;
            tail = newNode;
            size += 1;
            return;
        }
        // else, new node's next is current head, and then head points to the new node
        newNode.next = head;
        head = newNode;
        size += 1;

    }

    public void insertAtTail(int val) {

        Node newNode = new Node(val);
        if (tail == null) { // if tail is null, LL is empty, simply perform insert at head
            insertAtHead(val);
            return;
        }
        tail.next = newNode; // else point tail's next to new node, then make new node as tail
        tail = newNode;
        size++;
    }

    public void insertAtPosition(int val, int position) {

        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(val);

        if (position == 1) {
            insertAtHead(val);
            return;
        }
        if (position == size) {
            insertAtTail(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next; // point temp to the previous node of the intended position
        }

        // point new node's next to temp's next
        newNode.next = temp.next;
        temp.next = newNode; // point temp's next to new node, insert successful
        size++;

    }

    // deletion methods
    public int deleteAtHead() {
        int valueRm = head.value;
        head = head.next;
        // if head now points to null, point tail to null as well
        if (head == null) {
            tail = null;
        }
        ;
        size--;
        return valueRm;
    }

    public int deleteAtTail() {

        if (size <= 1)
            return deleteAtHead();

        // 1st need a temp to point the 2nd last node
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        // now as temp points to 2nd last node;
        int valueRemoved = temp.next.value;
        temp.next = null; // last node removed
        size--;
        return valueRemoved;

    }

    public int deleteAtPosition(int position) {

        if (position < 1 || position > size) {
            System.out.println("Invalid position");
            return -1;
        }

        if (position == 1) {
            return deleteAtHead();
        }
        if (position == size) {
            return deleteAtTail();
        }

        Node temp = head;
        int count = 1;
        while (count < position - 1) {
            temp = temp.next;
            count++;
        }
        // now as temp is at the previous node of the intended node
        int valueRemoved = temp.next.value;
        temp.next = temp.next.next;
        size--;
        return valueRemoved;

    }

    public void displayLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }


    public static void main(String[] args) {

        SinglyLL myLL = new SinglyLL();
        myLL.insertAtHead(5);
        myLL.insertAtHead(6);
        myLL.insertAtHead(7);
        myLL.insertAtHead(8);

        myLL.insertAtTail(100);
        myLL.displayLL();

        myLL.insertAtPosition(99, 3);
        myLL.displayLL();
        System.out.println(myLL.size);

        // System.out.println("deletion at head");
        // System.out.println(myLL.deleteAtHead());
        // myLL.displayLL();
        // System.out.println(myLL.size);

        // System.out.println("deletion at tail");
        // System.out.println(myLL.deleteAtTail());
        // myLL.displayLL();
        // System.out.println(myLL.size);

        System.out.println("deletion at position 3");
        System.out.println(myLL.deleteAtPosition(3));
        myLL.displayLL();
        System.out.println(myLL.size);

    }
}
