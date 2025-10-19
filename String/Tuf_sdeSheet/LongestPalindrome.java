package String.Tuf_sdeSheet;

public class LongestPalindrome {
    

    // check palindrome function
    static boolean isPalindrome(String str){

        int i =0; 
        int j = str.length()-1;

        while(i<j){

            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        
        int m = s.length();

        int max = 0;
        int idx1 = 0;
        int idx2 = 1;

        for(int i = 0; i<m; i++){
            for(int j= i+1; j<=m; j++){

                //extracting substring
                String sub = s.substring(i,j);
                
                // check if it's a palindrome
                if(isPalindrome(sub)){
                    if(sub.length() > max){
                        max = sub.length();
                        idx1 = i;
                        idx2 = j;
                    }
                }
            }
        }
        return s.substring(idx1, idx2);       
    }
}
