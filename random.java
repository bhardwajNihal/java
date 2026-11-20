import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class random {
    
    public void swap(String str){

        char[] arr = str.toCharArray();
        char temp = arr[0];
        arr[0] = arr[arr.length-1];
        arr[arr.length-1] = temp;

        String ans = "";

        for(char ele : arr){
            ans += ele;
        }
        str = ans;

    }

    public static void main(String[] args) {


        
    }
        
        
}
