package Arrays.sorting;
import java.util.ArrayList;
import java.util.Arrays;

public class cycleSort {
    
    public static void main(String[] args) {
        
        int[] arr = {5,4,3,2,1};
        // cycleSortAlgo(arr);
        // System.out.println(Arrays.toString(arr));

        int[] arr2 = {4,3,2,7,8,2,3,1};
        System.out.println(FindAllMissingElements(arr2));
    }


    // helper swap function
    static void swap(int[]arr, int index1, int index2){

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }

    //Cycle sort : 
    // only applicable, if the array elements are from 1 to N.
    // so the thought process is like 
    // at the 0th index --> ideally there should be 1, at 1th --> 2, at 2nd -->3
    // so starting from the very 1st index
        // check if it has the rigth element
        // if not, swap it with the element-1 index
        // ex - if arr[0] =4 ---> swap arr[0] with arr[3] --> as ideally 4 should be at index 3
                // now if arr[0] becomes 2, then swap it with no. at index 1
                // repeat this cycle the 1st index is sorted, i.e. arr[0] == 1
            // then move ahead, repeat this process.

        // Why this algo
        // -- sorts the entire array in 1 stage only, i.e. 1 loop is needed
        // TC --> O(N);

    static void cycleSortAlgo(int[] arr){

        int i = 0;

        while (i<arr.length) {
            
            if(arr[i] == i+1) i++;
            else{
                swap(arr, i, arr[i]-1);
            }
        }
    }



    // given an array of size n, having no.s from 0 to n
    // find the missing number
    // for example let say n=5.
        // ideally the array should be {0,1,2,3,4,5}  ==> n+1 elements
        // but the array is like {5,3,1,0,4} --> 2 is missing, we have to find it.

    // here's, we can observe a pattern, that in the ideal scenario
    // the array length should be n+1 for[0,n] range, and each index is actually the ideal number that should be at that number

    // approach
    // apply cyclic sort
    // after the array is sorted, check of each index, if index==number, pass
    // if at any point the index != number at the index, then that index is the answer

    // in case of the 1st and last number
    // if the loop comes to an end, and all the no. is at their respective correct index --> then the last no. of the range is the answer ==> ans = arr.length
    //if the loop ends, and the 0th index != 0, then 0 is the answer

//trust me, dry running will make the scenario clearer.
    static int FindMissingEle(int[] arr){

        int i = 0;

        while (i<arr.length) {

            // for the element == arr.length --> index will get out of bound when swapping
            // thus leave the element == arr.length as it is
            if (arr[i]<arr.length &&  i != arr[i]) {
                swap(arr, i, arr[i]);
            }
            else i++;   // if ele==arr.length or arr[i]==i just increment the pointer.
        }
        // 2nd loop for iterating throughout the sorted array, to find out, the missing one
        for(int j =0;j<arr.length; j++){

            if(arr[j] != j) return j;
        }
        // if all the index have correct element==index itself
        // means the last element of the range is missing, in that case return that i.e. == arr.length
        return arr.length;
    }



    // find all the missing element in a given array of size n, with element in the range [1,n];
    // there will be duplicate elements

    // eg. for [4,6,2,1,2,4,] ===> o/p [3,5]

    // approach : apply cyclic sort,
        // if arr[i] != i+1 ---> swap(arr[i], i)        
        // if arr[i] <= i --> i++

        //dry run for clarity

    static ArrayList<Integer> FindAllMissingElements(int[] arr){


        // as answer array can be of variable length, thus using arraylist
        ArrayList<Integer> ansArr = new ArrayList<>(1);

        int i =0;
        while (i<arr.length) {
            // check if the element at i is at the intended index of not
            // for ex : if arr[0] = 3, then arr[2] should be 3, if not swap, if yes, i++, in case of duplicates
            if(arr[arr[i]-1] != arr[i]) swap(arr, i, arr[i]-1);
            else i++;   
        }

        for(int j=0; j<arr.length; j++){
            if(arr[j] != j+1 ) ansArr.add(j+1);
        }
        return ansArr;
    }




    // leetcode - 287 : find the duplicate element
    // given an array with no.s in range [1,n], of size n+1, with one duplicate ele, find it

    // apply cycle sort, 
    // all one all the element comes to their right index
    // last index will hold the duplicate
    static int FindDuplicate(int[] arr){

        int i =0;
        while (i<arr.length) {
            
            if(arr[arr[i]-1]!= arr[i]) swap(arr, i, arr[i]-1);
            else i++;
        }
        return arr[arr.length-1];
    }


    // leetcode 442, find all duplicates in an array with 1 to n elements
        // simple cyclic sort, numbers at the wrong index are the answer
    static ArrayList<Integer> FindAllDuplicates(int[] arr){

        int i =0;
        while (i<arr.length) {
            
            if(arr[arr[i]-1]!= arr[i]) swap(arr, i, arr[i]-1);
            else i++;
        }

        // ones the array is sorted via cyclic sort, the elements at the wrong index are the duplicates
        
        ArrayList<Integer> answerArr = new ArrayList<Integer>(1);
        for(int j = 0; j < arr.length-1; j++){

            if(arr[j]!= j+1) answerArr.add(arr[j]);

        }

        return answerArr;
    }



    // leetcode 645 : set mismatch
    // in an array from 1 to n, find the duplicated and the missing element
    //eg {1,2,2,4} ==> ans : {2,3}

        // simple cyclic sort , the num at wrong index is the duplicate one 
        // and the index of the duplicate ele + 1 will be the missing one

    static ArrayList<Integer> FindMissingAndDuplicate(int[] arr){

        int i = 0;

        while (i<arr.length) {
            
            if(arr[arr[i]-1] != arr[i]) swap(arr, i, arr[i]-1);
            else i++;
        }

        ArrayList<Integer> ansArr = new ArrayList<>();
        
        for(int j=0; j<arr.length; j++){
            if(arr[j] != j+1) ansArr.add(arr[j], j+1);
        }

        return ansArr;
    }

}