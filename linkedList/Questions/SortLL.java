package linkedList.Questions;

import linkedList.SinglyLL;
import linkedList.SinglyLL.Node;

public class SortLL {
    
    // 1st way is simple, bruteforce
        // copy the the values to an array
        // then sort it
        // copy the values back to the linked list
    // but takes extra space

    // another method is apply merge sort
        // sort the list to two halves.
        // recursive sort two halves
    // helper function to merge two sorted LL
    public static Node mergeSortedLists(Node head1, Node head2){

        Node temp1 = head1;
        Node temp2 = head2;

        SinglyLL mergedList = new SinglyLL();

        while (temp1 != null && temp2!=null) {
            
            if(temp1.value < temp2.value){
                mergedList.insertAtTail(temp1.value);
                temp1 = temp1.next;
            }
            else{
                mergedList.insertAtTail(temp2.value);
                temp2 = temp2.next;
            }

        }
        while (temp1 != null) {
            mergedList.insertAtTail(temp1.value);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            mergedList.insertAtTail(temp2.value);
            temp2 = temp2.next;
        }

        return mergedList.head;
        
    }
    // function to the get the middle of the list
    public static Node getmid(Node head) {
        
        Node slow = head;
        Node fast = head.next;     // to get the 1st middle in case of even no. of elements

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    } 


    // finally the main merge sort function
    public static Node MergeSortLL(Node head){

        if(head.next == null) return head;

        Node mid = getmid(head);
        Node rightHead = mid.next;
        // breaking list to two halves(necessary)
        mid.next = null;

        Node left = MergeSortLL(head);          // recursive divide left part
        Node right = MergeSortLL(rightHead);      // same for the right

        // finally, merge two sorted halves

        return mergeSortedLists(left, right);

    }


    public static void main(String args[]){

        SinglyLL list1 = new SinglyLL();
        list1.insertAtTail(2);
        list1.insertAtTail(5);
        list1.insertAtTail(4);
        list1.insertAtTail(3);
        list1.insertAtTail(6);
        list1.insertAtTail(1);



    }
    
}
