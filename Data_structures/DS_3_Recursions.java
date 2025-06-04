public class DS_3_Recursions {
    
    public static void main(String[] args) {
        
        // print1();

        // calling a recursive function
        // print(1);

        // // for(int i =0; i< 8; i++){
        // //     System.out.println(fibonacci(i));
        // // }
        // System.out.println(fibonacci(3));

        int[] arr = {1,3,4,5,8,10,14,16};
        System.out.println(binarySearchRecursive(arr, 10, 0, arr.length-1));
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
        if(num == 0) return 0;
        if(num == 1) return 1;

        return fibonacci(num - 1) + fibonacci(num - 2); 
    }


    // draw recursion tree
    // visualize the call and return flow
    // be careful and specific to the base case


    // using recursion for binary search
    static int binarySearchRecursive(int[] arr,int target, int start, int end){

        if(start > end) return -1;      // break case
        int mid = start + (end-start)/2;

        // base case
        if(arr[mid] == target) return mid;

        if(target > arr[mid]) return binarySearchRecursive(arr, target, mid+1, end);
        else return binarySearchRecursive(arr, target, start, mid-1);
    }
}       
