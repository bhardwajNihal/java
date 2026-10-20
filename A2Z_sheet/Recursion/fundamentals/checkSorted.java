package A2Z_sheet.Recursion.fundamentals;

import java.util.ArrayList;

public class checkSorted {
    
// utility function to check sorted recursively
// takes the tracking index as parameter
     public boolean sortCheck(ArrayList<Integer> arr, int i){

        if(i==arr.size()-1) return true;
        return (arr.get(i) <= arr.get(i+1)) && sortCheck(arr, i+1);
    }
    public boolean isSorted(ArrayList<Integer> nums) {
        
        return sortCheck(nums,0);
    }
}
