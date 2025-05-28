import java.util.Scanner;

public class B7_loops {

    public static void main(String[] args) {
        
    // while-loop
        // int i = 0;
        // while (i<5) {
        //     System.out.println("this time : " + i);
        //     i++;
        // }


    //for-loop
        // for(int j=0; j<10; j++){
        //     System.out.println(j);
        // }

    
    // break and contnue
        // for(int num = 0; num <10; num++){
        //     if(num%2==0) continue;
        //     System.out.println("odd number : " + num);
        // }

        // for(int num2 =0; num2 <10 ;num2++){
        //     if(num2==6){
        //         break;
        //     }
        //     System.out.println(num2);
        // }


    // Practice questions 

    // Q1. print decreasing star pattern
    // for(int i =0; i<4 ; i++){
    //     for(int j=4; j>i; j--){
    //         System.out.print("* ");
    //     }
    //     System.out.println();
    // }


    // q2. print 1st n even numbers
    // Scanner sc = new Scanner(System.in);
    // System.out.print("enter num : ");
    // int num = sc.nextInt();

        // for(int i=0; i<=num ; i++){
        //     if(i%2==0) System.out.println(i);
        // }

    // q3. multiplication table : 
        // for (int i=1; i<=10 ;i++){
        //     System.out.println(num + " X " + i + " = " + num*i);
        // }


    //Q4. Factorial
        // int fact = 1;
        // int i = 2;
        // for(i=2; i<=num; i++ ){
        //     fact = fact*i;
        // }
        // // using while loop : 
            // while (i<=num) {
            //     fact *=i;
            //     i++;
            // }
        // System.out.println(num + " factorial = " +  fact);

    // Q5. sum of multiples of 8
    // int sum = 0;
    // for(int i=1; i<=10; i++){
    //     sum += 8*i;
    // }
    // System.out.println(sum);



// PATTERNS 

    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter n : ");
    // int n = sc.nextInt();

// // 1. hollow rectangle :
    // for (int i=0; i<n; i++){
    //     for(int j=0 ; j<n ;j++ ){
    //         if(i==0 || i==n-1) System.out.print("* ");
    //         else{
    //             if(j==0 || j==n-1) System.out.print("* ");
    //             else System.out.print("  ");
    //         }
    //     }
    //     System.out.print("\n");
    // }


    // 2. reverse increasing triangle

    // for(int i=0 ;i<n; i++){
    //     for(int j=0 ;j<n-i;j++){
    //         System.out.print(" ");
    //     }
    //     for(int k=0; k<=i; k++){
    //         System.out.print("*");
    //     }
    //     System.out.println();
    // }



    // 3. increasing triangle number
    // for(int i=1; i<=n;i++){
    //     for(int j=1; j<=i; j++){
    //         System.out.print(j);
    //     }
    //     System.out.println();
    // }

    //decreasing same :
    // for (int i=0; i<n; i++){
    //     for(int j=1 ;j<=n-i ; j++){
    //         System.out.print(j);
    //     }
    //     System.out.println();
    // }

    // same but this time value of j continues 
    // int k=1;
    // for (int i=1 ;i<=n; i++){
    //     for(int j=1;j<=i;j++ ){
    //         System.out.print(k + "  ");
    //         k++;
    //     }
    //     System.out.println();
    // }

    // 1
    // 0 1
    // 1 0 1 
    // 0 1 0 1
    // 1 0 1 0 1 
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<=i;j++){
    //         if((i+j)%2==0) System.out.print("1 ");
    //         else System.out.print("0 ");
    //     }
    //     System.out.println();
    // }



    //butterfly
    // //upper half
    // for(int i=0; i<n ;i++){
    //     for(int j=0;j<=i;j++){
    //         System.out.print("* ");
    //     }
    //     for(int k=0; k<2*(n-i-1); k++){         // derived from 2n - 2(i+1)
    //         System.out.print("  ");
    //     }
    //     for(int p=0;p<=i;p++){
    //         System.out.print("* ");
    //     }
    //     System.out.println();
    // }
    // //lower half
    // for(int i=0; i<n ;i++){
     
    //     for(int j=0;j<n-i;j++){
    //         System.out.print("* ");
    //     }
    //     for(int k=0; k<2*i; k++){
    //         System.out.print("  ");
    //     }
    //     for(int p=0;p<n-i;p++){
    //         System.out.print("* ");
    //     }
    //     System.out.println();
    // }


//rhombus
//     for(int i=0;i<n;i++){
//         //spaces
//         for(int j=0; j<n-i-1;j++){
//             System.out.print(" ");
//         }
//         //stars
//         for(int k=0;k<n;k++){
//             System.out.print("*");
//         }
//         System.out.println();
//     }

    }
}