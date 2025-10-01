package Arrays.Tuf_sdeSheet;

public class DuplicateEle {
    

    // given an array of n+1 size
    // holding values from 1 to n
    // there's a duplicate ele, find that

    // 1st approach - brute
    // sort the arr
    // then traverse it, the moment when arr[i] == arr[i+1], a[i] is the duplicate one

    
    // 2nd approach - using hashing
    // maintain another array of size n, default to 0 at all index
    // start traversing the given array, for any ele, mark the corresponding index in the 2nd array as 1;
    // at any point if the 2nd arrays ele appears to be 1 already, means it was marked earlier, it's the answer


    // third approach is the cycle sort approach
    static void swap(int[]arr, int index1, int index2){

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }
    public int findDuplicate(int[] arr) {
        int i =0;
        while (i<arr.length) {
            
            if(arr[arr[i]-1]!= arr[i]) swap(arr, i, arr[i]-1);
            else i++;
            
        }
        return arr[arr.length-1];  // every index moved to their desired place
                                    // the duplicate one is push to the last
    }

}
