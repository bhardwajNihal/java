package A2Z_sheet.Recursion.fundamentals;

public class checkPrime {
    

    
    // utility parameterized function to check prime recursively

    public boolean isPrime(int num, int i){


        if(num<=1) return false;
        if(i*i > num) return true;

        return !(num%i==0) && isPrime(num, ++i);
    }

    public boolean checkPrime_rec(int num) {
        //your code goes here
        return isPrime(num,2);
    }
}
