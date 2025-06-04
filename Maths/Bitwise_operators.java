package Maths;

public class Bitwise_operators {
    
    public static void main(String[] args) {
        

        // System.out.println(isEven(161));
        int num = 0b100000000;
        System.out.println(rigthmostPositionOfSetBit(num));
        // int original = toggleIthBit(num, 6);

        // for(int i =1; i<=9; i++){
        //  System.out.println(IthBit2(original, i));  // by default, java will treat is as decimal, add 0b as prefix,to tell it treat it as binary number
        // }


            // System.out.println(magicNumber(1));
            // System.out.println(isPowerof2(10));

            System.out.println(power(5, 0));
            System.out.println(countSetBits(17));
    }

    // Bitwise operators
        // AND
        // OR
        // XOR ---> gives 1 only if bits are different
            // properties of XOR
            // a ^ a = 0
            // a ^ 0 = a
            // a ^ 1 = ~a 

        // << leftshift  ---> doubles the number. eg. 12 << 1 = 24, 12 << 2 = 12 * 2 * 2 = 48. 
            // in general : a << b ===> a * 2^b;
        // >> rightshift operator ----> halves the number by 2. 
            // a >> b ====> a / (2^b);

    // number systems
        // decimal - 0 to 9
        // binary - 0,1
        // octal - 0 to 8
        // hexadecimal - 0 to 9 to f ---> 0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f


    // Negative of a number ==> also known as 2's complement
        // represented by : 
            // 1. take the complement
            // 2. add one to it, the resultant will be the negative of that num 

    // range of numbers that can be stored in a given byte of memory
    // -2^n-1 to (2^n-1)- 1
    

    // No. of digits in a given number of any base
        // 1st approach is brute force and straight forward
        // 2nd one is optimized
            // no. of digits = logb(num) + 1 , where b is the base of the number system

            // for 0b10  ==> d = (log(10) / log2) + 1;  =====> 4 
            // for 14583 ==> d = (log(14583)/ log10) + 1  ====> 5



    // Q. find out if the number is even or odd
    // simply AND the num with 0.
    //1001011 & 0000001 ---> 0000001, // for last digit 0 it will be 0
    // if 1--> odd, else even
    // as last the last, or the least significant digit only decides whether the given num is even of odd

    static boolean isEven(int num){

        return (num & 1)  == 0;
    }

    
    
    // Q. find the unique element, in an array, where every element occur twice
    // there are brute force techniques to solve in O(N^2) complexity, of O(N) space Complexity

        // but there's a better method, with O(N) time, and O(1) space complexity
        // just XOR the entire array with itself
        // duplicate element will cancel out each other, leaving behind the unique one
    static int UniqueInArray(int[] arr){

        int unique = 0;

        for(int i=0; i< arr.length; i++){

            unique ^= arr[i];
        }
        return unique;
    }



    // find the ith bit(from right, i.e. <--- direction)
    // eg. for 101101001 ---> 5th bit  = 0

    // thought process, right shift the no. 4 times
        // the ith bit is not least significant bit
        // & the num with 1, the num left will be the ith bit

    static int IthBit(int num, int position){       // here using 1 based indexing

        return (num >> (position-1)) & 1;

    }

    //OR, another approach
        // create a bit mask
        // by 1 << (position-1)
        // AND the num with the mask
            // a non-zero result will denote the ith bit to be 1, and vice-versa

    static int IthBit2(int num, int position){

        int mask = 1 << (position-1);

        return (num & mask) != 0 ? 1 : 0;
    }



// this masking approach is applicable to solve wide range of problems: 

    // 1. set ith bit to 1
    static int setIthBit(int num, int position){        // manipulate the num, return it, store it to original variable

        // find mask
        int mask = 1 << (position-1);
        // OR it with the num, all the digits will remain same, the Ith bit will set to 1
        return num | mask;

    }


    // 2. clear the ith bit
        // make the ith bit to 0, irrespective of the value
        // approach
        // find mask, take its complement, like of i=4 --> mask = 00001000 ---> ~mask = 11110111
        // AND it with num, the ith bit will become 0, rest will be unchanged

