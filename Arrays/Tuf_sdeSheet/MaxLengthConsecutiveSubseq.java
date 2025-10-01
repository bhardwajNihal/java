package Arrays.Tuf_sdeSheet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxLengthConsecutiveSubseq {
    
    // leetcode 128 : Given an unsorted array of integers nums, 
    // return the length of the longest consecutive elements sequence.

    // brute
    // manually find the next ele, if found, maintain the maxcount upto which the no.s are consecutive
    // TC = O(N^2)


    // better
    // sort, then in one iteration find out consetive no.s
    // TC = O(N) + O(NlogN), one iteration + the sorting
    // space = O(1)     
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0) return 0;

        // sort 
        Arrays.sort(nums);
        int lastNum = nums[0];  
        int count = 1;
        int maxlength = 1;

        for(int i =1; i<nums.length; i++){

            if(nums[i-1] == nums[i]) continue;  // skip duplicates

            if(nums[i]-1 == lastNum){       // check if the current iteration is just the next number
                lastNum = nums[i];
                count++;
                maxlength = Integer.max(count, maxlength);      // always maintain the max count
            }
            else{
                lastNum = nums[i];      // reset count to 1 if consecutivity breaks
                count = 1;
            }
        }
        return maxlength;
    }



    // another approach using set
    // may be better, may be not, considering the best case for searching the set
    // TC = O(N) + O(2N) ~ O(3N), one for putting to set, 2N for searching potential sequence
    // SC = O(N) for extra set 
    public int longestConsecutive2(int[] a) {
        
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4,2};
        Arrays.sort(arr);

        for(int ele : arr){
            System.out.println(ele);
        }
    }
    
}
