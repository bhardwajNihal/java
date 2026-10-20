package A2Z_sheet.Recursion.fundamentals;

import  java.util.*;
public class arraySum {
    

    
    // recursive function with the index tracking parameter

    public static int arraySumRecursive(int nums[], int i){

        if(i==-1) return 0;
        return  nums[i] + arraySumRecursive(nums, --i);
    }


    public int arraySum_rec(int[] nums) {
        

        
        return arraySumRecursive(nums,nums.length-1);

        

    }
}
