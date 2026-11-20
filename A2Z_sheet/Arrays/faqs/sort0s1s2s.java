public class sort0s1s2s {
    

    public void sortColors(int[] nums) {
        int n = nums.length;


        // simple bubble sort
        // tc = O(N^2);
            // for(int i = 0; i<n-1; i++){
            //     for(int j = i+1; j<n; j++){
            //         if(nums[j] < nums[i]){
            //             int temp = nums[i];
            //             nums[i] = nums[j];
            //             nums[j] = temp;
            //         }
            //     }
            // }


        // use the fact the array has only three elements
        // count each and paste it to the ans array

        int count0 = 0;
        int count1 = 0; 
        int count2 = 0;

        for(int i = 0;i<nums.length; i++){
            if(nums[i] ==0) count0++;
            else if(nums[i] == 1) count1++;
            else count2++;
        }

        int k =0;
        for(int i =0; i<count0; i++){
            nums[k] = 0;
            k++;
        }   
        for(int i=0; i<count1; i++){
            nums[k] = 1;
            k++;
        }
        for(int i =0; i<count2; i++){
            nums[k] = 2;
            k++;
        }
    }
}
