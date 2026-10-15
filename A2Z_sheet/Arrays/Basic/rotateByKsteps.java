package A2Z_sheet.Arrays.Basic;

public class rotateByKsteps {
    
    void rightShift(int[] arr){

// BRUTE FORCE APPROACH
        // // temp array to store shifted ele
        // int[] temp = new int[arr.length];
        int n = arr.length;

        // for(int i = 0; i<n-1; i++){
        //     temp[i+1] = arr[i];
        //  }
        // // now put the last ele of arr to the 1st spot of temp
        // temp[0] = arr[n-1];

        // // lastly copying temp to arr
        // for(int i = 0; i<n; i++){
        //     arr[i] = temp[i];
        //  }



// BETTER - still gives tle

    // copy each element to the right in place
        // store the last element
        int last = arr[n-1]; 
    for(int i = n-1; i>0; i--){
        arr[i] = arr[i-1];
    }
    arr[0] = last;
    }


    public void rotate(int[] nums, int k) {
        
        // now call the right shift function k times
        k = k%n;    // to get the net rotations if k>n
        for(int i =0; i<k; i++){
rightShift(nums);
        }
    }





// OPTIMAL 
    void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        if (n == 0) return;

        k = k % n;

        // Reverse the entire array
        reverse(nums, 0, n - 1);

        // Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Reverse the remaining elements
        reverse(nums, k, n - 1);
    }
}
