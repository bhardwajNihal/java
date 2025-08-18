package StacksAndQueues.Stacks.Questions;

import java.util.Stack;

public class LargestRectangle {

    public static int LargestRectangleInHistogram(int[] heights){

        Stack<Integer> temp = new Stack<>();

        int[] ps = new int[heights.length];
        int[] ns = new int[heights.length];
        int n = heights.length;

        // calculating previous smaller elements
        for(int i=0;  i<n; i++){
              // comparing with >= covers edge cases of equal hieghts, only  on ps
                while (!temp.isEmpty() && heights[temp.peek()] >= heights[i]) {
                    temp.pop();
                }
                if(temp.isEmpty()){
                    ps[i] = -1;
                }
                else{
                    ps[i] = temp.peek();
                }
                temp.push(i);
            
        }

        // empty stack
        while (!temp.isEmpty()) {
            temp.pop();
        }

        // calculating next smaller elements
        for(int i = heights.length-1 ; i>=0; i--){
            
                while (!temp.isEmpty() && heights[temp.peek()] > heights[i]) {
                    temp.pop();
                }
                if(temp.isEmpty()){
                    ns[i] = heights.length;
                }
                else{
                    ns[i] = temp.peek();
                }
                temp.push(i);
            
        }

        // now we have both the next and prev smaller array

        // calculate the max area possble for each hieghts, 
        // maintain the max, each time calculate the area, update max if greater.
        int max = 0;
        for(int i = 0; i<heights.length; i++){
            int area = ((ns[i] - ps[i]) - 1) * heights[i];
            max = Integer.max(max, area);
        }

        return max;

    }


    public static void main(String[] args) {
        
        int[] h = {5,2,4,6,3,5};
        int maxArea = LargestRectangleInHistogram(h);
        System.out.println(maxArea);
    }
}
