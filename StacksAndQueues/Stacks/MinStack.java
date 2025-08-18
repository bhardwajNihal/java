package StacksAndQueues.Stacks;

import java.util.Stack;

// stack having a method minVal, that return the minimum value of the stack

// 1st approach is great, but uses extra space of O(N);
public class MinStack {
    
    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty()){
            min.push(val);
        }
        else{
            min.push(Integer.min(val,min.peek()));
        }
    }
    
    public void pop() {
        min.pop();
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }

}
