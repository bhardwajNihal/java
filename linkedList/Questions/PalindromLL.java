package linkedList.Questions;

import java.util.ArrayList;

import linkedList.SinglyLL.Node;

public class PalindromLL {

    
    // brute force approach
    // simple - copy values to the the arraylist
    // again compare the list values to the arraylist values in reverse order
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
}
