import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class SlidingWindowMax {
    

// given an array, give the max element in each k window
    public static int[] SLM(int[]arr, int k){

        // 1st brute force approach is simply iterate over all the array elements
        // and a nested loop for the size of k, 
        // find max of each window, store in the ans array
        // gives TLE in assessments


        // 2nd better approach
            // using next greater element approach
                // 2nd one using stack, utilizing next greater ele approach
            int[] nge = new int[arr.length];        // maintaining index of the next greater elements
            Stack<Integer> st = new Stack<>();
            for(int i = arr.length-1; i>=0; i--){

                while (!st.isEmpty() && arr[st.peek()]<arr[i]) {
                    st.pop();
                }
                if(st.isEmpty()){
                    nge[i] = arr.length;
                    st.push(i);
                }else{
                    nge[i] = st.peek();
                    st.push(i);
                }
            }

            // now we have the nge array
            int n = arr.length-k+1;
            int[] ans = new int[n];

            // filling the ans array with the desired ele
            for(int i = 0; i< n; i++){

                int j = i;              // everytime j starts with i, iterate till next k ele
                while (j < i+k) {
                if(nge[j] < i+k) j = nge[j];     // if nge of the current ele is within the window continue incrementing, once it goes outside, then the current position of j is the largest in the window
                else{                            
                    ans[i] = arr[j];       // if nge leaks assign ele at current index of j to the ans[j]
                    break;                  // break out of the inner loop, move to next window
                }
                }
            }         

            return ans;




        // 3rd, best optimal solution
            // using Deque

    }


    public static void main(String[] args) {
        
        int arr[] = {1,3,-1,-3,5,3,6,7};        // 3 3 5 5 6 7
        
        int ans[] = SLM(arr, 3);
    }
}
