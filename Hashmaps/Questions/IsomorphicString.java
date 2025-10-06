package Hashmaps.Questions;

import java.util.*;

public class IsomorphicString {
    

    public static boolean checkIsomorpism(String str1, String str2){
        
        // maintain a map for each letters pair for both words
        if(str1.length() != str2.length()) return false;
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i<str1.length() ; i++){

        // check if the key value pair of current index char is present

            // if not, add
            if(!map.containsKey(str1.charAt(i)) ){

                // now if the key is not present
                // further check if the value is not associated with some other key, if so return false
                if(map.containsValue(str2.charAt(i))) return false;
            
                // if the key value both are unique, put to the map
                map.put(str1.charAt(i), str2.charAt(i));
                
            }

            // else if current key is present, check if corresponding value associated is same
            else{
                if((map.get(str1.charAt(i)) != str2.charAt(i))) return false;
            }
        }

        return true;
    }

    public static int[] f(int arr[]){

        return new int[]{1,1};
    }


    public static void main(String[] args) {
        
        String s1 = "badc";
        String s2 = "baba";
        System.out.println(checkIsomorpism(s1, s2));
    }
}
