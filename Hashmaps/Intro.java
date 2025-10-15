package Hashmaps;

import java.util.*;

import Maths.mathsQues;

public class Intro {

    public static void main(String[] args) {

        // MAPS lets us store key value pair
        // types
        // hashmaps --> unordered
        // linkedHashmaps --> maintains order
        // Treemaps --> maintains sorted order

        // syntax

        Map<String, Integer> map1 = new HashMap<>(); // Hashmap is the class that implements the Map interface
        Map<String, Integer> map2 = new HashMap<>();

        map1.put("cat", 1);
        map1.put("dog", 2);

        map2.put("cat", 1);
        map2.put("dog", 2);

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map1.equals(map2));

        String s = "ram";
        System.out.println(s.charAt(1));

        // methods
        // map.put("ram", 1); 
        // map.put("mar", 2);
        // map.put("arm", 3);
        // map.put("rma", 4);

        // System.out.println(map.get("arm"));
        // System.out.println(map.entrySet());
        // System.out.println(map.keySet());
        // System.out.println(map.values());
        // System.out.println(map.remove("rma", 4));

        // System.out.println(map.entrySet());
        // map.put("mar", 100);

        // System.out.println(map.entrySet());

        // System.out.println(map.remove("mar"));
        // System.out.println(map.entrySet());

        // // putIfAbsent - only add if key not present

        // // traversing
        // for (String k : map.keySet()) {
        //     System.out.println(k + " " + map.get(k));
        // }

        // // or -- extract entries and print directly
        // for (Map.Entry<String, Integer> e : map.entrySet()) { // type is Map.Entry<k,v>
        //     // System.out.println(e);
        //     System.out.println(e.getKey() + e.getValue());
        // }

        // // in java 10+ version
        // // don't even need to specify types, it infers automatically
        // for (var e : map.entrySet()) { // type is Map.Entry<k,v>
        //     // System.out.println(e);
        //     System.out.println(e.getKey() + e.getValue());
        // }

       
    }

}
