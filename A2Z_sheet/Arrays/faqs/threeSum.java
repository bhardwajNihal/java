import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class threeSum {
    

    public List<List<Integer>> threeSum_(int[] nums) {
        

        //.1. brute
        //  use three nested loops, 
        // tc = O(N^3);


        // 2. better approach - hashing
        // can reduce the tc to O(N^2)
        // use two loops and look for the targets in the hashset
        // tc = O(N^2 log(M))       // M = size of the set, log M for the lookup in a hashset in worst case
            int n = nums.length;
            
            // Set<List<Integer>> set = new HashSet<>();

            // for(int i = 0;  i<n; i++){
            //     HashSet<Integer> map = new HashSet<>();
            //     for(int j = i+1; j<n; j++){
            //         int target = -(nums[i] + nums[j]);
            //         // if target exists in the map, create new triplets list and add it to the set
            //         // add nums[j] to the map

            //         if(map.contains(target)){
            //             List<Integer> temp = Arrays.asList(nums[i], nums[j], target);
            //             Collections.sort(temp);     // sorting it prevents adding same  triplets.
            //             set.add(temp);
            //         }
            //         map.add(nums[j]); //we want the third element to come from an already visited index, not the current index.
            //     }
            // }

            // return new ArrayList<>(set);



        // optimal - three pointers approach.
        // sort the array and track three elements
        // no need for extra space of hashset.
        // compare the current triplets with 0, and adjust the counters accordingly
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i<n-2; i++){
            int j = i+1;
            int k = n-1;
            // inner while loop for other two counters
            while(j<k){

                if((nums[i] + nums[j] + nums[k]) == 0){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                   set.add(temp);
                    j++;
                    k--;
                    while(j<n && nums[j-1] == nums[j]) j++;
                    while(k>-1 && k<n-1 && nums[k+1] == nums[k]) k--;
                } 
                else if((nums[i] + nums[j] + nums[k]) < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
