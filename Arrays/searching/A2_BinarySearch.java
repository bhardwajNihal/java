package Arrays.searching;

import java.util.Arrays;

public class A2_BinarySearch {

    public static void main(String[] args) {

        // int[] arr = { 2, 4, 5, 5, 5, 5, 9, 9, 9, 9, 14, 17 };
        // int[] arr2 = { 19, 15, 11, 7, 7, 4, 1, 1, 1, 0 };
        // int[] arr3 = {1,4,5,7,8,19,25,26,29,33,100,103,104,106,200, 199};

        // int[] arr4 = {1,20,15,11,10,9,5,3,2};
        // System.out.println(arr4[peakElement(arr4)]); 


        int[] RsArr = {15,20,25,3,6,8,10,12};
        int [] arr = {0,1,5,10,12,15,18,25,30};
        System.out.println(findPivotinRSArray(arr));
        // System.out.println(searchInRotatedSortedArray(RsArr, 3));


        // System.out.println(binarySearchOA(arr2, 15));
        // System.out.println(binarySearchOAFor1stIndexOfDuplicateEntries(arr, 5));
        // System.out.println(binarySearchOAFor1stIndexOfDuplicateEntries(arr2, 1));

        // System.out.println(binarySearchOAForLastIndexOfDuplicateEntries(arr, 5));
        // System.out.println(binarySearchOAForLastIndexOfDuplicateEntries(arr2, 1));

        // System.out.println(binarySearchInfiniteArr(arr3, 33));


        // System.out.println(Arrays.toString(BSTargetRange(arr, 50)));

        // System.out.println(Ceiling(arr, 7));
        // System.out.println(Floor(arr, 15));

        // char [] arr2 = {'a', 'c', 'd', 'e', 'h', 'j', 'k', 'l'};
        // int ceilingIdx = CeilingCharArr(arr2, 'g');

        // if(ceilingIdx==-1){
        // System.out.println("no ceiling!");
        // }
        // else System.out.println(arr2[ceilingIdx]);
    }

    // simple binary search (for ascending order sorted)
    static int binarySearch(int[] arr, int target) {

        int start = 0; // 0 3 4
        int end = arr.length - 1; // 6

        while (start <= end) {
            int mid = start + (end - start) / 2; // 3

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
// _______________________________________________________________________________________________________
    // order agnostic binary search
    // i.e. for array sorted in any order
    static int binarySearchOA(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;

            // if ascending
            if (isAsc) {
                if (arr[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (arr[mid] < target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }

        }
        return -1;
    }


// binary search in a given range
    static int binarySearchOAInRange(int[] arr, int target,int start, int end) {

        if (arr.length == 0 || start > end || start < 0 || end >= arr.length) return -1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;

            // if ascending
            if (isAsc) {
                if (arr[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (arr[mid] < target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }

        }
        return -1;
    }


// for floor and ceilling problem
    // not to the find the target --> if found return the target index straight away
    // for floor -> greatest ele < target
    // for ceilling -> smallest ele > target

    // Q. find the Ceiling value of the target i.e. smallest element >= the target
    // Array is always ascendingly sorted
    // Because floor and ceiling rely on order to make sense:

    // dry running gave a clear perspective,
    // when repeatedly halving the scope of the probable target range
    // if start overtakes end, the loop exits, and the start index is actually the
    // ceilling element
    static int Ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // what if the target is greater than the larget array element
        // in that case there will be no ceiling i.e. no element >= target
        if (arr[end] < target)
            return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;

        }
        return arr[start];
    }

    // Q. find the floor --> i.e. the largest element <= target
    // if start overtakes end, the loop exits, and the end index is actually the
    // floor element
    static int Floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // similarly, is the target is less than the smallest ele
        // there will be no floor element i.e. no ele <= target;
        if (arr[start] > target)
            return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;

        }
        return arr[end];
    }

    // find ceilling in a char arr
    // this time to return element strictly greater than not equals to
    // if any element equals to the target, simply return the next element
    // Cyclic order :
    // let say the target = last element ---> ans = 1st element
    static int CeilingCharArr(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;

        if (target == arr[end])
            return 0;
        if (target > arr[end])
            return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) // if mid holds the target index, just shift the start to next, let it be
                                    // continued from there
                start = mid + 1;
            else
                end = mid - 1;

        }
        return start;
    }




