import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class foursum {
    

     public List<List<Integer>> fourSum_better(int[] nums, int target) {
        

        // brute - standard O(N^4) approach

        // better approach
        // tc = o(N^3.logM)     // logm for the lookup in a hashset of length M
        // sc = O(4m), m = no. of quadruplets
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i< n-2; i++){
            for(int j = i+1; j<n-1; j++){

                HashSet<Integer> map = new HashSet<>();
                for(int k = j+1; k<n; k++){
                    int fourth = target - (nums[i] + nums[j] + nums[k]);
                    if(map.contains(fourth)){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    map.add(nums[k]);
                    
                }
            }
        }
        return new ArrayList<>(set);
    }



    public List<List<Integer>> fourSum_optimal(int[] nums, int target) {
        
        // optimal approach
        // just like the threesum one's
        // but this time we have to fix two index instead of one

        // and then using two pointers we will find the required quadruplets
        // tc = O(N^3) + NlogN -> for sorting
        // sc = O(1)    --> excluding the output storage.



        int n = nums.length;
        Arrays.sort(nums);     // sorting the array
        List<List<Integer>> answer = new ArrayList<>();
        for(int i =0; i<n-3; i++){
            // to skip duplicate eles, just skip the next index if it holds same value
            if(i>0 && nums[i-1] == nums[i]) continue;
            for(int j = i+1; j<n-2; j++){
                if(j>i+1 && nums[j-1] == nums[j]) continue;
                // taking two pointers now.
                int k = j+1; 
                int l = n-1;

                while(k<l){
                    long sum = (long)nums[i]+ nums[j]+nums[k]+nums[l];      // just typecas the 1st int to long, now java evaluates the sum as long only.
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j],nums[k],nums[l]);
                        answer.add(temp);       // no need to sort
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(l>k && nums[l] == nums[l+1]) l--;
                    }
                    else if(sum < target) k++;
                    else l--;
                }
            }
        }
        return answer;
    }
}
