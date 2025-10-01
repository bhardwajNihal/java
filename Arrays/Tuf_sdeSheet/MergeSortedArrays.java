package Arrays.Tuf_sdeSheet;

public class MergeSortedArrays {
    

    // we have to merge two given sorted arrays
    // but instead of returing the merged single answer array
    // given arrays should be having all the elements in sorted fashion

        // e.g. {2,3,6}, {1,4,5,7} ===> {1,2,3}, {4,5,6,7};


    // brute
    // approach is simple
    // just normally store all the ele in an extra ans array(of combined size) in sorted order, using the two pointer approach
    // then put the elements back to the given array, in sorted order


    // better
    // take two pointer
    // one at the last index of the 1st array
    // 2nd to be at the 1st index of the 2nd array
    // observation
        // if the arr1[last] is smaller than the arr2[1st] --> both arrays combined are already sorted, no need to do any thing
        // if not so
            // let say the 1st ele of the 2nd arr is smaller than the last ele of the 1st arr
            // then ideally that ele should be in the 1st array as combined they need to be sorted

    // so, 
    // take two pointers, one at the last index of the 1st arr, 2nd at the 1st index of 2nd arr
    // compare, and swap
    // move both the pointers
    // run till any one of the array exhausted
    // now we have correct elements in both arr
    // lastly simply sort both arr
}
