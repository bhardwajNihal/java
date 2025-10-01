package Arrays.PracticeQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class Ques {
    

    public static int countTargetPair(int[] arr, int target){

        int count = 0;
        for(int i =0; i< arr.length; i++){

            for(int j=i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == target) count++;
            }
        }
        return count;
    }

    public static int countTargetTriplets(int[] arr, int target){

        int count = 0;
        for(int i =0; i< arr.length; i++){

            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    if(arr[i] + arr[k] + arr[j] == target) count++;
                }
            }
        }
        return count;
    }


    // find unique where all the ele are repeated twice
    // let say array has only positive ele
    public static int findUnique(int[] arr) {
        for(int i =0; i< arr.length; i++){
            for(int j =0; j< arr.length; j++){
                if(arr[i] == arr[j] && i!=j){
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
        }
        // now check if any ele is != -1;
        int ans = -1;
        for(int i =0; i< arr.length; i++){
            if(arr[i] != -1 ) ans = arr[i];
        }
        return ans;
    }

    // given array of positive integers, find 2nd largest element
    static int secondLargestEle(int[] arr){

        int max = -1;
        int sec = -1;

        for(int i =0; i< arr.length; i++){
            if(arr[i] > max){       // if ele is greater than max, then before updating max
                sec = max;          // put current largest to sec, as its potential 2nd largest
                max = arr[i];
            }
            else{
                if(arr[i] == max) continue;     // if all ele are equal, theres no 2nd largest, skip putting to 2nd largest
                if(arr[i] > sec) sec = arr[i];
            }
        }
        
        return sec;
    }

    // given an array of unique ele, return 1st duplicate, if no duplicate found return -1;
    public static int findDup(int[] arr){

        int ans = -1;
        for(int i = 0; i<arr.length-1;i++){
            for(int j = i+1; j<arr.length;j++){
                if(arr[i] == arr[j]) return arr[i];
            }
        }

        return ans;
    }

    // Ques
    // given an array, with value of any element is not greater than 10^5
    // and given n no. of queries
    // tell if the query  is present in the array or not.
        // simple approach
            // as the max possible value of ele of the array is given upfront
            // create a frequency array of the max ele size, with all ele initially 0
            // now iterate over the array, for the current ele, increment corresponding index in the frequency array

            // later when queries are given, check of the corresponding index in the freq array
            // if non-zero value is found means the ele is present



    // segregate arr with only 0s and 1s
        void segregate0and1(int[] arr) {
            int i =0;
            int j = arr.length-1;
            while(i<j)
            {
                if(arr[i]==1 && arr[j]==0){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
                if(arr[i]==0) i++;
                if(arr[j]==1) j--;  
            } 
        }


    // segregate odd and even values, with evens at the start, return in sorted order
    public static void segregateEvenOdd(int arr[]) {
        // code here
        int left =0;
        int right = arr.length-1;
            while(left<right)
            {
                if(arr[left]%2==1 && arr[right]%2==0){
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
                if(arr[left]%2==0) left++;
                if(arr[right]%2==1) right--;  
            } 

        // till here even and odd elements are segregated
        System.out.println(" segregated: " + Arrays.toString(arr));
      
        // count even no.s
        int countEven = 0;
        for(int i =0; i<arr.length; i++){
            if(arr[i]%2==0) countEven++;
        }
        System.out.println("even count : " + countEven);
        
        // now sort the even and the odd parts separately
        
    // sorting the even half
       for(int i = 0; i < countEven-1; i++){

            // inner loop will start from just i+1, will go reverse till j>=0
            for(int j = i+1; j>0; j--){

                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                else{
                    break;          // in any case if the previous element is lesser than current, this means the elements behind are already sorted, no need to further iterate
                }
            }
        }

        // till here the even part is sorted
        System.out.println("even part sorted : " + Arrays.toString(arr));
        
    // sorting rest of the array, with odd ele
    for(int i = countEven; i < arr.length-1; i++){

            // inner loop will start from just i+1, will go reverse till j>=0
            for(int j = i+1; j>countEven; j--){

                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                else{
                    break;          // in any case if the previous element is lesser than current, this means the elements behind are already sorted, no need to further iterate
                }
            }
        }

        System.out.println("odd part sorted : "+ Arrays.toString(arr));  
    }


    public static int[] prefixSum(int arr[]){

        int ans[] = new int[arr.length];
        ans[0] = arr[0];
        for(int i =1;i<arr.length; i++){
            ans[i] = arr[i] + ans[i-1];
        }

        return ans;
    }

    // given sum in a given range of an array
    public static int sumRange(int[] arr, int s, int e) {
        
        int[] prefixSumArr = prefixSum(arr);
        if(s ==1 ) return prefixSumArr[e-1];

        return prefixSumArr[e-1] - prefixSumArr[s-2];       // as s,e are 1 based indexed
    }


    // given an array check whether it can be divided into  two subarrays of same sum
        // approach
        // start from the 1 ele, compare it sum of range of remaining ele
        // repeat this till the last ele
        // sum of ranges till the current ele, and that of the remaining ele

    static boolean subArrWithSameSum(int[] arr){
        // e.g. 1,2,6,4,5 --> 1,2345; 12,345; 123,45; 1234;5

        for(int pos=1; pos<=arr.length; pos++){
            if(sumRange(arr, 1, pos) == sumRange(arr, pos+1, arr.length)) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        
        // int[] arr = {1,2,3,7,8,4,5};
        // System.out.println(countTargetPair(arr, 11));
        // System.out.println(countTargetTriplets(arr, 11));

        // int[] arr2 = {1,35, 12,15, 10, 34};
        // // System.out.println(findUnique(arr2));
        // System.out.println(secondLargestEle(arr2));

        // System.out.println(findDup(arr2));

        // segregateEvenOdd(arr2);
        // System.out.println(Arrays.toString(arr2));

        int[] arr = {4,2,4};
        // System.out.println(Arrays.toString(prefixSum(arr)));

        // System.out.println(sumRange(arr, 1, 5));
        System.out.println(subArrWithSameSum(arr));

        ArrayList<Integer> list = new  ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);

        System.out.println(list.contains(2));

        
    }

}
