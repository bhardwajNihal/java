package A2Z_sheet.Strings;

public class largestOddSubstring {
    


    public String largestOddNumber(String str) {

        // iterate backwards
        // on finding an odd digit, return substring from start till that digit


        for(int i = str.length()-1; i>=0; i--){

            int ld = str.charAt(i) - '0';       // to get that decimal value and not the ASCII value

            if(ld%2 != 0) return str.substring(0, i+1);     // as substring is exclusive
        }

        return "";
    }

    
}