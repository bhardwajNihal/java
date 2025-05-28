import java.util.Scanner;

public class B6_conditionals {

    public static void main(String[] args) {

        // // simple if else
        // int age = 60;
        // if(age>18){
        // System.out.println("Eligible to vote!");
        // }
        // else{
        // System.out.println("NOT Eligible to vote!");
        // }

        // // else if ladder, to check for multiple conditions, and execute only one

        // if (age > 60) {
        // System.out.println("buddhe!");
        // }
        // else if(age > 40){
        // System.out.println("mid-life crisis!");
        // }
        // else if(age > 20){
        // System.out.println("full on sex sux!");
        // }
        // else{
        // System.out.println("no sex");
        // }

        // // SWITCH CASE : apt for specific conditions
        // switch (age) {
        // case 18:
        // System.out.println("you just became adult!");
        // break;
        // case 21:
        // System.out.println("Go for a job, or higher studies!");
        // break;
        // case 28:
        // System.out.println("Ideal age for marriage then full on sex sux!");
        // break;
        // case 60:
        // System.out.println("retire!");
        // break;
        // default:
        // System.out.println("do whatever you want!");
        // break;
        // }

        // Q1. check if pass, 33 in each , overall 40 required
        Scanner marksInput = new Scanner(System.in);

        // System.out.println("Enter m1 : ");
        // int m1 = marksInput.nextInt();
        // System.out.println("Enter m2 : ");
        // int m2 = marksInput.nextInt();
        // System.out.println("Enter m3 : ");
        // int m3 = marksInput.nextInt();

        // if(m1<33 || m2 < 33 || m3<33 || ((m1+m2+m3)/3) < 40 ){
        // System.out.println("FAIL!");
        // }
        // else System.out.println("PASS!");

     // Q2. Calculate tax, a/c to the slab
        // Scanner salaryInput = new Scanner(System.in);
        // System.out.println("Enter you salary : ");
        // double salary = salaryInput.nextDouble();
        // double tax = 0;

        // if (salary < 250000) {
        //     tax += 0;
        //     System.out.println("Tax : " + tax);
        // } 
        // else if(salary >= 250000 && salary < 500000) {
        //     tax += 0.05*(salary-250000);
        //     System.out.println("Tax : Rs " + tax);
        // } 
        // else if(salary >= 500000 && salary < 1000000) {
        //     tax += (0.05*(500000-250000));       // till 5L
        //     tax += 0.20*(salary-500000); // till 10L
        //     System.out.println("Tax : Rs " + tax);
        // } 
        // else{
        //     tax += (0.05*(500000-250000));   // till 5L
        //     tax += (0.20*(1000000-500000));   // till 10L
        //     tax += (0.30*(salary-1000000)); //till salary
        //     System.out.println("Tax : Rs " + tax);
        // } 
        // salaryInput.close();



    // rock paper scissor 
        System.out.println("Choose rock/paper/scissor : ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        double rand;

        if(userInput.equals("rock")){       // can't use == to compare strings
             rand = Math.random();
            if(rand<0.33){
                System.out.println("System: rock \t ---TIE---");
            }
            else if(rand>=0.33 && rand<0.66){
                System.out.println("System: paper \t --- you lost---");
            }
            else{
                System.out.println("System: scissor \t ---You WON---");
            }
        }
        else if (userInput.equals("paper")){
            rand = Math.random();
            if(rand>=0.33){
                System.out.println("System: rock \t ---you won---");
            }
            else if(rand>=0.33 && rand<0.66){
                System.out.println("System: paper \t --- TIE---");
            }
            else{
                System.out.println("System: scissor \t ---you lost---");
            }
        }
        else if(userInput.equals("scissor")){
            rand = Math.random();
            if(rand<0.33){
                System.out.println("System: rock \t ---you lost---");
            }
            else if(rand>=0.33 && rand<0.66){
                System.out.println("System: paper \t --- you won---");
            }
            else{
                System.out.println("System: scissor \t !!!TIE!!!");
            }
        }

        
        


    }
}