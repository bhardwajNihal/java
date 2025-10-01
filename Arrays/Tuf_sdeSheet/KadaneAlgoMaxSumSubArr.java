package Arrays.Tuf_sdeSheet;

public class KadaneAlgoMaxSumSubArr {
    
    // given an int array, give the subarray with the max sum
    // brute
    // TC = O(N^3), sc is constant
    // bad approach, gives tle
     public int maxSubArray_brute(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // subarray = arr[i.....j]
                int sum = 0;

                //add all the elements of subarray:
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                maxi = Math.max(maxi, sum);
            }
        }

        return maxi;
    }


    // better approach
    // TC = O(N^2), constant space
    // still gives TLE
    public int maxSubArray_better(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // subarray = arr[i.....j]
                    sum+=arr[j];

                maxi = Math.max(maxi, sum);
            }
        }

        return maxi;
    }


    // optimal approach
    // using Kadane's Algorithm
    // single iteration
    // TC = O(N)
    public int maxSubArray(int[] arr) {
    
        int max = Integer.MIN_VALUE;
        int sum = 0; 

        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            
            max = Integer.max(max,sum);
            if(sum<0) sum =0;       // if at any point the sum of subarray is -ve, considering it for further sum calcultions will always contribute -vely, alway decreasing the net sum, so there's no meaning to consider the -ve sum at all, just put sum to 0, then calculate further
        }

        return max;

    }
}
