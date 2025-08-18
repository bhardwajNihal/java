package StacksAndQueues.Queues.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class ImpStacksUsingQueue {
    Queue<Integer> que;

    public ImpStacksUsingQueue() {
        this.que = new LinkedList<>();
    }
    
    public void push(int x) {
        que.add(x);
        for(int i =0; i< que.size()-1; i++){    // while(!que.size()>1) loop was a mistake, as size is unchanged 
            que.add(que.remove());                // exposing the last to front
        }
    }
    
    public int pop() {
        return que.remove();
    }
    
    public int top() {
       return que.peek();

    }
    
    public boolean empty() {
    return que.isEmpty();
    }
}
