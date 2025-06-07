package Recursion;

import java.util.Arrays;

import javax.print.attribute.standard.Copies;

public class mergeSort {

    public static void main(String[] args) {

        // int[] arr1 = {-1,5};
        // int[] arr2 = {2,3,4};
        // System.out.println(Arrays.toString(merge(arr1, arr2)));


        int[] arr = {4,2,6,1,5,3};
        System.out.println(Arrays.toString(mergeSortAlgo(arr)));
    }


    // merge sort algo
    // divide the array repeatedly, till each half is sorted
    // then merge the two sorted halves till the whole array is sorted
    static int[] mergeSortAlgo(int[] arr) {

        if(arr.length==1) return arr;

        // now find the mid from where the array is to be divided
        int mid = (arr.length)/2;

        // now recursively call this function
        // this time with two separate halves
        // inbuilt method in java that enables array to be passed by value which is needed in this scenario
        int [] leftPartSorted = mergeSortAlgo(Arrays.copyOfRange(arr, 0, mid)); //Copies the specified range of the specified array into a new array.
        int [] rightPartSorted = mergeSortAlgo(Arrays.copyOfRange(arr, mid, arr.length)); // last index exclusive

        // finally merge the two sorted halves
        return merge(leftPartSorted,rightPartSorted);

        // original array is not sorted, indeed their will be a sorted copy of the array returned.

    }

    // helper function to merge two sorted arrays
    static int[] merge(int[] arr1, int[] arr2) {

        int[] mergedArr = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length || j < arr2.length || k < mergedArr.length) {

            // if the i and j both are under bounds
            while (i<arr1.length && j<arr2.length) {
                
                if(arr1[i] <= arr2[j]){
                    mergedArr[k++] = arr1[i++];
                }
                else{
                    mergedArr[k++] = arr2[j++];
                } 
            }

            // if any of the arrays is exhausted
            // fill the remaining elements of the another array serially
            while (i< arr1.length) {
                mergedArr[k++] = arr1[i++];
            }

            while (j<arr2.length) {
                mergedArr[k++] = arr2[j++];
            }
        }
        return mergedArr;
    }




}
