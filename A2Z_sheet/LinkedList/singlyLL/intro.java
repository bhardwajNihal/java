package A2Z_sheet.LinkedList.singlyLL;

// linked list is a linear data structure
// each data point is acutually a node
    // a node consists
        // data
        // a reference to next node
    // singlyLL points towards only one direction, i.e a node points only to its next node


    // we define a node class
    // with attributes
        // int data
        // Node next --> custom data type to store next nodes address

    
    // basic node class definition
    class Node{

        int data;
        Node next;

        Node(int data){         //constructor, takes an int data, and initializes a node
            this.data = data;           
            this.next = null;
        }
    }


public class intro {

    public static void main(String[] args) {
        
        // now creating a linked list manually
        
        // initializing nodes 
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        // connecting them to form a Linked list
        n1.next = n2;
        n2.next = n3;

        System.out.println(n1.data);            // 1   
        System.out.println(n2.next.data);       // 3
        System.out.println(n3.next);            // null

        
        // diplaying entire ll 
        Node temp = n1;
        while (temp!=null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");

    }

}
