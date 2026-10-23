package A2Z_sheet.Arrays.Basic;

import java.util.ArrayList;
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




    
// optimal approach
    // using two pointers
    // simultaneously track elements of both the unionArray
    // add the smaller element
    // if equal increment one of the pointer

    // tc = O(m+n)
    // sc = O(k)

    public int[] unionArray_optimal(int[] nums1, int[] nums2) {
        
        int i = 0; 
        int j = 0;

        ArrayList<Integer> union = new ArrayList<>();

        while(i < nums1.length && j < nums2.length){

            int currentEle;
            if(nums1[i] == nums2[j]){
                currentEle = nums1[i];
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                currentEle = nums1[i];
                i++;
            }
            else{
               currentEle = nums2[j];
                j++;
            }

            // lastly check if the ele is already added to the last
            // checking last ele would suffice, as eles are sorted
            // does the work in constant time, rather O(n) of linear search everytime

            if(union.isEmpty() || union.get(union.size()-1) != currentEle) union.add(currentEle);

        }

        // now if any of the array is exhausted
        // simply add the other array's ele serially

        while(i<nums1.length){
            if(union.isEmpty() || union.get(union.size()-1) != nums1[i]) union.add(nums1[i]);
            i++;
        }

        while(j<nums2.length){
            if(union.isEmpty() || union.get(union.size()-1) != nums2[j]) union.add(nums2[j]);
            j++;
        }


        // lastly copy eles of list to an array to return int
        int[] ans = new int[union.size()];
        for(int k = 0; k<union.size(); k++){
            ans[k] = union.get(k);
        }
        return ans;

    }
}
