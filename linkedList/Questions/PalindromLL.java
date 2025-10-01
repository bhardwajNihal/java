package linkedList.Questions;
import linkedList.Questions.*;
import java.util.ArrayList;

import linkedList.SinglyLL.Node;

public class PalindromLL {

    
    // brute force approach
    // simple - copy values to the the arraylist
    // again compare the list values to the arraylist values in reverse order
    // takes extra space
     public boolean isPalindrome(Node head) {
        
        ArrayList<Integer> arr = new ArrayList<>();

        Node temp = head;
        while(temp != null){
            arr.add(temp.value);
            temp = temp.next;
        }


        temp = head;
        for(int i = arr.size()-1; i>=0; i--){
            if(arr.get(i) != temp.value) return false;
            temp = temp.next;
        }

        return true;
    }


    
    // 2nd approach without using extra space
    // reverse the 2nd half of the list,
    // take two pointers one at the head and another at the mid.next
    // start comparing the pointers, if all matches return true, else false ;

    //helper
        public static Node getmid(Node head) {

            Node slow = head;
            Node fast = head.next;     // to get the 1st middle in case of even no. of elements

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        } 


// leet code 234.
    // public boolean isPalindrome(ListNode head) {
        
    //     if(head == null || head.next == null) return true;       // for empty, or 1 node, return true

    //     ListNode mid = getmid(head);                     // find mid
    //     ListNode secondHalf = reverseList(mid.next);     // reverse from mid
    //     mid.next = null;                                 // break the list

    //     ListNode p1 = head;                  // track both the halves
    //     ListNode p2 = secondHalf;
    //     while (p2 != null) {
    //     if (p1.val != p2.val) return false;
    //     p1 = p1.next;
    //     p2 = p2.next;
    // }

    //     return true;
    // }


}
