package Recursion;

import java.util.Arrays;

public class BubbleSortRecursive {
    
    public static void main(String[] args) {


        int [] arr = {1,2,3};
        BubbleSortRecursiveAlgo(arr, arr.length, 0);
        System.out.println(Arrays.toString(arr));
        
    }

    // approach
    // will be same as the taking row and column in the pattern printing (desc triangle)
    // in the 1st step, the whole array will be traversed, i.e when row==arr.length-1,
        // the col will go from 0 to the 2nd last index
        // compare with next element, if next ele is smaller >> swap

    // this process is now repeated this time again row = row-1
        // column will again traverse till row
    // step continues till row ==0
    static void BubbleSortRecursiveAlgo(int[] arr, int row, int col){

        if(row==0) return;

        if(col <= row-2 && arr[col] > arr[col+1]){
            int temp = arr[col];
            arr[col] = arr[col+1];
            arr[col+1] = temp;

            // process to swap continues till col reaches the 2nd last ele, compare with the last ele of the current range
            BubbleSortRecursiveAlgo(arr, row, col+1);
        }
        // if the 1st stage is over
        // called again with decreased range 
        else{
            BubbleSortRecursiveAlgo(arr, row-1, 0);
        }



    }
}
