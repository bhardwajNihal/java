package Arrays.Tuf_sdeSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// given an array of integers
    // list out all possible triplets whose sum = 0
public class ThreeSum {
    
    // brute approach
    // simply run three loops, check for elements if there sum == 0;
    // sort them then add to a set (to check for duplicates)
    // TC = O(N^3)
    // Sc = 2 * O(no. of triplets)
    public static List<List<Integer>> threeSum_brute(int arr[]){

        Set<List<Integer>> set = new HashSet<>();

        for(int i =0; i<arr.length-2; i++){
            for(int j =i+1; j<arr.length-1; j++){
                for(int k =j+1; k<arr.length; k++){
                    
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        list.sort(null);
                        set.add(list);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> lt : set){
            ans.add(lt);
        } 

        ans.sort((a,b) -> {             // as set doesn't maintain order, the answer array is random, might fail test case, so better sort them
            for(int i = 0; i<a.size(); i++){
                if(!a.get(i).equals(b.get(i))){     // compare all 3 elements of subarrays a and b
                    return a.get(i) - b.get(i);     // arrange in asc order
                }
            }
            return 0;
        });

        return ans;
    }


// can avoid the third nested loop using hashing thus reducing TC to (N^2)logM, where logM is the search time in the set, which can be ignored
// SC = O(N) + 2 * O(no. of unique triplets), --> max ele in the map + the size of set + size of ans list
// approach
// loop from i to j
// find if -(arr[i] + arr[j]) is present in the hashmap or not
// if not, add arr[j] to the map, move j forward
// check once entire array is traversed
// if the desired ele is found in the map, sort all three ele, add them to the set, it will take care of the duplicate
    public static List<List<Integer>> threeSum_better(int arr[]){

       Set<List<Integer>> set = new HashSet<>();

        for(int i =0; i<arr.length-1; i++){
            Map<Integer,Integer> map = new HashMap<>(); // map to contain all the ele of the current inner loop until the target is found
            for(int j =i+1; j<arr.length; j++){
                int target = -(arr[i] + arr[j]);
                if(map.containsKey(target)){        
                    // if target is found, add to a list, sort it then add to the set
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(map.get(target));
                    temp.sort(null);        // sort before adding to the set
                    set.add(temp);  // set takes care of the duplicate values
                }
                else{   
                    // if -sum not found simply push arr[j] to the set
                     map.put(arr[j],arr[j]); // value doesn't matter, just want to track key
                }
            }
        }

        // add set ele to the ans list
         List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> lt : set){
            ans.add(lt);
        } 
        
        ans.sort((a,b) -> {             // as set doesn't maintain order, the answer array is random, might fail test case, so better sort them
            for(int i = 0; i<a.size(); i++){
                if(!a.get(i).equals(b.get(i))){     // compare all 3 elements of subarrays a and b
                    return a.get(i) - b.get(i);     // arrange in asc order
                }
            }
            return 0;
        });

        return ans;
    }


    // the optimal approach, saving extra spaces
    // approach
    // will sort the entire array at first
    // the other loop will start from the very 1set element
    // the inner loop from the next
    // will take a 3rd variable (k) initially at the last index

        // now will find arr[i]+arr[j],
            // if it comes out to be greater than 0, then obviously we have to reduce the entire sum to reach closer to and finally to 0
                // as the array is sorted, the only way to reduce the entire sum is by decrementing the k, till it overlaps or preceed j
                // if the sum becomes 0, just add all three ele, to temp list
            // if sum comes out to be less, then only way to increase it to reach closer to 0 is to increment j
            // if sum becomes zero add to the list;

            // for duplicate values
            // let say , k is at some value once the sum becomes 0, and all three ele is add
                // its time to decrement k, if on decrement, the previous index still hold the same value
                // continue decrementing till a different ele is found
            // same for j, till j and k overlaps, or j crosses k
        // TC = O(N*logN + N^2) in worse case, NlogN to sort the array
        // Sc = O(no. of triplets)      // significantly saved space, no need for extra set, map
    public static List<List<Integer>> threeSum_Optimal(int arr[]){
        // sorting the main array
       Arrays.sort(arr);
       List<List<Integer>> ans = new ArrayList<>();

       for(int i =0;  i<arr.length-1; i++){
        
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j = i+1;
            int k = arr.length-1;
            
            while (j<k) {
                int sum = arr[i] + arr[j] + arr[k];

                if(sum > 0){  // need to decrease the sum, only way is to decrement k
                    k--;
                }
                else if(sum < 0){      // need to increase the sum, only way is to increment j
                    j++;
                }
                else { // add all current elements directly to ans list, the triplets are already sorted
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    ans.add(temp);

                    // now as for current value of j and k, we got the triplets
                    // to avoid taking the same values for j and k, we can't just increment and decrement by 1
                    // as there may be same value ahead j, and behind k
                    // so we decrement k, and increment j, until they reach a new value
                        // as sum == 0 , we neither want to increase or decrease the sum
                    while (j<k && arr[j]==arr[j+1]) {       // to make sure j and k are within right bounds
                        j++;    
                    }
                    while (j<k && arr[k]==arr[k-1]) {
                        k--;
                    }
                    //lastly one more time, as j and k are on their respective last ele with the same value as they were in initially
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        
        int[] arr = {1,0,-2,3,-1,};
        System.out.println(threeSum_brute(arr));
    }
}
