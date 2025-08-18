package StacksAndQueues.Queues.Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReorderQueue {
    
    // given a queue --> 1 2 3 4 5 6 7 8
    // reordered --> 1 5 2 6 3 7 4 8
    // using a stack, 
        // simple approach

    public static void rotate(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        //1st pass  1 2 3 4 5 6 7 8 --> 5 6 7 8 4 3 2 1
        int size = q.size();
        for(int i = 0; i<size/2 ; i++){
            st.push(q.remove());
        }

        // now re add the stack ele to the queue
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
    }

    public static void reOrder(Queue<Integer> q){

        //1st pass : 1 2 3 4 5 6 7 8 --> 5 6 7 8 4 3 2 1
        rotate(q);

        System.out.println(q);
        // after 2nd pass :  --> 4 3 2 1 8 7 6 5
        rotate(q);

        System.out.println(q); 
        // after 3rd pass : 8 7 6 5 1 2 3 4 
        rotate(q);
        System.out.println(q);
        // now lastly add the 1st 4 to the stack
        Stack<Integer> st = new Stack<>();
        int size = q.size();
        for(int i = 0; i<size/2; i++){
            st.push(q.remove());
        }
        System.out.println(q);
        System.out.println(st);

        // now we have  q = 1 2 3 4
        // st = 5
        //      6
        //      7
        //      8           // ✅✅

        // we need to add in a specific order
        // 5 1  6 2  7 3 8 4 

        // can be achieved add to the que alternatively from stack and then q.front()

        while (!st.isEmpty()) {
            q.add(st.pop());
            q.add(q.remove());
        }
        System.out.println(q);

        // now we have ---> 5 1  6 2  7 3  8 4   // ✅✅✅
        
        
        // finally we have to add add 1st to ele to stack then back to queue, then next 2, and so on
        // simply add two elements to the stack and then to the queue on each iteration
        for(int i =0; i<size/2; i++){
                st.add(q.remove());
                st.add(q.remove());
                q.add(st.pop());
                q.add(st.pop());
        }
    }

    public static void main(String[] args) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        reOrder(q);
        System.out.println(q);

    }
}
