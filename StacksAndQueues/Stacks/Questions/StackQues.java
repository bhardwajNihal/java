package StacksAndQueues.Stacks.Questions;
import java.util.*;

import Arrays.sorting.insertionSort;
public class StackQues {
    

    static void displayReverseRecursively(Stack<Integer> st){

        if(st.isEmpty()) return;

        int popped = st.pop();
        System.out.print(popped + " ");
        displayReverseRecursively(st);
        st.push(popped);                    // as stacks are passed by reference, so to keep the original one intact, we have to repush the elements popped
    }

    static void insertAtbottomRecursively(Stack<Integer> st, int val){

        if(st.isEmpty()){
            st.push(val);
            return;
        }

        int popped = st.pop();
        insertAtbottomRecursively(st, val);
        st.push(popped);
    }

    static void insertAtposition(Stack<Integer> st, int val, int position){

        if(position<1 || position>st.size()+1){
            System.out.println("invalid position!");
            return;
        }
        int counter = 0;
        Stack<Integer> temp = new Stack<>();
        while (counter < st.size()-position+1) {
            temp.push(st.pop());
        }
        st.push(val);
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        
        // copy contents in same order

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);

        System.out.println(stack1);
        // displayReverseRecursively(stack1);
        // insertAtbottomRecursively(stack1, 99);

        insertAtposition(stack1, 99, 4);
        System.out.println(stack1);
        
        

        // copy stack1 items to temp, and then from temp to stack2 .. done
        // tc = O(N)
    
    // insert at the bottom of the stack
        // copy items to temp
        // push the value the original stack.
        // insert from temp again

        // while (!stack1.isEmpty()) {
        //     temp.push(stack1.pop());
        // }
        // stack1.push(100);

        // while (!temp.isEmpty()) {
        //     stack1.push(temp.pop());
        // }

        // System.out.println(stack1);

    }
}
