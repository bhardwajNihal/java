package Arrays.Tuf_sdeSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum {
    

    // brute
        // simply run 4 nested loops
        // not a good idea to have O(N^4) TC

    
    // the better approach,
        // with time complexity of  ~= O(N^3)
        // space complexity = O(N) + O(no. of quadruplets)  --> O(n) for the max possible ele in the hashmap inside the 2nd loop
        // same as the 3sum
       public static List<List<Integer>> fourSum_better(int[] arr, int target) {
        
        // the better approach,
        // same as the 3sum
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                // using long type as sum, and target at times can become too big for int
                Map<Long, Integer> map = new HashMap<>();
                for(int k = j+1; k<arr.length; k++){
                // sum at times can exceed the int limit
                    long sum = (long) arr[i] + arr[j] + arr[k];
                    long fourth = (long) target - sum;

                    if(map.containsKey(fourth)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add((int)fourth);      // typecasting back to int before storing to temp as  final ans contains list of int, so found target must be int
                        temp.sort(null);
                        set.add(temp);
                    }
                        map.put((long) arr[k],k);
                    
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;
    }



    // TC = O(N^3) + NlogN
    // SC  = O(no. of quads)  
    public List<List<Integer>> fourSum_optimal(int[] arr, int target) {
        
        // the optimal approach is again same as the optimal one for the 3sum

        // sort the entire array
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        // two outer fixed loops
        for(int i =0;  i<arr.length-1; i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j =i+1;  j<arr.length; j++){

                if(j>i+1 && arr[j]==arr[j-1]) continue;       // to continue with iteration even if duplicate
                int k = j+1;
                int p = arr.length-1;

                while(k<p){
                // typecasting to avoid integer overflowing
                    // (long)arr[i] promotes the whole expression to long.
                    // Now instead of overflowing at 2.1e9, it can safely hold up to 9e18.
                    long sum = (long)arr[i] + arr[j] + arr[k] + arr[p];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[p]);
                        ans.add(temp);
                        k++;
                        p--;
                        while(k<p && arr[k]==arr[k-1]){     // to eliminate duplicates
                            k++;
                        }
                        while(p!=arr.length-1 && k<p && arr[p]==arr[p+1]){
                            p--;
                        }
                    }
                    else if(sum < target) k++;      // to increase the sum
                    else p--;                       // to decrease the sum
                    
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,5,2,7,6,5,3,4,2};
        List<List<Integer>> ans = fourSum_better(arr, 11);
        System.out.println(ans);
    }
}