    static int clearIthBit(int num, int position){

        int mask = 1 << (position-1);

        return num & ~mask;
    }


    // toggle ith bit
    // just XOR the num with the mask;      --> 1^1=0, 0^1=1
    static int toggleIthBit(int num, int position){

        int mask = 1 << (position-1);

        return num ^ mask;
    }




    // find the rightmost set bit
    // i.e. find the position of the 1st 1 from the right
    // 10110100  ---> 3

    static int rigthmostPositionOfSetBit(int num){

        if(num==0) return -1;

        int position = 1;
        
        while ( num > 0 && (num & 1) == 0) {   // check if LSB is 0 or 1
            position++;             // if 0, just right shift and increment the position
            num >>= 1;      
        }
        return position;        // if the 1st position is 1 itself, just return;
    }


    // more optimized 
        // n = 44  → 0010 1100
        // -n = -44 → 1101 0100  (2's complement)
        // n & -n = 0000 0100  → 4 ✅     -------> to get the position just (log4/log2) + 1
    static int rightmostSetBit(int num){

        return num & -num;
    }


// count the number of set bits
// 1st and simple approach is : just increment a counter for 1;
// 2nd : using the above approach
    // initialize a counter
    // isolate the rightmost set bit by n & -n
    // then subtract it from original number
    // repeat till n>0;
//Step	n (binary)	 n & -n	        n - (n & -n)	Count
// 1	00101100	00000100 → (4)	  00101000	     1
// 2	00101000	00001000 → (8)	  00100000	     2
// 3	00100000	00100000 → (32)	  00000000	     3 ✅

    static int countSetBits(int num){

        int count = 0;

        while (num > 0) {
            
            num = num - (num & -num);   
            count++;            
        }
        return count;
    }



    // Q. find the ith magic no. 
    // i=1 ==> 5^1 = 5
    // i=2 ==> 5^2 = 25
    // i=3 ==> 5^2 + 5^1 = 30 
    // i=4 ==> 5^3 = 125
    // i=5 ==> 5^3 + 5^1 = 130
    // find nth number

    static int magicNumber(int num){

        int ans = 0;
        int base = 5;
        while (num > 0) {
            int last = num &1;
            ans += base*last;
            
            base = base*5;
            num >>= 1; 
        }
        return ans;
    }



    // pascal triangle
        // 1       --> 1st row = 2^0
        // 1 1      --> 2nd row = 2^1
        // 1 2 1 
        // 1 3 3 1
        // 1 4 6 4 1
        // nth row ---> 2 ^ (n-1)

    static int pascalTriangleNthRow(int row){

        return 1 << (row-1);
    }



    // check if a given no. is a power of 2
    // approach 1 : brute force and simple
        // count the no. of 1s, left shift till it becomes 0, if no. of 1s > 1, not the power of 2

    // approach 2: 
        // just AND the num with num-1
        // if n & (n-1) == 0, true, else false

    // eg. 10000 
      // & 01111  ----> 00000, power of 2 is true

      // for 10100 & 10011 ---> 10000 != 0, not the power of 2
        

    static boolean isPowerof2(int num){
        if (num==0) return false;
        return (num & (num-1)) == 0 ;
    }



    // find a^b
    // 1st and simple approach is multiplying b times a  --> TC = O(b)
    // but 2nd more optimal approach is : gives answer in O(logb)
    // e.g 3^6 ==> 3^110, power is binary
        // so ans = 0* 3^1 + 1* 3^2 + 1* 3^4


    static int power(int num, int exponent){

        int ans = 1;
        int base = num;

        while (exponent > 0) {
            
            ans *= base * (exponent & 1);  // AND with 1, extracts the LSD as we know

            base = base*num;
            exponent >>= 1;

            // System.out.println("ans : " + ans+ "base : " + base+  "exponent : " + exponent);
        }

        return ans;
    }





    // todos
    // 1. find XOR of nums from 0 to n
    // 2. XOR of all nums from a to b
    // 3. leetcode 832



}
