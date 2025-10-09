package Tuf_sdeSheet;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    

    // TC = O(n! * n)
    // SC = O(N)            // extra boolean array
    static void permutations(int[] arr, List<Integer> pArr, boolean[] marked,List<List<Integer>> ans ){

        if(pArr.size() == arr.length){
            ans.add(new ArrayList<>(pArr));     // once reached the end of current branch add to ans
            return;
        }
        // move to every possible branch, put the ele to an index, go deeper to put possible ele to next spot
        for(int i =0; i<arr.length; i++){

            if(!marked[i]){             // continue if current ele not already taken
                marked[i] = true;
                pArr.add(arr[i]);
                permutations(arr,pArr,marked,ans);        // no need to pass idx, loop starts from zero everytime
                marked[i] = false;                  // unmark ele while backtracking
                pArr.remove(pArr.size()-1);
            }
        }
    }


    // better approach - space optimized
    // TC = O(n! * n)
    // SC = O(1)        // no extra space need
    static void permutations_better(int[] arr, int idx,List<List<Integer>> ans ){

        List<Integer> temp = new ArrayList<>();     // a temp list to hold current arr state
        if(idx == arr.length){
            for(int ele : arr){     // copying arr elements to temp
                temp.add(ele);    
            }
            ans.add(temp);          // finally, adding temp to ans
            return;
        }

        for(int i =idx; i<arr.length; i++){     // iterate from current index to last

            // swap arr[i], with current idx
            swap(arr,i,idx);
            // call further
            permutations_better(arr,idx+1,ans);
            // swap back to restore original array with backtraking
            swap(arr,i,idx);
        }
    }
    
    // helper 
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static boolean isEqual(int[]arr, List<Integer> list){
        for(int  i =0; i<arr.length; i++){
            if(arr[i] != list.get(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        
        List<Integer> l1 = new ArrayList<>();
        
        l1.add(1);
        l1.add(2);

        int[] arr = {1,2};

        System.out.println(isEqual(arr, l1));

        
       
    }

}
