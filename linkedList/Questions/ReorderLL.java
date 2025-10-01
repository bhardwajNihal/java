package linkedList.Questions;
import linkedList.SinglyLL.Node;
public class ReorderLL {
    
    // leetcode 143: reorder linked list
        // reverse the 2nd half
        // add sequentially
        
    public static Node reverseList(Node head) {
        
        Node prev = null;
        Node curr = head;

        while(curr != null){

            Node Next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = Next;
        }

        return prev;

    }

    public static Node getmid(Node head) {

            Node slow = head;
            Node fast = head.next;     // to get the 1st middle in case of even no. of elements

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        } 


    public void reorderList(Node head) {

        if(head == null || head.next == null) return;

        Node mid = getmid(head);
        Node reversed = reverseList(mid.next);
        mid.next = null;

        Node hf = head;
        Node hs = reversed;


        while(hf != null && hs !=null){

            Node temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;

        }

    }
}

