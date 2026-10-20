package A2Z_sheet.Arrays.Basic;

import java.util.Set;
import java.util.TreeSet;

public class unionOf2sortedArr {
    

    // BRUTE
    // add elements from both the arrays separately to a set
    // add back ele from set to an arrays
    // sort the final array 


    // or directly add to a tree set

    // tc = O(NlogN)
        // where N = n + m
        // n, and m being the input array length
        // an element takes logrithmic time to get inserted into treeset
        // so Inserting N elements to the ordered set will take N * logN
    

    public int[] unionArray(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new TreeSet<>();         

        for(int i =0; i<nums1.length; i++){
            set.add(nums1[i]);
        }

        
        for(int i =0; i<nums2.length; i++){
            set.add(nums2[i]);
        }

        int[] ans = new int[set.size()];


        int i = 0;
        for (int num : set) {
            ans[i] = num;
            i++;
        }

        // Arrays.sort(ans);        // no need in case of treeSet, only in case of HashSet
        return ans;
    }
}
