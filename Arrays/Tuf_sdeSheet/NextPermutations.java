package Arrays.Tuf_sdeSheet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutations {

    // worst solution
    // just bruteforce, generate all permutations,
    // match with the given array, return the next one, 1st in case of last
    // TLE

   

    // optimal
    // just based on some observations

    // steps I : find breakpoint
                // i.e. an index i, such that arr[i] < arr[i+1], find iterating backwards
    // Step II : swap it a greater ele in its right, also smallest among all the right ele
    // Step III : reverse the right part 

    // TC = O(4N) ---> approx, one to find breakpoint, one to find smallest greater ele, then two iterations for putting to list, and back to array
    // SC = O(1)
    public void nextPermutation(int[] arr) {
        // stepI : find breakpoint
        int br = -1;
        for(int i  = arr.length-2; i>=0; i--){
            if(arr[i] < arr[i+1]) {
                br = i;
                break;
            }
        }
        
        // if breakpoint remains -1, means the array is sorted in decreasing
        // in that case the reverse the arr to get the 1st permution and return
        if(br==-1){
            List<Integer> temp = new ArrayList<>();
            for(int ele : arr){
                temp.add(ele);      // as inbuilt reverse func takes list as arg
            } 
            Collections.reverse(temp);          // sort the list, 
            for(int i = 0;i<temp.size(); i++){      // adding back to original array
                arr[i] = temp.get(i);       
            }
            return;
        }


        // if breakpoint found
        // find the smallest ele greater than arr[br], in its right
            // as the after breakpoint, the array is surely sorted
            int smallestGreaterEleIdx = br;
            for(int i =arr.length-1; i>=0; i--){        // the 1st ele from the back is surely the smallest greater ele 
                if(arr[i] > arr[smallestGreaterEleIdx]){
                     smallestGreaterEleIdx = i;
                     break;
                }
            }


        // now we got the index of smallest greater element

        // swap it with arr[br]
        swap(arr, br, smallestGreaterEleIdx);

        
        // last step, i.e. to reverse the right part of the break point
        List<Integer> subArray = new ArrayList<>();
        for(int i = br+1; i<arr.length; i++){
            subArray.add(arr[i]);
        }
        Collections.reverse(subArray);
        int idx = 0;        // separate index to fetch subarray
        for(int i = br+1;i<arr.length; i++){      // adding back to original array
                arr[i] = subArray.get(idx++);       
        }

    }

    // helper functions
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j]; 
        arr[j] = temp;
    }

    static void reverse(int[] arr, int se, int ee){
        int i =se;
        int j = ee;
        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
