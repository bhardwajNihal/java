package Tuf_sdeSheet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CombinationSum_1 {

// leetcode - 39
// given an array give all potential candidates adding to a sum target

// TC = O(2^t + K)   ===> (worse case when target==10, and candidate is 1) where t is the target, and k is the avg length of a branch
// SC = k

    static void combinationSum_1(int[] candidates, int target, int idx, List<Integer> pArr, List<List<Integer>> ans) {

        if (idx == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(pArr)); // not the add the actuall pArr
            }
            return;
        }

        // exclude current index, move to next one
        combinationSum_1(candidates, target, idx + 1, pArr, ans);

        // include current index, as an element can be taken any no. of times,
        // thus index is not incremented, target-current is mathched, and further called in the arg
        // also, include current index (only if target is still >= current candidate)
        if (target >= candidates[idx]) {
            pArr.add(candidates[idx]);
            combinationSum_1(candidates, target - candidates[idx], idx, pArr, ans);

            // removed last ele of pArr to remove duplicates on further branches
            pArr.remove(pArr.size() - 1);
        }
    }




    // leetcode 40
    // given an array, give list of all unique subsequences with given target
    // TC = O(2^N + k) --->(worse case, when all ele are unique) where n is the no. of eles, k is the operation of putting the ans list
    // SC = O(k+x), where k is the no. of possible combinations, and x is avg. length of combinations
    static void combinationSum_2(int[] candidates, int target, int idx, List<Integer> pArr, List<List<Integer>> ans) {

            if (target == 0) {
                ans.add(new ArrayList<>(pArr)); // not the add the actuall pArr, rather its copy
            return;
            }

        for(int i =idx; i<candidates.length; i++){

        // skip repeating elements, for current branch
            if(i>idx && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;

        // include current ele
            pArr.add(candidates[i]);
            combinationSum_2(candidates, target-candidates[i], i+1, pArr, ans);

            pArr.remove(pArr.size()-1);
        }
        
        
    }



}
