import java.util.ArrayList;
import java.util.Arrays;

public class rand {
    

    public static void main(String[] args) {
        
        String s = "0P";
       // purifying the string
       char[] arr = s.toCharArray();

        String str1 = "";
        String str2 = "";

        
        for(int i =0; i<arr.length; i++){
            int val = (int) arr[i];
            if( (val >=65 && val <=90) || (val >=97 && val <=122) || (val >=49 && val <=57)) str1 += arr[i];
       }

       System.out.println(str1.toLowerCase());
       for(int i =arr.length-1; i>=0; i--){
            int val = (int) arr[i];
            if( (val >=65 && val <=90) || (val >=97 && val <=122) || (val >=49 && val <=57) ) str2 += arr[i];
       }

       System.out.println(str2.toLowerCase());

       boolean isp =  str1.equals(str2);

       System.err.println(isp ? "true" : "false");
        

    }
}
