package StacksAndQueues.Stacks.Questions;

import java.util.Stack;

public class ValidBrackets {
    

    // leetcode 20
    public static boolean isValid(String s) {        
        Stack<Character> temp = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                temp.push(s.charAt(i));
            }

            else{
                if(temp.isEmpty()) return false;        // means no opening bracket pushed, hence unbalanced

                if((temp.peek()=='(' && s.charAt(i)==')') 
                || (temp.peek()=='{' && s.charAt(i)=='}') 
                || (temp.peek()=='[' && s.charAt(i)==']')) {
                    temp.pop();
                }
                else{
                    return false;       // if none of the above happens, then there's must a mismatched pair
                }
            }
        }
        return temp.isEmpty();
    }


// min no. of brackets to be removed, to make the string balanced
    public static int reqToBeValid(String s){

        Stack<Character> temp = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                temp.push(s.charAt(i));
            }
            else{

                if( !temp.isEmpty()
                && ((temp.peek()=='(' && s.charAt(i)==')') 
                || (temp.peek()=='{' && s.charAt(i)=='}') 
                || (temp.peek()=='[' && s.charAt(i)==']'))) {
                    temp.pop();
                }
                else{
                    temp.push(s.charAt(i));     // is no match is found, or stack is empty simply push the unmatched bracket
                }
            }   
        }
        return temp.size();     // lastly the temp stack will have all the unmatched brackets, return its size
    }



    public static void main(String[] args) {
        
        String s = "(()){}[]{{)]";
        System.out.println(reqToBeValid(s));

    }   

    

}
