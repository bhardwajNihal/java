
import java.util.Arrays;
import java.util.HashMap;

public class twoSum {

    
    // brute force 
    // O(N^2) 
    // just have two nested loops..


    // better 
    // two pointer approach
    // 1st sort the array
    // track the smallest and the largest ele
    // compare to the target repeated
    // if target is smaller increment the smaller one
    /// if target is larger decrement the larger element
    // repeat till the pointers collide.
    // if target found return the indexes

    // tc = O(nlogn + n)        ---> nlogn for sorting, n for iterating once

    public int[] twoSum_better(int[] nums, int target) {
        
        int n = nums.length;
        // storing original ele with their index before sorting

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<n; i++){
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        int[] sorted = nums;

        int i = 0;
        int j = n-1;

        while(i < j){

            if(sorted[i] + sorted[j] == target){
                int first = map.get(sorted[i]);
                int second = map.get(sorted[j]);
                return new int[]{i,j};
            }
            else if(sorted[i] + sorted[j] < target) i++;
            else j--;
        }

        return new int[]{};
        
    }




    
    // optimal approach
    // maintain a hashmap
    // put the elements and it's index
    // now iterate over the given array
        // find target - currentElement in the map
        // if found return

//     Time Complexity: O(N) on average, where N represents the array size. Every element requires one average constant-time hash-map lookup and at most one insertion.

// Space Complexity: O(N), for the hashmap
    

    public int[] twoSum_optimal(int[] nums, int target) {
    
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for( int i = 0; i<n; i++){
            int partner = target - nums[i];
                // Check before insertion so the current
//               index cannot be paired with itself.
            if(map.containsKey(partner)) return new int[]{i, map.get(partner)};
            else map.put(nums[i], i);
        }

        return new int[]{};
        
    }






}