    // In case of DUPLICATE elements:
    // binary search to return the very 1st index of a target.
    static int binarySearchOAFor1stIndexOfDuplicateEntries(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                result = mid;

                end = mid - 1; // to search for probable 1st index, thus remain searching the left part
            }
            // else if is necessary unlike above, as it may conflict wiht the previous condition, or target ==arr[mid] and can manipulate start or end again, hence giving wrong result
            else if (isAsc) {                // if ascending, target>mid will always lie in the right portion
                if (target > arr[mid]) start = mid + 1;
                else end = mid - 1;
            } else {
                if (target > arr[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return result;
    }

    // to find the last the last index for the target
    static int binarySearchOAForLastIndexOfDuplicateEntries(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                result = mid;

                start = mid + 1; // to search for probable 1st index, thus remain searching the left part
            }
            else if (isAsc) {                // if ascending, target>mid will always lie in the right portion
                if (target > arr[mid]) start = mid + 1;
                else end = mid - 1;
            } else {
                if (target > arr[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return result;
    }
// ________________________________________________________________________________________



    // give the 1st and last index of the target elements in case of duplicates
    // Brute force --- not the best approach
    // O(n) --> not preferred, should be O(logN)
    // doesn't cover the edge cases.
    static int[] BSTargetRange(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        int r1 = -1;
        int r2 = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                r1 = r2 = mid;
            }

            if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        // if control reaches here, and r1, and r2 have -1, means no target found,
        // simply return -1;
        if (r1 == -1 && r2 == -1)
            return new int[] { -1, -1, };

        // another loop to iterate through the range
        // given r1 is not the 1st index, and r2 is not the last index

        while (r1 != 0 && arr[r1 - 1] == target) {
            --r1;
        }
        while (r2 != arr.length - 1 && arr[r2 + 1] == target) {
            ++r2;
        }

        return new int[] { r1, r2 };
    }


    // best solution to find the range : 
    // finds it in O(logN) complexity time
    public int[] BSTargetRangeOptmzd(int[] arr, int target) {

        int start = binarySearchOAFor1stIndexOfDuplicateEntries(arr,target);
        int end = binarySearchOAForLastIndexOfDuplicateEntries(arr,target);

        return new int[] {start,end};
    }



    // Binary Search in array of infinite length
    // i.e. end index in unknown, thus can't use the length attribute to determine end;

    // the approach is simple, 
    // the problem is simple binary search
    // just need to figure out the end index.
    // start with a range of 2. i.e s=0, e=1,
    // >> then exponetially grow the range of search --> 2 > 4 > 8 > 16 ...
    static int binarySearchInfiniteArr(int[] arr, int target){

        //start with the smallest range 
        int start = 0;
        int end = 1;

        // while the target is greater that the element at end index
        // just double the range and shift start and end to the right
        while(target > arr[end]){
            int temp = end+1;
            end = (end-start + 1)* 2;
            start = temp;
        }

        // thus we got the new range, just do simple bs in it;
        return binarySearchOAInRange(arr, target,start,end);

    }



    // find peak element in the mountain array
    static int peakElement(int[] arr){

        int start = 0;
        int end = arr.length-1;

        while (start<end) {
            int mid = start + (end-start)/2;
            
            if(arr[mid] < arr[mid+1]){ // depicts the increasing part of array

                start = mid + 1;     //probable target lies to the right
            } 
            else{
                end = mid;      // mid can be the probable target
            }
        }
        return start;       // both the start and the end will hold the peak element at the end of the loop, not mid this time
    }



    // find target in a mountain array
    // 1st principle's approach
    // -- > find peak element, then bs on both the parts

    // best probable solution
    static int searchInMountainArray(int[] arr, int target){

        int peak = peakElement(arr);

        int r1 = binarySearchOAInRange(arr, target, 0, peak);
        if(r1!=-1) return r1;

        int r2 = binarySearchOAInRange(arr, target, peak+1, arr.length-1);
        if(r2!=-1) return r2;

        return -1;
    }   

    

    // find pivot in rotated sorted array
    // will return -1, in case of fully sorted array, --> not rotated -> no pivot.
    // For array with unique elements
    static int findPivotinRSArray(int[] arr){

        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

        // there just 4 cases to conder

        // at the pivot element, the next element is always lesser
        // so check if the current mid or the neighbouring elements are the potential pivot
            if(mid<end && arr[mid] > arr[mid+1]) return mid;
            if(mid>start && arr[mid] < arr[mid-1]) return mid -1;

        // both above cases are not there
        // then :
        // if start is greater than mid
            // then certainly all the elements after the mid index is lesser than the start
            // thus no way to find pivot in that region, hence end is shift pre mid;
            else if(arr[start] >= arr[mid]) end = mid-1;

        // else if the start is less then mid,
            // then in no way pivot lie between start and mid
            // also if mid was the pivot that case should have been handled in case 1,2
            // hence new range right of mid, i.e. mid+1 to end
            else start = mid+1;
        }

        return -1;
    }


    // find in rotated sorted array
    static int searchInRotatedSortedArray(int[] arr, int target){
       
        int pivot = findPivotinRSArray(arr);

    // now simple Binary search in both the range
        int r1 = binarySearchOAInRange(arr, target, 0, pivot);
        if(r1!=-1) return r1;

    // in case the pivot = -1 --> array is not rotated at all
    // then search will happen from simply index (-1 + 1 ==0) to end.
        int r2 = binarySearchOAInRange(arr, target, pivot+1, arr.length-1);
        if(r2!=-1) return r2;

        return -1;
    }


    
    // find no. of times a sorted array is rotated
    // simple find pivot
        // ==> (pivot + 1) is the answer





}
