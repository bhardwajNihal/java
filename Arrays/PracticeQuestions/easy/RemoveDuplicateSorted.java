package Arrays.PracticeQuestions.easy;

import java.util.HashSet;

public class RemoveDuplicateSorted {
    

    public static void main(String[] args) {
        
    }


    // brute-force :
    // - iterate over the whole array, add unique elements to the set,
    // - maintain the index to track the no. of unique elements
    // time and space complexity both O(N), 
    public int removeDuplicates(int[] nums) {
        
        HashSet<Integer> list = new HashSet<>();
        int idx = 0;

        for(int i =0; i< nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                nums[idx++] = nums[i];

            }             
        }
        return list.size();
    }


    // optimal approach
    // two pointer approach
    // put two pointers, i and j
    // i on 1st element, j on 2nd, iterate j rightwards, find the 1st element not equal to that on i, increment i and put that element on that index, continue till the j iterates whole array

    public int removeDuplicates_opt(int[] nums) {
        
        int i =0; 
        int j = 1; 

        while(j != nums.length){

            // increment j until unmatched element is found
            if(nums[j] == nums[i]) j++;
            else {
                nums[++i] = nums[j];    // put the different element found just next to current ith index, then increment i, repeat 
            }
        }

        return i+1;
    }

}
