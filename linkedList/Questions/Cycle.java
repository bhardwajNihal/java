import org.w3c.dom.Node;

import linkedList.SinglyLL;

// leetcode 141, check for cycle in the linked list
// take two pointers, both pointing at head initially, 
// move 1st be 1 step, 2nd with 2

// if they meet , then true
// else if fast points to null at any given point , then false
public class Cycle extends SinglyLL {

    static boolean checkCycle(SinglyLL list) {
        Node p1 = list.head;
        Node p2 = list.head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    // to count the length of the cycle
    // just start a counter when they meet
    // and count after how many steps the slow pointer meets the fast again.
    // that's it



    // leetcode 142: find the start of the loop
        // public class Solution {
        //     public ListNode detectCycle(ListNode head) {

        //         ListNode slow = head;
        //         ListNode fast = head;

        //         // find the loop
        //         while (fast != null && fast.next != null) {

        //             slow = slow.next;
        //             fast = fast.next.next;

        //             if (fast == slow) {
        //                 // here logic to find the start of the loop
        //                 // if loop is found
        //                 // move slow pointer to head;
        //                 slow = head;

        //                 // till they meet, move both by 1 step
        //                 while (slow != fast) {
        //                     slow = slow.next;
        //                     fast = fast.next;
        //                 } // the point where they meed is surely the start of the loop

        //                 // finally return either of slow or fast, this is the start of the loop
        //                 return slow;
        //             }
        //         }
        //         // if loop not found
        //         return null;
        //     }
        // }

}




//leetcode 202.
// check for happy number
    // public boolean isHappy(int n) {
            
    //         // check for the cycle, if it exists then its not a happy number, as the squares are repeating after a point, and 1 is never reached;

    //         // maintain an array of previous values
    //         // at each point check if the value is already in the array, if so return false, else return true
    //         ArrayList<Integer> list = new ArrayList<>();


    //         // next num 
    //         int temp = n;
    //         // maintain sum of squares
    //         int sum = 0;

    //         while(true){
                
    //             while(temp > 0){
    //                 int digit = temp%10;
    //                 sum += digit*digit;
    //                 temp /= 10;
    //             }

    //             if(sum == 1) return true;
    //             if(list.contains(sum)) return false; 

    //             list.add(sum);
    //             temp = sum;
    //             sum = 0;
    //         }
    //     }




// leedcode 876: middle of a Linkedlist
    // public ListNode middleNode(ListNode head) {

    //     // 1st approach is simple, calculate length, and then reach the mid node, return it. easy straight forward   
    //         // count the total length
    //             // ListNode temp = head;
    //             // int count = 0;
    //             // while(temp != null){
    //             //     temp = temp.next;
    //             //     count++;
    //             // }
    //             // // now return the mid node
    //             // int counter = 0;
    //             // ListNode temp2 = head;
    //             // while(counter < count/2){
    //             //     temp2 = temp2.next;
    //             //     counter++;
    //             // }

    //             // return temp2;


    //     // 2nd approach
    //     // use of fast and slow pointer, when the fast pointer is null
    //     // the slow point is always at the mid
    //         ListNode fast = head;
    //         ListNode slow = head;

    //         while(fast != null && fast.next != null){
    //             fast = fast.next.next;
    //             slow = slow.next;
    //         }
    //         return slow;
        
        
    //     }
