package StacksAndQueues.Stacks.Questions;

public class TrappedRainwater {
    

// leetcode 42  

// 1st approach is brute force
    // using two arrays that store the leftgreatest elements, and same for the  right
    // at each index
        // the trapped rainwater will be the difference of height of the building  and mininum of the prefixMax, and suffixmax
    public int trap(int[] height) {
        
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int n = height.length;

        left[0] = height[0];
        for(int i=1; i<n; i++){
            left[i] = Integer.max(height[i], left[i-1]);
        };

        right[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] = Integer.max(height[i], right[i+1]);
        }

        // till this point we have the left(prefixMax), and right(suffixMax)

        int total = 0;

        for(int i =0; i<n; i++){
            total += Integer.min(left[i], right[i]) - height[i];
        }

        return total;
    }
}
