
import java.util.ArrayList;

public class ReaarrangeEle {
    

      // brute force
    // track a boolean var for when +ve ele and when -ve ele is to be added 
    // and a/c to the bool flag find the +ve or -ve element
    // everytime the ele is added to the ans list, reverse the bool value.
    // tc = O(n^2)
    // sc = O(n) for the extra list and ans arr.

    public int[] rearrangeArray_brute_I(int[] nums) {
        
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        boolean positive = true;

        for(int i=0; i<n; i++){

            int j =0;
            if(positive){
                while(nums[j] <= 0) j++;
                list.add(nums[j]);
                nums[j] = 0;        // reassign the ele to zero, to avoid adding again
                positive = false;
                
            }
            else{
                while(nums[j] >= 0) j++;
                list.add(nums[j]);
                nums[j] = 0;
                positive = true;   
            }
        }
        // add to arr
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }



    // brute appraoch
    // maintain a separate +ve and -ve array
    // put the elements back alternatively to the final array
    // tc = O(3n)
    // sc = O(3n)

    public int[] rearrangeArray_brute_II(int[] nums) {
        
        int n = nums.length;
       ArrayList<Integer> pos = new ArrayList<>();
       ArrayList<Integer> neg = new ArrayList<>();

       for(int i = 0; i<n;i++){
        if(nums[i] > 0) pos.add(nums[i]);
        else neg.add(nums[i]);
       }

       ArrayList<Integer> list = new ArrayList<>();

       int i = 0;

       while(i<pos.size()){
        list.add(pos.get(i));
        list.add(neg.get(i));
        i++;
       }

        int[] ans = new int[n];
       for(int j =0; j<n; j++){
        ans[j] = list.get(j);
       }
       return ans;
    }



    // optimal
    // aproach - as the even places holds +ve value and odd places -ve
    // so in the ans array - just keep track of the last -ve and +ve index 
    // and as iterating once, add respective eles to their respective places.
    // this way we optimized the time complexity a bit
    // from O(3n) to O(n)


    // optimal
    // aproach - as the even places holds +ve value and odd places -ve
    // so in the ans array - just keep track of the last -ve and +ve index 
    // and as iterating once, add respective eles to their respective places.
    // this way we optimized for the constant space
    // this way we optimized the time complexity a bit
    // from O(3n) to O(n)

    public int[] rearrangeArray_optimal(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n];

        int eIdx = 0;
        int oIdx = 0;

        for(int i =0; i<n; i++){
            if(nums[i] > 0){
                arr[eIdx * 2] = nums[i];
                eIdx++;
            }
            else{
                arr[(oIdx*2)+1] = nums[i];
                oIdx++;
            }
        }
      return arr;
    }


}
