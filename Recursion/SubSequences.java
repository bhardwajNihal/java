

import java.lang.classfile.instruction.StackInstruction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSequences{

    public static void main(String[] args) {
        
        String str = "abaacad";
        String ansStr = "";
        // System.out.println(skipChar(str,'c',0,ansStr));

        // skip("", "abcabc");

        // System.out.println(skipString("abcappleabc", "abc"));

        // System.out.println(subsetsArr("abc", ""));
        // System.out.println(skipChat_better("abcd", 'e'));

        // String str2 = "ramanchaman";
        // System.out.println(skipStr_rev(str2, "mancha"));
        // List<String> ansSet = new ArrayList<>();
        // System.out.println(subSequences2("abc", ""));

        int[] arr = {1,2,1};
        // List<Integer> ans = new ArrayList<>();
        // subsequencesNum(arr, 0, ans, null);
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pArr = new ArrayList<>();
        SubsetSumK(arr, 0, pArr, ans, 0, 2);

        System.out.println(ans);

    }

    

    // 1. remove a from a given string ---> baccbab --> bccbb
    static String skipChar(String str, char ch, int idx, String ansStr){

        if(idx == str.length()) return ansStr;

        if(str.charAt(idx) != ch) ansStr += str.charAt(idx);

        return skipChar(str,ch,idx+1,ansStr);

    }

    // approach 2
    // 
    static String skipChar_better(String str, char ch){

        if(str.isEmpty()) return "";

        if(str.charAt(0)!=ch){
            return str.charAt(0) + skipChar_better(str.substring(1), ch);
        }
        else{
            return skipChar_better(str.substring(1),ch);
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
    static void PrintSubsets(String uStr, String pStr){

        if(uStr.length()==0){           // once the unprocessed part becomes empty, print the processed part
            System.out.println(pStr);
            return;
        }
        char ch = uStr.charAt(0);
        PrintSubsets(uStr.substring(1), pStr);       // sucessive call without taking the 1st ele of unprocessed string
        PrintSubsets(uStr.substring(1), pStr + ch);      // take the 1st element of the ustr, add it to the processed part
    }



    // subsequences printing
    static List<String> subsequences(String Ustr, String Pstr, List<String> ans){

        // if the unprocessed part is empty, print the processed string
        if(Ustr.length()==0){
            ans.add(Pstr);
            return ans;
        }

        // call for printing further subsequences
        // taking the 1st char
        char ch = Ustr.charAt(0);
        subsequences(Ustr.substring(1), Pstr+ch, ans);

        // leaving the 1st char
        subsequences(Ustr.substring(1), Pstr, ans);

        return ans;
    }


    // without passing ans list as parameter
    static List<String> subSequences2(String Ustr, String Pstr){

        if(Ustr.length()==0){
            // create a new temp arraylist to store current processed part
            List<String> temp = new ArrayList<>();
            temp.add(Pstr);
            return temp;        // further to take this, and add to a global  ans list
        }                   
                                    
        ArrayList<String> ansStr = new ArrayList<>();

    // to catch all the substrings returned from the left tree, add to the ans
        // excluding the 1st char
        ansStr.addAll(subSequences2(Ustr.substring(1), Pstr));

    // to catch all substrings from the right tree
        // including the 1st char
        char ch = Ustr.charAt(0);
        ansStr.addAll(subSequences2(Ustr.substring(1), Pstr+ch));

        // finally return the ans array
        return ansStr;
    }


    // another appraoch, of getting subset array
    // returning the array of subsets
    static ArrayList<String> subsetsArr(String uStr, String pStr){

        if(uStr.length()==0){
            ArrayList<String> list = new ArrayList<>();
            if(pStr != "") list.add(pStr);      // ignore empty string
            return list;
        }
        
        // exclude
        ArrayList<String> leftPart = subsetsArr(uStr.substring(1), pStr);       

        // include
        char ch = uStr.charAt(0);
        ArrayList<String> rightPart = subsetsArr(uStr.substring(1), pStr + ch); 

        // just combine the sub arrays
        leftPart.addAll(rightPart);
        return leftPart;
    }


    // subsequences an array of integers
    static void subsequencesNum(int[] arr, int idx, List<Integer> pArr, List<List<Integer>> ans){
        
        if(idx==arr.length){
            ans.add(new ArrayList<>(pArr));     // adding copy of pArr, not the actual pArr reference, as on each backtracking the pArr is emptied (to avoid duplicates on further recursive call), and if actual pArr is passed, the final ans will get all the empty subarrays
            return;
        }

        // exclude current index ele
        subsequencesNum(arr, idx+1, pArr, ans);

        // include
        pArr.add(arr[idx]);
        subsequencesNum(arr, idx+1, pArr, ans);
        
        pArr.remove(pArr.size() - 1);     // this removal is mandatory, as actual reference of pArr is passed
                                          // if not removed on every branch of recursive tree, then on further branches the duplicate values of already included ele will be passed, fucking up the entire ans list
    }   




    // give all the subsets with a given sum k

    static void SubsetSumK(int arr[], int idx, List<Integer> pArr, List<List<Integer>> ans, int sum, int k){

        // go to the each possible branches of subarray
        // if at the end, (when idx == arr.length), 
        if(idx == arr.length){
            // if the sum of the subarray == k, add it the ans
            if(sum == k){
                List<Integer> temp = new ArrayList<>(pArr);
                ans.add(temp);
                
            }
            return;
        }
        // further recursive calls

        // exclude
        SubsetSumK(arr, idx+1, pArr, ans, sum, k);

        // include
        pArr.add(arr[idx]);
        sum += arr[idx];
        SubsetSumK(arr, idx+1, pArr, ans, sum, k);
        
        // remove the processed arrays last index, and last added ele to sum from the current branch
        pArr.remove(pArr.size()-1);
        sum -= arr[idx];

    }



}