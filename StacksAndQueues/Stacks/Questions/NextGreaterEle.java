package StacksAndQueues.Stacks.Questions;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterEle {
    
    // Find the next greater element of the array elements
    // e.g  {4,6,1,2,8,3} ----> {6,8,2,8,-1,-1}

    // 1st approach is simple, brute force, with time complexity ofO(N^2).
        // iterate over each element next to the current ele
        // if found greater element put it at the index, else -1;



    // 2nd : using stacks,
        // O(N)
        // maintain a stack of the next greater elements
        // for the last element the corresponding res arr's last index will be -1;
        // now loop through the array from reverse
        // if the stack is empty simply push arr[i] to it, mark res[i] -1;
        // now for each subsequent ele, in the original array, check if st.peek() is greater
            // if not, pop till the greater ele is found, if not, mark res[i]=-1, push arr[i] to the stack for further comparison
            // if found, then res[i] = stack.peek();

    public static int[] nextGreater(int[] arr){

        int[] res = new int[arr.length];
        res[arr.length-1] = -1;
        Stack<Integer> st = new Stack<>();

        for(int i = arr.length-1; i>=0; i--){

            if(st.isEmpty()) {
                st.push(arr[i]);
            }
            else{

                while (!st.isEmpty() && st.peek() <= arr[i]) {
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
        
        int arr[] = {1,2,2,2,2,2};

        int ans[] = nextGreater(arr);
        System.out.println(Arrays.toString(ans));
    }
}
