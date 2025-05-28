import java.util.Scanner;

public class B8_Methods {
    
    public static void main(String[] args) {

        // methods
        // return type
        // parameters
        // variable arguments
        // pass by value
        // swap value
        // scope
        // overloading
        // shadowing

        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number : ");
        int num = sc.nextInt();
        // System.out.println(checkPrime(num));
        // System.out.println(checkArmstrongNum(num));

        // print all armstrong num till num
        for(int i=0;i<num;i++){
            if(checkArmstrongNum(i)) System.out.println(i);
        }
        sc.close();
    }

    static boolean checkPrime(int num){
        boolean isPrime = true;
        for( int i=2; i<num ;i++){
            if(num%i==0) isPrime=false;
        }
        return isPrime;
    }

    static boolean checkArmstrongNum(int num){

        int originalNum = num;      // not to be compared to num as it will be reduced to 0 by the end of the loop
        int SumOfCubes = 0;
        while(num>0){
            int ud = num%10;
            SumOfCubes += ud*ud*ud; 
            num /= 10;
        }
        if(SumOfCubes==originalNum) return true;
        return false;    

    }
}
