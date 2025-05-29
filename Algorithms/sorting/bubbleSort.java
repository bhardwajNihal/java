package Algorithms.sorting;

import java.util.Arrays;

public class bubbleSort {

    public static void main(String[] args) {
        
        // int[] arr = {5,2,3,17,6,1,0};
        int[] arr = {6,5,4,3,2,1};
        bubbleSortAlgo(arr);

        System.out.println(Arrays.toString(arr));

    }


    // Bubble sort
    // compare each adjacent element, swap if previous element is greater
    // in worst case : n rounds
        // in each round, the ith largest element shifts to its correct spot
        // in subsequent rounds, the sorted part in ignored for comparison

    // TC --> O(N^2), best case : complexity of N, SC: O(1);
    // stable

    static void bubbleSortAlgo(int[] arr){

        for(int i = 0; i<arr.length; i++){    

            // check if any swap even happened, if not, the array is sorted, no need to waste compute
            // exit the loop
            boolean swapped = false;

            for(int j=1 ; j<arr.length-i; j++ ){        // inner loop from 2nd element till last - i

                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;

                    swapped = true;
                }
            }
            if(swapped == false) break;         // means no swap happened the array is already sorted, break out of the outer loop
        }
    }





    static void selectionSortAlgo(int[] arr){

        
        for (int i = 0; i<arr.length; i++){  

                int lastIdx = arr.length-i-1;

                // find index of max element in the given range
                int maxIdx = maxIdx(arr,lastIdx);

                // swap it with last index of the range;
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[lastIdx];
                arr[lastIdx] = temp;

        }
    }
}
