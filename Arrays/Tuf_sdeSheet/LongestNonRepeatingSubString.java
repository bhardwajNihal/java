package Arrays.Tuf_sdeSheet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestNonRepeatingSubString {
    

    // leetcode 3
    // given a string, find out the longest substring without reapeating characters

    // brute
    // use of nested loops
    // add every unique elements to the set, 
    // maintain the largest size of the set
    // in case of duplicate ele, break out of inner loop
    // reset the set, start checking from next ele
    // Worst case time complexity is O(N^2)
    // SC = O(N) in worst case, when all ele are unique
    static int longest_brute(String s){

       if(s.length()==1) return 1;
         
        int longest = 0;
        for(int i = 0; i<s.length(); i++){
            Set<Character> set = new HashSet<>(); // set reset on every outer loop iteration

            for(int j = i ; j<s.length(); j++){
                
                if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));       // add unique
                longest = Integer.max(longest, set.size());     // add the current length of the set
                }
                else{   // if(found duplicate, break out of the inner loop look of substrings for next char)
                    break;
                }

            }

        }
        return longest;

    }

    public static void main(String[] args) {
        
        String s = "abbbccde";
        System.out.println(longest_brute(s));
    }
}
