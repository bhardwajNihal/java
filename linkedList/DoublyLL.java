package linkedList;

public class DoublyLL {

// a doubly linked list node references to both of its neibourhood nodes
private class Node {
    int val;
    Node next;
    Node prev;

    Node(int val){
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
    DoublyLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

// insertion operations 

    public void insertAtHead(int val){
        Node newNode = new Node(val);

        if(head==null){
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

    public void insertAtTail(int val){
        Node newNode = new Node(val);
        if(tail==null){
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

    public void insertAtPosition(int val, int position){
        Node newNode = new Node(val);

        if(position==1){
            insertAtHead(val);
            return;
        }

        if(head ==null){
            System.out.println("LL empty!");
            return;
        }
        Node temp = head;

        int count=1;
        while(count<=position-2){
            if(temp==null || temp.next==null){
                System.out.println("invalid postion!");
                return;
            }
            temp = temp.next;
            count++;
        }

        // now as temp reach to the previous node of the disired postion
        if(temp.next == null){
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


    public void display(){
        Node temp = head;

        System.out.print("START <--> ");
        while(temp!=null){
            System.out.print(temp.val + " <--> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public static void main(String args[]){

        DoublyLL list = new DoublyLL();

        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(4);

        list.insertAtTail(100);
        list.insertAtPosition(500,6);

        list.display();

    }

}
