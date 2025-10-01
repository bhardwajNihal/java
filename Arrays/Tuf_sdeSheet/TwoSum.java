package Arrays.Tuf_sdeSheet;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    

    public int[] twoSum(int[] nums, int target) {
        

        // store to a hashmap with key value pair of num, and corresponding index
        Map<Integer, Integer> map = new HashMap<>();

        int[] ans = {-1,-1};

        for(int i = 0; i<nums.length; i++){

            // find partner as if target = 6, and arr = {3,2,4}, for 2 -> partner is 4

            int partner = target-nums[i];

            // find the partner, 
            // if found push current index , add the partner index to the ans, else add it to the map
            if(map.containsKey(partner)){
                ans[0] = i;
                ans[1] = map.get(partner);
                return ans;
            }
            map.put(nums[i], i);
        }
            

        return ans;
    }

}
