package A2Z_sheet.Recursion.fundamentals;

public class sumOfDigits {

    // find sum till single digit

    public int addDigits(int num) {
        
        if(num/10==0) return num;

        int sum = num%10 + addDigits(num/10);
        if(sum > 9) return addDigits(sum);      // if sum is multidigits, call addDigits again
        return sum;         // else return the single digit sum
    }
    
}