package Revisit;
public class Revisit {
    

    public static void main(String[] args) {
        

        // tuf star pattern

        //6. 
        int n=5;
        // for(int i = 1 ; i<=n; i++){
        //     for(int j= 1; j<=n-i+1; j++){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }


        // //8.
        // for(int i=1; i<=n; i++){

        //     // printing space
        //     for(int j=0; j<=i-1; j++){
        //         System.out.print("  ");
        //     }

        //     // printing stars
        //     for(int k=1; k<=(2*(n-i+1))-1; k++){
        //         System.out.print("*" + " ");
        //     }
        //     System.out.println();
        // }

        // //12. 
        // for(int i=1;i<=n;i++){

        //     // asc triangle
        //     for(int j=1;j<=i; j++){
        //         System.out.print(j);
        //     }

        //     //space
        //     int z = (2*n) - (i*2);      // extra var to keep track of space
        //     for(int k = z; k>0; k--){
        //         System.out.print(" ");
        //     }

        //     // desc triangle
        //     for(int j=i; j>0; j--){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        // // 14.
        // for(int i=1; i<=n; i++){
        //     for(char j = 'A'; j<'A' + i; j++){
        //         System.out.print(j);
        //     }
        //     System.out.println(); 
        // }


        // // 19.
        
            // // 1st line (double the input)
            // for(int i = 0; i<2*n; i++){
            //     System.out.print("*");
            // }
            // System.out.println();

            // // upper triangles
            // for(int i = 0; i<n-1; i++){

            //     // upper left triangle
            //     for(int j=0; j<n-i-1; j++){
            //         System.out.print("*");
            //     }
            //     // upper btw space
            //     int sp = 2 * (i+1);
            //     for(int j=0; j<sp; j++){
            //         System.out.print(" ");
            //     }
            //     // upper right triangle
            //     for(int j=0; j<n-i-1; j++){
            //         System.out.print("*");
            //     }

            //     System.out.println();
            // }


            // // lower triangles
            // for(int i = 0;  i<n-1; i++){

            //     // lower left triangle
            //     for(int j=0; j<=i; j++){
            //         System.out.print("*");
            //     }
            //     // space btw
            //     int sp = 2 * (n-1-i);
            //     for(int j= 0; j<sp; j++){
            //         System.out.print(" ");
            //     }
            //     // lower right triangle
            //     for(int j=0; j<=i; j++){
            //         System.out.print("*");
            //     }

            //     System.out.println();
            // }

            // // last line
            // for(int i = 0; i<2*n; i++){
            //     System.out.print("*");
            // }



        // //21.
        // for(int i =0; i<n; i++){
        //     for(int j = 0; j<n; j++){
        //         if(i==0 || i==n-1 || j==0 || j==n-1)System.out.print("*");
        //         else System.out.print(" ");
        //     }
        //     System.out.println();
        // }

    
    // // 22.
    // for (int i = 0; i < 2 * n - 1; i++) {
    //             // Inner loop for columns
    //             for (int j = 0; j < 2 * n - 1; j++) {
    //                 // Calculate distance from top
    //                 int top = i;
    //                 // Calculate distance from left
    //                 int left = j;
    //                 // Calculate distance from bottom
    //                 int bottom = (2 * n - 2) - i;
    //                 // Calculate distance from right
    //                 int right = (2 * n - 2) - j;

    //                 // Take the minimum of all four distances
    //                 int minDist = Math.min(Math.min(top, bottom), Math.min(left, right));

    //                 // Print number (starts with n at border, decreases inside)
    //                 System.out.print((n - minDist) + " ");
    //             }
    //             // Move to the next row
    //             System.out.println();
    //         }
            
    //         Integer.MAX_VALUE

    // System.out.println(hcf(48, 56));

    // System.out.println(count(10));

    System.out.println(checkArmstrong(370));
    System.out.println(checkArmstrong(372));
    System.out.println(checkArmstrong(371));
    }




    // ----------------------------------------------------

// basic maths logic

// 1. reverse a num
    static int reverse(int x) {
            
            int num = x;
            int rev = 0; 

            while(num != 0){

            // to check the limits before further increasing values
                if(rev < Integer.MIN_VALUE/10 || rev > Integer.MAX_VALUE/10) return 0;
                rev = rev*10 + num%10;
                num /= 10;
            }

            return rev;
            
        }


    // HCF
    static int hcf(int num1, int num2){

        int a = num1;
        int b = num2;
        
        while(b%a != 0){
            int temp = b;
            b = a;
            a = temp%a;
        }
        return a;
    }


    // Armstrong numbers

        // count digits
        static int count(int n){
            int c =0;
            while(n!=0){
                c++;
                n/=10;
            }
            return c;
        }

    static boolean checkArmstrong(int n){

        int original = n;
        int digits = count(n);

        int sum = 0;

        while (n != 0) {
            
            int last = n%10;
            sum += Math.pow(last, digits);

            n /= 10;
        }
        
        return sum == original;

    }

}
