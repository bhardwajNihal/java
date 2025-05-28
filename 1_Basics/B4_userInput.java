import java.util.Scanner;       // file containing scanner utils

public class B4_userInput {
    
    public static void main(String[] args) {
        
        System.out.println("taking input : ");

        // initializing a Scanner object from inbuild Scanner class
        Scanner sc = new Scanner(System.in);      // for keyboard input 

        //navigating user for input
        // System.out.println("Enter 1st num : ");
        // int a =  sc.nextInt();            // for taking integer input

        // System.out.println("enter 2nd num : ");
        // int b = sc.nextInt();

        // int sum = a+b;
        // System.out.println("sum of the inputs = " + sum);


    // sc.nextFloat() --> float input
    // sc.next() --> string input. --> though single string till the 1st space only
    // sc.nextLine --> for full line of strings separated by space
    // sc.hasNextInt() ---> check the validity of the input value . Here true for int. false for any other datatype
        // System.out.println("enter a string : ");    
        // String str = sc.nextLine();
        //     System.out.println("you entered : " + str);

    

    // Q. program to calculate % marks of 5 subjects, given marks of each out of 100
        // System.out.print("Enter marks of each sub : ");
        // float m1 = sc.nextFloat();
        // float m2 = sc.nextFloat();
        // float m3 = sc.nextFloat();
        // float m4 = sc.nextFloat();
        // float m5 = sc.nextFloat();

        // float percentage = ((m1+m2+m3+m4+m5)*100)/500;

        // System.out.println("%tage marks : " + percentage);

// In Java:
    // int / int = int
    // int / double = double (does floating-point division)


// check if a input is an integer
    // System.out.println("enter a num : ");
    // Scanner sc2 = new Scanner(System.in);
    
    // System.out.println(sc2.hasNextInt());







    }
}
