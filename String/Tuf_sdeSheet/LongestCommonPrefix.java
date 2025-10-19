package String.Tuf_sdeSheet;

public class LongestCommonPrefix {
    

    public String longestCommonPrefix(String[] strs) {
        
        
        // finding the length of the min length word (to make sure comparison doesn't lead to indexoutofbound)
        int min = Integer.MAX_VALUE;
        for(String word : strs){
            min = Integer.min(min, word.length());
        }

        StringBuilder common = new StringBuilder();

        int i = 0;  // to iterate over each letter
        
        while(i<min){

            // iterate over each word

            boolean check = true;       // a flag to check if the current index char of each word is same
            for(int j =0; j< strs.length-1; j++){
                if(strs[j].charAt(i) != strs[j+1].charAt(i)) {  // break out of the inner loop on mismatch
                    check = false;
                    break;
                }
            }

            if(check) {     // if no mismatch found, add the current char, increase the char counter
                common.append(strs[0].charAt(i));
                i++;  //move to next letter
            }
            else break;     // on mismatch break out of even the outer loop

        }

         return common.toString();
    }

   
}
