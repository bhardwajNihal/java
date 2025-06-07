package Arrays;
public class DS_2_Strings {


    // strings
        // series of characters.
    // string pooling
        // whenever variable is initialized, its value is stored into a string pool into the heap memory
        // when any other variable is given the same value it just points that value is the string pool, no other object is created with the same value
    // is immutable
        // when the value is changed, the previous value just remains in the string pool, 
        // just another object is created and the variable now points to the new location, the previous value is intact.

    // String builder is used to append a value to a pre-defined string  in O(N) time and space complexity
    // in the traditional way
        // when a value is appended, the old string remains intact
        // a new object is created, all previous value is copied to this, then the new value is add
        // so not so optimized, worst case O(N^2) time, and O(N) space complexity

    // string methods
    // done in the basics folder
    
    public static void main(String[] args) {
        
        System.out.println(checkPalindrome2("raceecarb"));
    }


    static boolean checkPalindrome(String word){

        if(word==null || word.length()==0) return true;

        word = word.toLowerCase();
        char[] chars = word.toCharArray();

        int i =0;
        int j = chars.length-1;

        while (i<j) {
            if(chars[i] == chars[j]){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }


    // or
    static boolean checkPalindrome2(String word){

        word = word.toLowerCase();

        int i =0;
        int j = word.length()-1;        // for string, lenght is a method, needs to be called with ()

        while (i<j) {
            
            if(word.charAt(i) != word.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }

}
