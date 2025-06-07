package Recursion;

import java.util.ArrayList;

public class recursionOnArrays {
    
    public static void main(String[] args) {
        
        int[] arr = {1,1,1,20,23,14,16,1,5};
        ArrayList<Integer> ansArr = new ArrayList<>();
        // System.out.println(isSorted(arr, 0));
        System.out.println(ListAllOccurances(arr,1,0,ansArr));
        System.out.println(ListAllOccurances2(arr,1,0));
    }


    // given an array, check recursively if its sorted
    static boolean isSorted(int[] arr, int start){

        if(start== arr.length-1) return true;

        // if any subsequent subarray returns false, the overall answer will be false;
        return arr[start]<=arr[start+1] && isSorted(arr,start+1);
    }


    // linear search recursively
    static int linearSearch(int[] arr,int target, int index){

        // make this check before to avoid index out of bounds error
        if(index == arr.length) return -1;        // if whole array is covered still not found
        // at any point if the target matches return the index
        if(arr[index]==target) return index;

        return linearSearch(arr, target, index+1);
    }


    // return all the occurance of the target in cae of duplicates
    // instead of storing, just store them into an arraylist

    static ArrayList<Integer> ListAllOccurances(int[] arr, int target, int index, ArrayList<Integer> ansArr){

        if(index == arr.length) {
            return ansArr;
        }

        if(arr[index]==target) ansArr.add(index);
        return ListAllOccurances(arr,target,index+1,ansArr);

    }


    // another approach where we are not allowed to pass the ansArray list as parameters
    static ArrayList<Integer> ListAllOccurances2(int[] arr, int target, int index){

        ArrayList<Integer> ansArr = new ArrayList<>();

        if(index == arr.length) {
            return ansArr;
        }
        // will contain the answer for current function call
        if(arr[index]==target) ansArr.add(index);

        // defining another arraylist that will catch the answer returned from the successive function
        ArrayList<Integer> ansFromBelowCalls = ListAllOccurances2(arr,target,index+1);

        ansArr.addAll(ansFromBelowCalls);   //inbuild arraylist method to add elements from another list

        return ansArr;

    }




    // recursive binary search in a rotated sorted array
    static int RBSrotatedArr(int[] arr, int target, int s, int e){

        // base case
        if(s>e) return -1;

        int mid = s + (e-s)/2;
        if(target == arr[mid]) return mid;

        // left part sorted
        if(arr[s] <= arr[mid]){
            
            //if target lies in this range search in the left part
            if(target >= arr[s] && target < arr[mid]){
                return RBSrotatedArr(arr, target, s, mid-1);
            }
            else{       // else search in right part
                return RBSrotatedArr(arr, target, mid+1, e);
            }
        }

        // right part sorted
        else{
            // and target lies in this right sorted part
            if(target>arr[mid] && target<=arr[e]){
                return RBSrotatedArr(arr,target,mid+1,e);
            }
            else{   // else on the other half
                return RBSrotatedArr(arr, target, s, mid-1);
            }
        }

    }


}
