package Arrays.Tuf_sdeSheet;

public class Sort_0s_1s_2s {
    

    // brute
    // just sort the array
        // for let say merge sort, TC = O(NlogN), and space is constant

    // better
    // just count all the element and then overwrite to the array
    // TC = 2*O(N) ~ = O(N); SC = O(1)


    // optimal
    // tc = O(N), done in 1 go, space is constant
        // approach
        // three pointer approach
        // take tree pointers low, mid, and high, only to move the mid one
        // till low there should be only 0s
        // till mid ==> 1s
        // after high ==> 2s
        // between mid and high, the unsorted part
        // looking the patter, swap the values
        public static void sort012_opt(int[] arr)
    {
        
        int l = 0; 
        int m = 0;
        int h = arr.length-1;

    while(m<=h){

        // If arr[mid] == 2: push it to the right side (high), and only decrease high 
        // (don’t increase mid yet, because the swapped element may be 0/1/2, so we need to re-check it).
        if(arr[m]==2){
            int temp = arr[m];
            arr[m] = arr[h];
            arr[h] = temp;
            h--;
        }
        // If arr[mid] == 1: it’s already in the middle, so just move mid.
        else if(arr[m]==1){
            m++;
        }
        // If arr[mid] == 0: push it to the left side (low), then increase both low and mid.
        else {
            int temp = arr[m];
            arr[m] = arr[l];
            arr[l] = temp;
            l++;
            m++;
        }
    }

        
    }

}
