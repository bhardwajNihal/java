package Arrays.Tuf_sdeSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    

    // brute 
    // sort the intervals
    // merge in case of overlapping
    // condition, merge till the start time of the next interval is less than or equal to the end time of previous
    // Time Complexity: O(N*logN) + O(2*N), where N = the size of the given array.
    // Reason: O(N*logN) for sorting. Now, after that, we are using 2 loops i and j. But while using loop i, we skip all the intervals that are merged with loop j. So, we can conclude that every interval is roughly visited twice(roughly, once for checking or skipping and once for merging). So, the time complexity will be 2*N instead of N2.
    // Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except for the answer array, we are not using any extra space.
    public static int[][] mergeIntervals_brute(int[][] arr) {
        
        // sort
        Arrays.sort(arr,(a,b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        List<int[]> ans = new ArrayList<>();

        for (int i =0; i<arr.length; i++) {
            
            // start with the current interval
            int currStart = arr[i][0];
            int currEnd = arr[i][1]; 
            // update the end time, till it overlaps the previous interval
            while (i+1<arr.length && arr[i+1][0] <= currEnd) {
                currEnd = Integer.max(currEnd, arr[i+1][1]);
                i++;            
            }
            // add the current merged intervals to the ans
            // in case of 2nd last index, if merge happens, as i is incremented 2 time, one inside merge condition, and later after getting add to the ans, thus i goes outside the array, outer loop breaks
            ans.add(new int[]{currStart, currEnd});     // if 2nd last index don't overlap, inner loop will not run, thus i is incremented only once, and at last gets itself add to the ans, and outer loop breaks 
        }

        int[][] merged = new int[ans.size()][2];
        for(int k = 0; k<ans.size(); k++){
            merged[k] = ans.get(k);
        }
        
        return merged;
    
    }


    // better
    // by this approach, we compare and merge intervals in a single pass
    // Time Complexity: O(N*logN) + O(N)    // one for sorting, another for the single outer loop
    // Space Complexity: O(N) --> for the ans array
    public int[][] mergeIntervals_better(int[][] arr) {
        
       // sort
        Arrays.sort(arr,(a,b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        List<int[]> ans = new ArrayList<>();

        for (int i =0; i<arr.length; i++) {
            
            // in case of 1st interval, simply add it for further comparison
            if(i==0) ans.add(arr[i]);
            else{   // for subsequent intervals
                // just extract the last interval for the ans
                int[] prev = ans.get(ans.size()-1);     
                // check if the current interval, overlaps with the last one
                // if so, update the last intervals endtime, to be max of curr & prev intervals endtime
                if(arr[i][0] <= prev[1]) prev[1] = Integer.max(prev[1], arr[i][1]);
                else ans.add(arr[i]);       // in case of no overlap, just add the current interval
            }
        }
        int[][] merged = new int[ans.size()][2];
        for(int k = 0; k<ans.size(); k++){
            merged[k] = ans.get(k);
        }
        
        return merged;
    }


    public static void main(String[] args) {
        
        int[][] arr = {{1,4},{0,5}, {0,4}, {6,9}, {8,10}, {2,3}};
    
        int[][] merged = mergeIntervals_brute(arr);
//  Arrays.sort(arr,(a,b) -> {
//             if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
//             return Integer.compare(a[0], b[0]);
//         });

        for(int[] row : merged){
            System.out.print(Arrays.toString(row));
        }
    }
}
