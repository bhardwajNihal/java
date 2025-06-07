package Arrays.sorting;

import java.util.Arrays;

public class insertionSort {
    
    public static void main(String[] args) {
        
         int[] arr = {5,4,3,2,1};
         insertionSortAlgo(arr);

         System.out.println(Arrays.toString(arr));
    }

    //Insertion sort
    // start from range of 2 element. gradually increase the range to cover entire array
    // compare current to the previous, if arr[j] < arr[j-1]  --> swap
    // repeat the process till the sub-array is sorted, then move to the another subarray with size +1;
    // Sort 1st two element, >> then 1st 3 element >> then 4, ... so on.

    // TC --> worst case O(N^2), best case --> O(n)

    static void insertionSortAlgo(int[] arr){

        // outer loop will go from 0 to the 2nd last element
        for(int i = 0; i < arr.length-1; i++){

            // inner loop will start from just i+1, will go reverse till j>=0
            for(int j = i+1; j>0; j--){

                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                else{
                    break;          // in any case if the previous element is lesser than current, this means the elements behind are already sorted, no need to further iterate
                }
            }
        }
    }
}
