package A2Z_sheet.Recursion.fundamentals;

public class palindromeString {
    

     // utility function that takes both front and back index as parameter
    public boolean palCheck(String str, int f, int b){

        if(f>=b) return true;
        
        return (str.charAt(f) == str.charAt(b)) && palCheck(str, f+1, b-1);
    }


    public boolean palindromeCheck(String s) {
        //your code goes here

        return palCheck(s,0, s.length()-1);
    }
}
