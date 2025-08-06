package Maths;

import java.util.ArrayList;

public class mathsQues {

    public static void main(String[] args) {
        // for(int i =0;i <20;i++){
        //     System.out.println(i + " : " +  isPrime(i));
        // }


        // sieveOfErastosthenos(30);

        // System.out.println(sqrtPerfectSquareNum(10));

        // System.out.printf("%.3f",sqrtPrecise(500, 3));

        // factorsAsc(109);

        System.out.println(HCFRecursive(45,61));
    }

    // approach 1 is the brute force, just check every no. from 2 to n-1;
    // 2nd approach is of better complexity
        // just check till 2 to sqrt(n);
        // as after it the pattern of number just repeats
    static boolean isPrime(int num){
        if(num<=1) return false;
        int i = 2;
        while (i*i <= num) {
            if(num%i ==0) return false;
            i++;
        }
        return true;
    }



    // given a no. list out all the primes before it
    // 1st method is simple, just check of isPrime for all no., not so optimized
    // in a optimized way
    // Sieve of Erastosthenos
    // mantain a boolean array of size == num
    // start from 2 till less than sqrt of the num
    // mark all the multiples of 2 as true, depicting they are composite.
    // same for 3, 5, so on. (not for 4 as it is already crossed as multiple of 2);

    // complexity:
    // space : O(N)
    // time : O(n log(log n))       // n * harmonic progression (1/2 + 1/3 + ....)
    static void sieveOfErastosthenos(int num){
        boolean[] arr = new boolean[num+1];     // initially all values are false

        // start from 2, till a num whose square is < given num
        for(int i = 2; i*i < num ; i++){
            if(arr[i] != true){
            // inner loop to mark multiples of 2, then 3, then 5 and so on as true, denoting them as composite, 
                for(int j = i*2; j< num ; j +=i){
                    arr[j] = true;
                }
            }
        }

        // lastly print all the nums whose index remain false, i.e. they are multiple of none
        for(int k=2; k <num;k++){
            if(arr[k]==false) System.out.println(k+ " ");
        }

    }



    // finding square root
        // there are two scenarios
        // 1. for perfect square the logic is pretty straight forward
            // i.e. if (mid * mid) == num , then ans = mid
            // if m*m < num, then end = mid-1, else start = mid + 1
            // resembles like binary search
            // this time complexity here will be O(logN)

    static int sqrtPerfectSquareNum(int num){

        int start = 0;
        int end = num;
        
        while (start <= end) {
            int mid = start + (end-start)/2;

            if(mid*mid == num) return mid;
            else if(mid*mid > num) end = mid - 1;
            else start = mid + 1;
        }
        return -1;      // no integer sqrt found
    }


    // find sqrt of any no. given the precision

    // aproach
    // e.g. for sqrt(40)
        // find an integer n, such that n^2 < 40, and (n+1)^2 becomee greater than 40
        // here n =6, surely sqrt of 40 is 6.___
        // now comes the precision part, for precision of 1
        // start iterating from 6.1 to 6.9, at the point where 6.2^2<40 and 6.3^2 > 40, hence 6.2 is the answer
        // for further precision, repeat the process from 6.11 to 6.19

    // ** IEEE 754 floating-point arithmetic errors. may occur, defying the precision.
    // better use pretty format to display the output
    static double sqrtPrecise(int num, int precision){

        int start = 0;
        int end = num;
        
        double root = 0.0;

    // find the nearest integer value such that i*i<num
        while (start <= end) {
            int mid = start + (end-start)/2;

            if(mid*mid == num) return mid;
            else if(mid*mid < num && (mid+1)*(mid+1) > num){
                root = mid;
                break;
            } 

            else if(mid*mid > num) end = mid-1;
            else start = mid+1;
        }

        
        // comes here the precision part
        
        double incrementDecimal = 0.1;      // out of the loop to avoid resetting
        for(int i = 0; i< precision; i++){

            // increment the root with 0.1 till a no. i such that i*i<num;
            // then in the next iteration, add 0.01, and check, repeat till the given precision
            while ((root+incrementDecimal) * (root+incrementDecimal) < num) {
                
                root = root + incrementDecimal;
            }
            incrementDecimal /= 10;
        }

        return root;
    }



    // NEWTON-RAPHSON METHOD TO FIND SQUARE ROOT
    static double sqrtNewton(int n, double precision) {
    double x = n;
    double root;

    while (true) {
        root = 0.5 * (x + n / x);

        if (Math.abs(root - x) < precision) break;

        x = root;
    }

    return root;
}




// Finding factors
    // approach 1 is simple
    // just iterate, print if i%num ==0;

    // 2nd one pretty optimized approach
    // thought process, if i is a factor of n, and n/i is also the factor of n
    // using this there is an observation :
    // that after a number sqrt(n), the factors start to repeat itself
    // like : 
    // for 20 : 1,2,4,5,10,20 ==> 1,20 ,2,10, 4,5 ---> after 4 they would be 5,4, 10,2, and 20,1
    // so simple just iterate till sqrt(num) and return num/i along with i

    // better complexity --> O(sqrt(N))

    static void factors(int num){

        for(int i = 1; i*i<=num; i++){
            
            if(num%i==0) System.out.print(i + " " + num/i + " ");
        }
    }

    // to print it in ascending order
    static void factorsAsc(int num){

        ArrayList<Integer> ansPart = new ArrayList<>();
        
        for(int i = 1; i*i<=num; i++){
            
            if(num%i==0){
                System.out.print(i + " " );
                ansPart.add(num/i);
            }
        }

        //finally printing the remaining part from the array list in decreasing order
        for(int j=ansPart.size()-1; j>=0; j--){
            System.out.print(ansPart.get(j) + " ");
        }
    }




    // HCF  
    // using the repeated division approach
    // remember when we divided the divisor repeatedly with the remainder till remainder becomes 0.
        // and the last divisor is the hcf

    static int HCF(int num1, int num2){

        int a = num1;
        int b = num2;

        int r = b%a;

        while (r != 0 ) {
            b = a;
            a = r;
            r = b%a;
        }
        return a;
    }

    
    // Recursive approach to find hcf
    // dry run to visualize
    static int HCFRecursive(int a, int b){

        // base case when the remainder or the last divisor becomes 0;
        if(a==0) return b;
        // repeatedly call the function , with remainder and the previous divisor
        return HCFRecursive(b%a, a);
    }


    // LCM (a,b)
    // formula = (a*b)/HCF(a,b);
}
