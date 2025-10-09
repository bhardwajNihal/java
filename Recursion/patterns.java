

public class patterns {

    public static void main(String[] args) {
        
        // pattern1(4, 0);
        pattern2(2, 0 );
    }

    // decreasing tringle pattern

    static void pattern1(int r, int c){

        if(r==0){
            return;
        }

        if(c<r){
            System.out.print("*");
            pattern1(r, c+1);
        } 
        else{
            System.out.println();
            pattern1(r-1, 0);
        }
    }



    // normal ascending triangle
    // just flip  the print and call sequence
    static void pattern2(int r, int c){

        if(r==0){
            return;
        }

        if(c<r){
            pattern2(r, c+1);
            System.out.print("*");
            
        }
        else{
            pattern2(r-1, 0);
            System.out.println();
        }
    }



    // bad way, thought by 1st principles
    static void pattern2__(int n, int r, int c){

        if(c==n) return;

        if(r<=c){
            System.out.print("*");
            pattern2__(n, r+1, c);
        }
        else{
            System.out.println();
            pattern2__(n, 0, c+1);
        }
    }
}