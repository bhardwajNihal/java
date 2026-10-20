package A2Z_sheet.Arrays.Basic;

import java.util.Arrays;

public class missingNum {
    

    

// BRUTE - 
// simply iterate and check for each element from 0 to n 
// if not found return it.
// tc = O(n^2)
    public int missingNumber_brute(int[] nums) {
        
        int counter = 0;

        while(counter < nums.length){
            boolean found = false;
            for(int i = 0; i<nums.length; i++){
                if(nums[i] == counter){
                    found = true;
                }
            }
            if(found) counter++;
            else return counter;
        }

        return counter;
    }



    
// better approach
// sort the array
// if ele != index, return it
// else return the size of the arr
// tc = O(nlogn)
    public int missingNumber_better(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);

        for(int i =0; i<n; i++){
            if(i != nums[i] ) return i;
        }

        return n;
    }





// optimal approach -1 
    // maintain a boolean array of size n+1
    // mark the found ele as 1
    // lastly traverse and return the index whose value is still 0

    // tc = O(n)
    // sc = O(n)
     public int missingNumber_optimal(int[] nums) {
        
        int n = nums.length;
        int[] boolarr = new int[n+1];

        for(int i = 0; i< n; i++){
            boolarr[nums[i]] = 1;
        }

        for(int i=0; i<=n;i++){
            if(boolarr[i] == 0) return i;
        }

        return -1;
     
    }
}
