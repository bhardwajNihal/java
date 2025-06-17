package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class String_ques{

    public static void main(String[] args) {
        
        String str = "abaacad";
        String ansStr = "";
        // System.out.println(skipChar(str,'c',0,ansStr));

        // skip("", "abcabc");

        // System.out.println(skipString("abcappleabc", "abc"));

        System.out.println(subsetsArr("abc", ""));
    }

    

    // 1. remove a from a given string ---> baccbab --> bccbb
    static String skipChar(String str, char ch, int idx, String ansStr){

        if(idx == str.length()) return ansStr;

        if(str.charAt(idx) != ch) ansStr += str.charAt(idx);

        return skipChar(str,ch,idx+1,ansStr);

    }

    // approach 2
    static void skip(String ansStr, String str){

        if(str.isEmpty()){
            System.out.println(ansStr);
            return;
        }
        char ch = str.charAt(0);
        if(ch == 'a'){
            skip(ansStr,str.substring(1));        // simply skip the string and pass substring from 1, to further function call
        }
        else{
            skip(ansStr+ch, str.substring(1));    // add the ch to the answer array, then pass the next substring
        }
    }


    static String skipString(String str, String skipStr){

        if(str.length()==0) return str;

    // if the string starts with the given substring to be skipped, simply trim the part and pass it further
        if(str.startsWith(skipStr)){
            return skipString(str.substring(skipStr.length()), skipStr);
        }
        // else simply return the char at 1st index + answer from the successive call
        else{
            return str.charAt(0) + skipString(str.substring(1),skipStr);
        }
    }



    // SUBSETS
    // given a string print out all the subsets

    // the thought is process is like
    // take two arguments, one is the original unprocessed string, another one is the processed string
    // make successive recursion call 
        // one with taking the 1st element of the unprocessed string
        // another without taking the 1st element
        // in each call reduce the unprocessed str by 1 element

        // finally print the processed part, for all calls when the unprocessed string becomes empty

        // dry run for better visualization
    static void subsets(String uStr, String pStr){

        if(uStr.length()==0){
            System.out.println(pStr);
            return;
        }
        char ch = uStr.charAt(0);
        subsets(uStr.substring(1), pStr);       // sucessive call without taking the 1st ele of unprocessed string
        subsets(uStr.substring(1), pStr + ch);      // take the 1st element of the ustr, add it to the processed part
    }


    // returning the array of subsets
    static ArrayList<String> subsetsArr(String uStr, String pStr){

        if(uStr.length()==0){
            ArrayList<String> list = new ArrayList<>();
            if(pStr != "") list.add(pStr);      // ignore empty string
            return list;
        }
        char ch = uStr.charAt(0);
        ArrayList<String> leftPart = subsetsArr(uStr.substring(1), pStr);       
        ArrayList<String> rightPart = subsetsArr(uStr.substring(1), pStr + ch); 

        // just combine the sub arrays
        leftPart.addAll(rightPart);
        return leftPart;
    }

}