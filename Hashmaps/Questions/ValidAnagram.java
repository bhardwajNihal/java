package Hashmaps.Questions;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        // approach is simple just maitain the hashmap of each letters
        // if matches then true
        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        // maintain 1st string's hashmap
        for (int i = 0; i < s.length(); i++) {
            // check if the letter present, if not add, if yes then increase the count
            if (!mp1.containsKey(s.charAt(i)))
                mp1.put(s.charAt(i), 1);
            else {
                mp1.put(s.charAt(i), mp1.get(s.charAt(i)) + 1);
            }
        }

        // 2nd string's
        for (int i = 0; i < t.length(); i++) {
            // check if the letter present, if not add, if yes then increase the count
            if (!mp2.containsKey(t.charAt(i)))
                mp2.put(t.charAt(i), 1);
            else {
                mp2.put(t.charAt(i), mp2.get(t.charAt(i)) + 1);
                mp1.
            }
        }

        return mp1.equals(mp2);




    // appraoch 2 - using only 1 map
    // just create the frequency map for the 1st str, for the 2nd string remove the
    // matching chars, if at last all the char becomes 0 then true, else false

        // Map<Character, Integer> mp1 = new HashMap<>();

        // // maintain 1st string's hashmap
        // for(int i=0; i<s.length(); i++){
        // // check if the letter present, if not add, if yes then increase the count
        // if(!mp1.containsKey(s.charAt(i))) mp1.put(s.charAt(i), 1);
        // else{
        // mp1.put(s.charAt(i), mp1.get(s.charAt(i))+1);
        // }
        // }

        // // for 2nd string, decrement the frequency of the matching ele
        // for(int i=0; i<t.length(); i++){
        // // check if the letter present, if not add, simply return false
        // if(!mp1.containsKey(t.charAt(i))) return false;
        // else{ // else freq--
        // mp1.put(t.charAt(i), mp1.get(t.charAt(i))-1);
        // }
        // }

        // // return mp1.equals(mp2);
        // for(Character k : mp1.keySet()){
        // if(mp1.get(k) != 0) return false;

        // }
        // return true;

    }

}
