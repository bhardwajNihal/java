package Hashmaps.Questions;

import java.util.*;

public class MaxFrequency {
    

    // return max frequency element of array

    public static int maxFrequency(int[] arr){

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<arr.length ; i++){
            if(!mp.containsKey(arr[i])) mp.put(arr[i],1);
            else{
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
        }

        int max = arr[0];
        for(int k : mp.keySet()){
            if(mp.get(max) < mp.get(k)) max = k;
        }


        return max;
    }


    public static void main(String[] args) {
        
        int[] arr = {1,2,2,1,-1,-1,-1,4,4,4,4,4,4,};
        System.out.println(maxFrequency(arr));
    }
}
