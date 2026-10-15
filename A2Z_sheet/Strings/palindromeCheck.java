package A2Z_sheet.Strings;

public class palindromeCheck {
    

// separate utility functions 

// alphanumeric check
boolean isAlphanumeric(char c){
    if((c >=65 && c <= 90) || 
        (c >=97 && c <= 122) || 
        (c >= '0' && c <= '9')
    ) return true;

    return false;
}

// to convert to lowercase
char toLowerChar(char c){
    if(c >='A' && c <= 'Z') return (char)(c + 32);
    return c;
}


// Optimal approach
    public boolean isPalindrome(String s) {

        
        int i = 0; 
        int j = s.length()-1;


        while(i<j ){

            while(i<s.length() && !isAlphanumeric(s.charAt(i))) i++;
            while(j>=0 && !isAlphanumeric(s.charAt(j))) j--; 

            // if traversal complete yet no valid alphanumeric found, 
            // it means string only has special characters, return true in this case
            if(i== s.length() && j==-1) return true;

            if(toLowerChar(s.charAt(i)) != toLowerChar(s.charAt(j))) return false;

            i++; j--;
        }

        

      return true;
       
    }




}
