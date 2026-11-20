package A2Z_sheet.Strings;

public class checkRotated {
    

    
    // utility function to swap a substring
    public String reverse(String str, int s, int e){
        
        char[] arr = str.toCharArray();

        int i = s; 
        int j = e; 

        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return new String(arr);

    }

    // now utility function to rotate by k steps
    public String rotate(String str, int k){

        // reverse 1st k ele
        String str1 = reverse(str, 0, k-1);
        String str2 = reverse(str, k, str.length()-1);

        // now reverse the whole string
        String wholeStr = str1.substring(0,k)+str2.substring(k,str.length());

        String rotated = reverse(wholeStr, 0, wholeStr.length()-1);

        return rotated;
    }


    public boolean rotateString(String s, String goal) {
        
        if(s.equals(goal)) return true;
        // now rotate the given string incrementally from 1 to n
        // and at each step, compare it with the goal

        for(int i =1; i<s.length(); i++){

            String rotated = rotate(s,i);
            if(rotated.equals(goal)) return true;
        }

        return false;


    }
}
