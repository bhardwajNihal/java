package A2Z_sheet.Arrays.Basic;

import java.util.ArrayList;



// approach

// two pointer
// initialize two pointer, iterate left to right
// add the common ones
// increment the smaller ones

// tc = O(m + n);
// sc = O(k)


public class IntersectionOfSortedArr {
    
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        

        int i = 0; 
        int j= 0; 
        int n = nums1.length;
        int m = nums2.length;

        ArrayList<Integer> list = new ArrayList<>();
        
        while(i < n && j<m){

            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }

        int[] ans = new int[list.size()];
        for(int k = 0; k<list.size(); k++){
            ans[k] = list.get(k);
        }
        
        return ans;
    }
}
