package A2Z_sheet.Strings;


public class largestCommonPrefix {
    
public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0) return "";

        String str1 = strs[0];
        
        int i =1;
        while(i<strs.length){

            String str2 = strs[i];

            int n = Integer.min(str1.length(), str2.length());

            // now scan both the string left to right, till they are same
            int j = 0; 

            String currLTP = "";
            while(j<n){

                if(str1.charAt(j) == str2.charAt(j)){
                     currLTP += str2.charAt(j);
                     j++;
                }
                else break;
            }     

            str1 = currLTP;
            i++;

        }
        
        return str1;
    }
}
