
import java.util.Arrays;

public class DS_3_Recursions {
    
    public static void main(String[] args) {
        
        // print1();

        // calling a recursive function
        // print(1);

        // // for(int i =0; i< 8; i++){
        // //     System.out.println(fibonacci(i));
        // // }
        // System.out.println(fibonacci(3));

        // int[] arr = {1,3,4,5,8,10,14,16};
        // System.out.println(binarySearchRecursive(arr, 10, 0, arr.length-1));



        // printnto1(5);
        // print1tonBetter( 5);
        // printnto1ton(5);

        //  System.out.println(factorial(4));
        //  System.out.println(sum(10));
        //  System.out.println(sumOfDigits(1234));
        //  System.out.println(productOfDigits(1234));

        // reverse(1000);
        // reverse2(1234);
        // System.out.println(rev);

        // System.out.println(palindromeNum(1233521));


        // System.out.println(powerOpt( 2,1));
        // multiples(5, 10);

        System.out.println(sumAlt(11));

    }


    // given num, and k : print 1st k multiples of num
    static void multiples(int num, int k){

        if(k ==0) return;

        multiples(num, k-1);
        System.out.print(num*k + " ");
    }

    // given n, return sum, with alternate sign
    // e.g. n = 5; ===> 1-2+3-4+5
    static int sumAlt(int n){

        if(n ==0) return 0;

        if(n%2==1) return sumAlt(n-1) + n;
        else return sumAlt(n-1) - n;
    }


    // two points to consider about function calls before jumping on to recursion.
    // i.e.
        // when a function is called, it's put to the stack. Stack follows the LIFO priciple.
        // it remains in the stact till the function is done executing.
        // so when a function let say 1, calls another function inside it
            // then the function 1 will only be done and removed from the stack when the 2 is done and is removed from the stack.
        
    // main is always the 1st one to be called, and the last one to be removed from the stack.


    // oldschool  definition
    
    // RECURSION : function calling itself
    // a function calling itself with modified parameters again and again to reach to a solution
    // till it hits the base case
        // base case is nothing but a condition where function knows the answer straight away

    // Space complexity : O(N) as n no. of stacks are created everytime
    // time : O(N) as function is called n times for n parameters
    

    // basic example of function calling another function inside it
    // all the function does the same task --> prints and call the next function.
    static void print1(){
        System.out.println("hello1");
        print2();
    }
    static void print2(){
        System.out.println("hello2");
        print3();
    }
    static void print3(){
        System.out.println("hello3");
        print4();
    }
    static void print4(){
        System.out.println("hello4");
    }


    // achieving the above via recursion 
    // fewer lines of code required here
    // no redundancy

    static void print(int num){
        if(num == 4){                       // base case, just to stop further function call
            System.out.println("hello " + 4);       
            return; 
        }
        System.out.println("hello " + num);
        print(num + 1);
    }


    // when no base condition is hit
    // the fucntion will be called successively infinitely
    // stack memory will be filled
    // error will be thrown
    // this is called stack overflow


    //PROPERTIES OF RECURSION
        // helps attain solution to a bigger complex problem by breaking it down to smaller subproblems till the point when the answer is straight away known, and using the solution from the previous call successively till the solution to the original problem is obtained.
        // every problem that can be solved via recursion can be solved via iteration as well
        // space complexity for recusion is not constant




    // Practice questions to better visualize recursion

    // fibonacci num : 0 1 1 2 3 5 8 13 ....., every num is sum of previous two nums
    static int fibonacci(int num){

        // base cases 
        if(num == 0 || num == 1) return num;

    // every term is the fibo series, is the sum of previous two fibo numbers
    // so, repeatedly call for the sum of previous two fibo numbers, and rest will be taken care of by recursion
        return fibonacci(num - 1) + fibonacci(num - 2); 
    }


    // draw recursion tree
    // visualize the call and return flow
    // be careful and specific to the base case


    // using recursion for binary search
    static int binarySearchRecursive(int[] arr,int target, int start, int end){

        if(start > end) return -1;      // break condition, if answer not found
        int mid = start + (end-start)/2;

        // base case
        if(arr[mid] == target) return mid;

    
    // make sure to return the result, if the function has a return type
        if(target > arr[mid]) return binarySearchRecursive(arr, target, mid+1, end);
        else return binarySearchRecursive(arr, target, start, mid-1);
    }


    

    // printing n to 1 
    static void printnto1(int n){

        if(n==1){
            System.out.print(n + " ");
            return;
        };
        System.out.print(n + " ");
        printnto1(n-1);
    }


    // print 1 to n
    static void print1ton(int n1, int n2){

        if(n1 == n2){
            System.out.print(n1 + " ");
            return;
        }
        System.out.print(n1 + " ");
        print1ton(n1+1, n2);
    }


    // better approach to print 1 to n
    static void print1tonBetter(int n){

        if(n==0) return;

        // dry run gives the utmost clarity, here the next function is called 1st
        // and the num is printed when the previous call is over
        print1tonBetter(n-1);
        System.out.println(n);
    }

    //print n to 1 then 1 to n
    static void printnto1ton(int n){

        if(n==0) return;
    
    // will print the current num in decreasing order aswell
    // while returning the increasing order will also get printed
        System.out.println(n);
        printnto1ton(n-1);
        System.out.println(n);
    }


    // factorial
    static int factorial(int num){

        if(num == 0 || num == 1) return 1;

        return num * factorial(num-1);
    }

    // sum 1 to n
    static int sum(int num){

        if(num <= 1) return num;

        return num + sum(num -1);
    }

    // sum of digits
    static int sumOfDigits(int num){

        if(num/10 == 0) return num;     // when the last digit is left, return that that i.e. of 1234, repeatedly dividing by 10 --> when at last 1 will remain just return 1

        return num%10 + sumOfDigits(num/10);
    }

    //product of digits
    static int productOfDigits(int num){

        if(num/10 == 0) return num;     // when the last digit is left, return that that i.e. of 1234, repeatedly dividing by 10 --> when at last 1 will remain just return 1

        return num%10 * productOfDigits(num/10);
    }


    // a case of stack overflow
    static void fun(int num){
        if(num==0) return;
        System.out.println(num);
        fun(num--);         // it will call the function with the same num repeatedly, as it post decrement
    }


    // reverse a num 
    static void reverse(int num){

        if(num/10==0){
            System.out.print(num);
            return;
        }
        System.out.print(num%10);
        reverse(num/10);
    }

    // but the above method is just printing the no. in reverse order
    // approach 2 to actually reverse the number

    static int rev = 0;     // variable declared globally so as to retain value
    static void reverse2(int num){
        
        if(num == 0) return;

        rev = rev*10 + (num%10);

        reverse2(num/10);
    }




    // palindrome check to a number
    // 1st approach is simple just compare to its reverse
    static boolean palindromeNum(int num){

        reverse2(num);
        return rev == num;
    }

    // find a^b using recursion
    static int power(int a, int b){

        if(b==0) return 1;

        return a * power(a, b-1);
    }

    // optimal approach
    static int powerOpt(int a, int b){

        if(b==0) return 1;

        if(b%2==0){
            return powerOpt(a, b/2) * powerOpt(a, b/2); 
        }
        else{
            return a * powerOpt(a, b/2) * powerOpt(a, b/2); 
        }
    }
    
}       
