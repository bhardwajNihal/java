package Arrays.Tuf_sdeSheet;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement2 {
    
    // brute 
    // just count each element, return if count exceeds n/2
    // TC = O(N^2);
    // SC = O(1)


    // better
    // maintain a hashmap, with the ele and their count
    // return the one with count > n/2
    // TC = O(NlogN) + O(N) ; 1st for inserting to the map, 2nd for searching 
    // SC = O(N), for the extra map used
    static int majorityEle(int[] arr){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<arr.length; i++){

            if(!map.containsKey(arr[i])) {
                map.put(arr[i],1); 
            }
            else{
                map.put(arr[i], map.get(arr[i])+1);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) > arr.length/2) return key;
        }

        return -1;
    }



    // optimal
    // approach: 
        // iterate over each element once
        // maintain the current ele and its count
        // if the next ele is same as the current one, increment the count, else decrement the count
        // update the ele, once the count is 0;
        // the the value stored in the ele variable is the probable majority ele
        // finally cross check the ele to be majority one, return it if true
    // TC = O(2N), for 2 separate iterations, one for maintaining count, 2nd one for verifying the majority ele
    // SC = O(1)
    static int majorityEle_Opt(int[] arr){

        if(arr.length == 0) return -1;
        if(arr.length == 1) return arr[0];

        int ele = arr[0];
        int count = 0;

        for(int i =0; i<arr.length; i++){
        
            if(count == 0){
                ele = arr[i];
                count = 1;
            }
            else{
                if(arr[i] == ele) count++;
                else count--;
            }
        }

        // checking if the ele, is actually the majority ele
        int finalCtn = 0;
        for(int e : arr){
            if(e==ele) finalCtn++;
        }

        if(finalCtn>arr.length/2) return ele;
        return -1;

    }

    
}
