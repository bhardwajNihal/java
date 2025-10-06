package Hashmaps.Questions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    public static int[] twoSum(int[] nums, int target) {
        

        // store to a hashmap with key value pair of index and num
        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<nums.length; i++){
            map.put(i, nums[i]);
        }

        int ans[] = new int[2];
        for(var key : map.keySet()){
            if(map.containsValue(target-map.get(key))){

                // now find the key for the matching val;
                for(var e : map.entrySet()){
                    if(e.getValue() == target-map.get(key)){

                        ans[1] = e.getKey();

                        return ans;
                    }
                }
            }
        }
            

        return new int[]{-1,-1};
    }


    public static void main(String[] args) {
        int arr[] = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr,6)));

    }
}
