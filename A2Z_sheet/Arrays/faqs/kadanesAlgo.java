public class kadanesAlgo {
    

     public int maxSubArray(int[] nums) {
        

        // best approach - kadane's algo
        // over a single iteration, calculate running sum and update max accordingly
        // but if at any point sum becomes -ve, drop the prev value and reset sum to 0
        // this is because, the -ve value will in any way affect the sum -vely, and only will reduce the sum.
        // so once the sum is 0, consider only the +ve element and continue

        // tc = O(N)
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i< n; i++){
            sum+=nums[i];
            if(sum > max) max = sum;
            if(sum < 0) sum =0;
        }
        return max;
    }
}
