package Arrays.Tuf_sdeSheet;

public class PowerXY {

    // linear approach was throwing TLE


    // logaritmic approach
    // TC = O(logN), space is O(1)
    public double myPow(double x, int n) {
        
        if(n==0) return 1;
        int exp = n;

        if(n<0){
            if(n==Integer.MIN_VALUE) exp = Integer.MAX_VALUE -1;        // as abs(int_max) is 1 lesser
            else{
                exp = -n;
            }
        }

        double ans = 1.0;
        while(exp>0){

            // if exp is even, raise base to the power base, and halve the exponent
            // and subsequently calculate the answer
            // by this way the ans can be calculated in logarithmic time complexity
            if(exp%2==0){
                x = x*x;
                exp = exp/2;
            }
            else{       // if exp is odd, just multiply current ans with base, and decrease exp by -1
                ans = x*ans;            // at last exp becomes 1, simply return ans*x
                exp--;
            }
        }

        // finally in case of -ve power
        // return 1/ans
        if(n<0) return 1.0/ans;
        return ans;

    }


}
