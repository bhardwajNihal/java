

import java.util.ArrayList;
import java.util.List;

public class LeadersInArr {
    
     // brute
    // simply loop through ele
    // then another loop to check all the elements after in
    // track if following eles are smaller
    public List<Integer> leaders(int[] nums) {
        
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0; i<n-1; i++){
            boolean isLeader = true;
            for(int j=i+1; j<n; j++){
                if(nums[j] > nums[i]){
                    isLeader = false;
                    break;
                }
            }
            if(isLeader) list.add(nums[i]);
        }

        // finally add last ele;
        list.add(nums[n-1]);
        return list;
        
    }

}
