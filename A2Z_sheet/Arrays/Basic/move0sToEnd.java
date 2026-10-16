package A2Z_sheet.Arrays.Basic;
class Solution {
    public void moveZeroes_brute(int[] nums) {
        
        // brute
        // intitialize an emtpy array and fill it with zeroes
        // copy all the non-zero elements of the original array to this

        int n = nums.length;
        int[] arr = new int[n];         // java auto fills arr with 0

        int i = 0;
        int j = 0;
        while(i<n){
            if(nums[i] != 0){
                arr[j] = nums[i];
                j++;
            }
            i++;
        }
     
    // now copy back ele of arr to nums
    for(int k = 0; k<n; k++){
    nums[k] = arr[k];
    }

    }


    public void moveZeroes_better(int[] nums) {
        

      // better
      // two pointer approach
      // more zeroes inplace
        // take two pointers one each at the start
        // start writing non-zero elements from the start of the arr
        // once reached to the end of the arr, fill rest positions with 0

      
        int n = nums.length;
        int j= 0;

        for(int i =0; i<n; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }

        // now from jth position to end, put 0s
        for(int i = j; i<n; i++){
            nums[i] = 0;
        }

    }



    public void moveZeroes_optimal(int[] nums) {
        

    // optimal approach
    // non 0 elements can be moved in-place
    // no extra traversal for putting zeroes at the end

    int n = nums.length;
    int i =0; 
    int j = 0; 

    while(i<n && j<n){ 

        if(nums[i]==0){         // if ith and jth both element becomes 0, increment j till non-zero no. found.
            while( j<n && nums[j]==0) j++;
        }
        
        if(i==n || j==n) return;
        // swap
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;j++;
    } 

}



}