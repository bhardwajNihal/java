package Tuf_sdeSheet;

import java.util.ArrayList;
import java.util.List;

// leetcode

public class SubsetSum {
    
    // helper function to return sum of array
    static int sumArr(List<Integer> arr){
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        return sum;
    }

    // brute 
    // as usual, get the subsequence out of current branch, calculate sum, push to the ans
    // TC = O(2^N + N + (2^N)log(2^N))  ---> 2^N for recursion (taking 2 possibilities of each ele, and N is for calculating sum, (2^N)log(2^N) to sort the final ans)
    // SC = O(2^N) ---> to store ans array
    static void subsetSum(int arr[], int idx, List<Integer> pArr, List<Integer> ans ){

        if(idx == arr.length){
            ans.add(sumArr(pArr));
            return;
        }

        // exclude
        subsetSum(arr, idx+1, pArr, ans);

        // include
        pArr.add(arr[idx]);
        subsetSum(arr, idx+1, pArr, ans);
        pArr.remove(pArr.size()-1);
    }


    // better 
    // no need for extra processed array, and extra helper funtion to calculate sum
    // calculate sum successively on each branch, once reached last, add to the ans
    // TC = O(2^N + (2^N)log(2^N))----> for recursion, and final sorting
    // SC = O(2^N)
     static void subsetSum(int arr[], int idx, int sum, List<Integer> ans ){

        if(idx == arr.length){
            ans.add(sum);
            return;
        }
        // exclude
        subsetSum(arr, idx+1, sum, ans);
        // include
        subsetSum(arr, idx+1, sum+arr[idx], ans);
    }

    public static void main(String[] args) {
        
        int[] arr = {1,2};
        List<Integer> ans = new ArrayList<>();
        subsetSum(arr, 0, new ArrayList<>(), ans);

        ans.sort(null);
        System.out.println(ans);
    }
}
