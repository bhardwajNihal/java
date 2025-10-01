package linkedList.Questions;

import linkedList.SinglyLL;

public class removeDuplicates extends SinglyLL {

    public void removeDuplicatesfn(){

    // thought of it from 1st principles, fails at certain inputs but yeah, thought it raw
        // int dup = head.value;
        // int index = 0;
        // Node temp = head;

        // while(temp.next != null){

        //     if(temp.next.value == dup){

        //         if(index ==0) {
        //             temp = temp.next;
        //             this.deleteAtHead();
        //             index++;
        //         }
        //         else{
        //             temp = temp.next;
        //             this.deleteAtPosition(index);
        //             index++;
        //         }
        //     }
        //     else{
        //         dup = temp.next.value;
        //         temp = temp.next;
        //         index++;
        //     }
        // }


//     sol : Each time a duplicate is found:
        // removing it from the chain
        // The link to it is cut off
        // That node becomes unreachable ⇒ GC will collect it
        // temp points at node, manipulates it
        Node temp = head;
        while (temp!=null && temp.next!=null) {
            if(temp.value == temp.next.value){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        
        removeDuplicates list = new removeDuplicates();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(2);
        list.insertAtTail(2); 
        list.insertAtTail(2);

        System.out.println("before");
        list.displayLL();

        System.out.println("after");
        list.removeDuplicatesfn();
        list.displayLL();


    }


}
