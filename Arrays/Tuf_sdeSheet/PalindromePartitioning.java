package Arrays.Tuf_sdeSheet;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    

    // approach
        // At every index start in string s, try to cut the string into a prefix s[start..end].
        // If that prefix is a palindrome, include it in current partition and recurse from end+1.
        // If you reach the end of the string, that’s a valid partition → add to answer.
        // Backtrack by removing last chosen substring.

    // TC = O(2^N)*O(N/2)*K, ---> 2^N to produce each substring, n/2 for palindrome check, k for insertion to the processed array, of avg length k
    // SC = O(k*x) + O(N), ---> for avg length of each list, if x such list in the final ans list, N is the avg depth of recursion
    
    static void partition(String s, int start, List<String> pArr, List<List<String>> ans){

        //  base case, if start reaches end add to the ans
        if(start == s.length()){
            List<String> temp = new ArrayList<>(pArr);
            ans.add(temp);
            return;
        }

        for(int i = start; i<s.length(); i++){                                   
                                                                                 
            // check if the current substring is a palindrome or not             
            if(isPalindrome(s,start,i)){                                         
                pArr.add(s.substring(start,i+1));       // substring is exclusive
                partition(s,i+1, pArr,ans);                                      
                pArr.remove(pArr.size()-1);                                      
            }                                                                    
        }
    }

    static boolean isPalindrome(String str, int s, int e){
        int i = s;
        int j = e;

        while(i<j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
