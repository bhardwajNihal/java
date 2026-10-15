import java.util.Arrays;

public class B9_hashing {


  // brute
    public int mostFrequentElement(int[] nums) {
     
        if(nums.length == 0 ) return -1;
   
     // count all elements from the array
     // maintain the highest frequency
     // if two element has the same frequency return the smaller one

        int max = Integer.MIN_VALUE;
        int maxFreqEle=nums[0];

        for(int i = 0; i<nums.length; i++){
            int count = 0;
            int currEle = nums[i];
            
            count++;
            for(int j = 0; j<nums.length; j++){
                if(i!= j && nums[i] == nums[j]) count++;
            }

            
            if(count >= max) {       // storing current max ele

                if(count > max){
                    max = count;
                    maxFreqEle = currEle;
                }
                else{
                    if(currEle < maxFreqEle){
                        maxFreqEle = currEle;
                    }
                }
            }
                
        }
        return maxFreqEle;
     
    }



    // BETTER 
        public int mostFrequentElement_better(int[] nums) {
    
            if(nums.length==0) return -1;
            // better approach 
            // sort the elements and count progressively
            // in case of similar max count, store the smaller elements

            // sorting the array
            Arrays.sort(nums);

            // iterate over the array
            // increment the counter by 1, if next element matches
            // on 1st non matching element
                // compare the count to the max
                // if greater update max and maxFreqEle
                // if equal, then compare maxFreqEle to currEle

            int max = Integer.MIN_VALUE;
            int maxFreqEle = nums[0];
            int i = 0;
            int count = 1;      // initialized with 1 to include current ele 

            while(i<nums.length-1){
                
                if(nums[i] == nums[i+1]) count++;
                else count=1;    // if unequal element found - reset count

                if(count > max){            // once count becomes greater than max
                            max = count;
                            maxFreqEle = nums[i];     
                        }
                else if(max == count){
                    maxFreqEle = Integer.min(nums[i], maxFreqEle);
                }
                
                i++;
            }

            return maxFreqEle;

            }
    
}

// OPTIMAL 

public int mostFrequentElement_opt(int[] nums) {
    
    // optimal approach
    // just add the ele and its count to a map
    // return the one with highest frequency

    HashMap <Integer, Integer> map = new HashMap<>();

    for(int i = 0; i<nums.length; i++){

        if(map.containsKey(nums[i])){
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        else{
            map.put(nums[i], 1);
        }
    }

    // now we have the frequency map
    // iterate over it 
    // maintain a maxCount and and maxFreqEle

    int max = Integer.MIN_VALUE;
    int maxFreqEle = nums[0];

    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        if(map.get(entry.getKey()) > max) {
            max = entry.getValue();
            maxFreqEle = entry.getKey();
        }
        else if(map.get(entry.getKey()) == max) maxFreqEle = Integer.min(entry.getKey(), maxFreqEle);
    }


    return maxFreqEle;
    

    }