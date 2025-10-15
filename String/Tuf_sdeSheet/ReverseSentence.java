package String.Tuf_sdeSheet;

import java.util.Stack;

public class ReverseSentence {
    public String reverseWords(String s) {
        
        Stack<String> st = new Stack<>();
        int start =0;
        int n = s.length();
        while(start<s.length()){

            

            // removing trailing spaces
            while(start<n && s.charAt(start) == ' ') start++;
            if (start >= n) break; // if start reaches the end break out of the loop
                                    // or else trailing spaces might be added

            // removing leading spaces
            int end = start;
            while(end<n && s.charAt(end) != ' ') end++;

            // extract the word, push to stack

            st.push(s.substring(start,end));

            start = end;

            

        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
            if (!st.isEmpty()) ans.append(" ");
        }

        return ans.toString();
    }
}
