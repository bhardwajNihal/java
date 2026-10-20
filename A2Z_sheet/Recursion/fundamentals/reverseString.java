package A2Z_sheet.Recursion.fundamentals;

public class reverseString {
    

    // Recursive approach
    // track back and front
    // swap recursively
    public void revStr(char[] str, int i, int j){

        if(i>=j) return;
        char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        revStr(str, ++i, --j);

    }
    
    
    public void reverseString(char[] s) {
        
        revStr(s, 0, s.length-1);       // calling recursive func
        
    // Loop Approach
        // int i=0;
        // int j = s.length-1;

        // while(i<j){
            
            // char temp = s[i];
            // s[i] = s[j];
            // s[j] = temp;
        //     i++;
        //     j--;
        // }
    }
}
