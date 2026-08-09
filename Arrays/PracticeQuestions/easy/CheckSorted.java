package Arrays.PracticeQuestions.easy;

public class CheckSorted {
    

    public static void main(String[] args) {
        
        int[] arr = {1,2,3,1,5,6,7};
        
        boolean sorted = checkSorted(arr);
        System.out.println(sorted ? "true" : "false");
    }


    // brute force, O(N^2): start from 1st and iterate each element, check if it's smaller than or equal to all the element to the right to it, return true, at last, else false
    
    // optimal approach : start from last element, chech with the previous one, continue till 1st
    // O(N), single traversal, no extra space needed so space complexity = O(1)
    public static boolean checkSorted(int[] arr){

        for(int i = arr.length-1; i>0; i--){

            if(arr[i] < arr[i-1]) return false;
        }
        return true;


    }
}