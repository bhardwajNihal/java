package Algorithms.sorting;

import java.util.Arrays;

public class selectionSort {
    
    public static void main(String[] args) {
        
        int [] arr = {1,2,3,4,5,-5,-4,-3,1,2};
        selectionSortAlgo(arr);
        System.out.println(Arrays.toString(arr));

    }


    // Selection sort:
    // just find the ith largest element, put in to its right place
    // like for the 1st iteration --> put largest ele to the last index
    // 2nd iteration --> put 2nd largest element to the 2nd last index... so on 
    
    // Best and worst case time complexity in O(N^2) : as any how, it will make n comparisons in each iteration to find out the largest
    // unstable

    // helper function to find the largest element in the given search space
    static int maxIdx(int arr[], int end){
        int max =Integer.MIN_VALUE;
        int maxidx = -1;

        for(int i =0;i <= end;i++){
            if(arr[i] > max){ 
                max = arr[i];
                maxidx = i;
            };
        }
        return maxidx;
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
