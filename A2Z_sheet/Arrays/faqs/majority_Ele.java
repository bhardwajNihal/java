

import java.util.HashMap;

public class majority_Ele {
    
    
    // brute force
    // tc = O(N^2)
    // count the element and return the one with count > length/2
    public int majorityElement_brute(int[] nums) {

        for(int i = 0; i< nums.length; i++){
            int currEle = nums[i];
            int count = 0;

            for(int j=0; j<nums.length; j++){
                if(nums[j] == currEle) count++;
            }

            if(count > nums.length/2) return currEle;
        }

        return 0;
      
    }




      /// better approach
    // maintain a frequency map
    // return the key whose freq exceeds nums.length/2;
    // tc = O(N)       // one loop only
    // sc = O(N)       // extra map space

    public int majorityElement_better(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > nums.length/2) return key;
        }
      
      return 0;
    }



    
    // optimal approach
    // maintain a balance counter
    // increment it for similar ele
    // decrement it for different ele
    // if on successive iteration it's value is > 0
            // then the current candidate is in the race
    // if balance == 0 
        // and the next ele is different from current candidate
        // then change the current candidate, and increment the counter for it

    // repeat till last
    // lastly return the current candidate

 
    public int majorityElement(int[] nums) {

        int balance = 1; 
        int currCandidate = nums[0];

        for(int i =1; i<nums.length; i++){

            if(balance == 0){
                if(nums[i] == currCandidate) balance++;
                else currCandidate = nums[i];
            }

            else{
                if(nums[i] != currCandidate) balance--;
                else balance++;
            }
        }
        return currCandidate;
    }
}
