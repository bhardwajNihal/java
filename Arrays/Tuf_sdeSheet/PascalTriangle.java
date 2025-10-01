package Arrays.Tuf_sdeSheet;

import java.util.*;

public class PascalTriangle {


    // 1st kind of prob, given row and column just give the pascal triangle value for it
    // simple its combination(r,c) = r!/c!(r-c!)
        // but if we calculate it the traditional way, then the total time complexity is 
            // O(r) + O(c) + O(r-c), as for n! --> n iterations
        // optimal approach: finding the pattern, we observe that from the numerator, the last r ele are eliminated
        // e.g. --> C(5,3) ==> 5*4*3*2*1 / 3*2*1  *  2*1  ---> 5*4/2 
            // public static long nCr(int r, int c){
            //     long res = 1;
            //     for(int i =0; i<c ; i++){       //only iterate and multiply r to res , c no. of times
            //         res *= (r-i);
            //     }
            //     for(int i = 0; i<c ;i++){       // then divide incrementally till 1 to c;
            //         res /= i+1;
            //     }
            //     return res;
            // }


        // 2nd variation is 
        // given a num n
        // print n elements of the pascal triangle
        // e.g. n = 5 ==> 1 4 6 4 1 

        //     1st approach is simple just calculate C(0,n-1) till C(n-1,n-1), print that
        //     but again that's not the optimised approach as everytime the factorial is caculated

        // 2nd optimized approach, calculate the 1st term, which is always on
        // understand a pattern
        //     like for n = 4
        //         terms go as like : C(4,0), C(4,1), ....C(4,4);
        //         4!/4!, 4!/3!, 4!/2!*2!, .....
        //         observing the pattern we notice that each successive term is got by 
        //         : 1st term, i = 0 --> ele = 1;
        //         2nd term onwards, from i =1 to i = n-1
        //             ith term = i * n-i/i

        // simple func to print 1st n pascal elements
            // static void printPascal(int num){
            //     int ans =1;
            //     System.out.print(ans + " ");      // print 1st term
            //     for(int i =1; i<num; i++){      // calculate 2nd term onwards, keeping 1st term as base
            //         ans = ans * (num-i)/i;    
            //         System.out.print(ans + " ");
            //     }
            // }




        // leetcode 118: print n row of pascal triangle
            // helper func to return the nth row of the pascal triangle
            static List<Integer> getIthRow(int num){
                List<Integer> row = new ArrayList<>();
                    int ele =1;
                    row.add(ele);
                    for(int i =1; i<num; i++){      // calculate 2nd term onwards, keeping 1st term as base
                        ele = ele * (num-i)/i;          // most optimal approach based on a pattern
                        row.add(ele);
                    }
                    return row;
                }

            public List<List<Integer>> generate(int numRows) {
                
                List<List<Integer>> ans = new ArrayList<>();

                // every iteration, get the 1st n pascal element for the nth row, 
                // then add it to the answer list

                for(int i = 1; i<=numRows; i++){
                    ans.add(getIthRow(i));
                }

                return ans;
            } 
                    



    public static void main(String[] args) {
        
        // System.out.println(nCr(7,3));
        // printPascal(5);
        System.out.println(getIthRow(6));
    }

    
}
