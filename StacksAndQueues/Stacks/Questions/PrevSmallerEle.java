package StacksAndQueues.Stacks.Questions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class PrevSmallerEle {
    

    // find the nearest smaller element behind the element of an array
        // e.g. {4,7,1,2,4,3,6} ---> {-1,4,-1,1,2,2,3}

    // 1st approach - brute force
        // simply iterate backwards
        // find the first element smaller than the given ele;
        // add it to the result array.

    
    // 2nd approach using stacks
    public static int[] prevSmaller(int[] arr){

        int[] res = new int[arr.length];
        res[0] = -1;
        Stack<Integer> st = new Stack<>();

        for(int i =0; i< arr.length; i++){

            if(st.isEmpty()) {
                st.push(arr[i]);
            }
            else{

                while (!st.isEmpty() && st.peek() >= arr[i]) {
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i] = -1;
                    st.push(arr[i]);
                }
                else{
                    res[i] = st.peek();
                    st.push(arr[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
        int arr[] = {3,1,7,4,3,6,2,5};

        int ans[] = prevSmaller(arr);
        System.out.println(Arrays.toString(ans));
    }
    
}
