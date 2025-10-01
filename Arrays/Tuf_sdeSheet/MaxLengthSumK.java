package Arrays.Tuf_sdeSheet;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthSumK {
    

    // given an array
    // we have to return length of the max length subarray with the given sum K
    // {1,3,2,1,1,1,5}
        // here for K = 5;
        // possible subarrays with sum 5 ---> {3,2}, {2,1,1,1}, {5}
        // ans = 4 (length of 2nd subarray);


    // 1st approach - brute force
    // generate every possible subarray 
    // check for sum, if == k, calculate the length of the subarray, 
    // keep track of the max length
    // tc = O(N^3), sc=O(1)
        public static int maxLengthSubArray_brute(int[] arr,  int K){
            int length = 0;
            for(int i =0; i< arr.length-1; i++){
                for(int j = i; j<arr.length; j++){
                    int sum = 0;
                    // third loop to iterate from i to j, calculate sum, keep track of length
                    for(int k=i; k<=j; k++){
                        sum += arr[k];
                    }
                    if(sum == K){
                        // compare and update length
                        length = Integer.max(length, j-i+1);      // j-i=1 gives the length of current subarray
                    }
                }
            }
            return length;
        }

    
    // O(N^2) approach for the brute
        // based on an observation
        // sum for every successive subarray can be calculated by adding just the current ele to the previous sum
        // no need to iterate from start to the end of it, thus no need for third loop
        public static int maxLengthSubArray_better(int[] arr,  int K){
            int length = 0;
            for(int i =0; i< arr.length-1; i++){
                int sum = 0;
                for(int j = i; j<arr.length; j++){ 
                    sum += arr[j];

                    if(sum==K){
                        length = Integer.max(length, j-i+1);
                    }
                }
            }
            return length;
        }



    // public static int maxLengthSubArray_optimal(int[] arr, int K){

    // }

    public static void main(String[] args) {
        int arr[] = {1,3,2,1,1,1,5};
        System.out.println(maxLengthSubArray_better(arr, 5));

    }
}
