package Recursion;

import java.util.Arrays;

import Arrays.sorting.selectionSort;

public class SelectionSortRecursive {
    

    public static void main(String[] args) {
        
        int[] arr = {};
        SelectionSortRecursiveAlgo(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

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

    static void SelectionSortRecursiveAlgo(int[]arr, int e){

        if(arr.length==0) return;
        if(e==0) return;

        int maxIdx = maxIdx(arr, e);

        int temp = arr[maxIdx];
        arr[maxIdx] = arr[e];
        arr[e] = temp;

        SelectionSortRecursiveAlgo(arr,e-1);

    }
}
