package StacksAndQueues.Stacks.Questions;

import java.util.Stack;

public class RemoveDuplicateSeq {
    

    
// given an array, remove all the consecutive subsequence with 2 or more duplicates
    // {1,2,2,3,4,4,4,9,6,6,6,6,5} ===> {1,3,9,5}       // completely remove if consecutive duplicates
public static int[] removeDupSubsequence(int[] arr){

    Stack<Integer> st = new Stack<>();

    // loop through the arr, maintain stack for unique eles
    for(int i = 0; i< arr.length; i++){
        // if stack is empty or the the top ele mismathches simply push
        if(st.isEmpty() || arr[i] != st.peek()) st.push(arr[i]);

        // if the top ele match, we need to make sure that the very next ele is also not the same
        // as, of odd no. of duplicate entries, the last element will be isolated
        // so, only to pop when the next ele is different. 
        // if reached the last index of the array, simply pop, if matches the peek
        else if(arr[i] == st.peek()){
            if(i==arr.length-1 || arr[i] != arr[i+1]) st.pop();
        }
    }

    int[] ansArr = new int[st.size()];
    for(int i = st.size()-1; i>0; i--){
        ansArr[i] = st.pop();
    }
    return ansArr;

}


}
