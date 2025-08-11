package linkedList.Questions;

import linkedList.SinglyLL;
import linkedList.SinglyLL.Node;;

public class ReverseLL {
    

    // 1st approach is fairly simple
        // just copy all the elements in a stack
        // then copy all the values back to the list, by poping from the stack.
        // as per LIFO, the elements will be reversed to the list
    // not so optimal, but works
    // takes an extra space of O(N),
    // also just the reverses the list in terms of value



    // 2nd approach
        // sort in-place, without extra spaces
        // with a bunch of pointers
        // prev, curr, next

    static void reverseList(SinglyLL list){

        if(list.head == null || list.head.next == null) return;

        Node prev = null;
        Node curr = list.head;

        while (curr != null) {

            Node nextPtr = curr.next;       // tracking the next pointer
            curr.next = prev;

            prev = curr;
            curr = nextPtr;
        }

        
        // display,
            // not curr is at the last node, which is now the new head;

        while (prev != null) {
            System.out.print(prev.value + "-->");
            prev = prev.next;
        }
        System.out.print("END");
    }


    public static void main(String[] args) {
        
        SinglyLL list1 = new SinglyLL();

        list1.insertAtHead(1);
        list1.insertAtHead(2);
        list1.insertAtHead(3);
        list1.insertAtHead(4);
        list1.insertAtHead(5);

        list1.displayLL();

        reverseList(list1);
    }
    
}
