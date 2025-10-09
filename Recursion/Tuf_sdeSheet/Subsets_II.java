package Tuf_sdeSheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Subsets_II {
    
    // leetcode - 90
    // given array of ele (eles may not be unique), give all unique subsets
    

    // brute
    // get all the possible subsets using pick not-pick technique
    // add it to a set, it will take care of the duplicates
    // finally add the set ele to final ans list
    static void subSets(int[] arr, int idx, List<Integer> pArr, Set<List<Integer>> ans){
        
        if(idx==arr.length){
            List<Integer> temp = new ArrayList<>(pArr);
            temp.sort(null);
            ans.add(temp);    
            return;
        }
        // exclude current index ele
        subSets(arr, idx+1, pArr, ans);
        // include
        pArr.add(arr[idx]);
        subSets(arr, idx+1, pArr, ans);
        pArr.remove(pArr.size() - 1);     
    } 



    // better approach
    // insteach of using set, and going for all duplicate ele and adding to the set
    // sort the given array
    // using a for loop, add inclusion exclusion concept

    static void subSets_better(int[] arr, int idx, List<Integer> pArr, List<List<Integer>> ans){
        
        ans.add(new ArrayList<>(pArr));     // just add the current processed array to the ans before further looping, no need of base case, as recursion call is already restricted via for loop
       
        for(int i = idx; i<arr.length; i++){        // looping through each index

            if(i>idx && arr[i]==arr[i-1]) continue;     // skipping duplicates

            // include
            pArr.add(arr[i]);
            subSets_better(arr, i+1, pArr, ans);
            pArr.remove(pArr.size() - 1);  

        }
    } 


}
