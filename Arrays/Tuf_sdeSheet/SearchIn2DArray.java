package Arrays.Tuf_sdeSheet;

public class SearchIn2DArray {
    

    // brute
    // iterate all over and find out
    // TC = O(N^2), constant space


    // better   
    // check row-wise whether it potentially has the target
    // if so, apply binary search over that row, 
    // if not, recursively call array subpart, but this time with reduced size(row-1);
    // TC = O(N+ logM), ---> logM for binary search over each row of length M, and N for no. of rows in worse case and applying bs only once
    // SC = O(1)



    // optimal
    // think of the 2d matrix as a 1d array of length m*n
    // we can apply simple binary search over this hypothetical 1d array
    // that gives the better time complexity of :
    // TC = O(log(M*N)), constant space
    // just the task is to convert the mid into corresponding row and col
    // for that, there's this simple formula
        // row = mid/m
        // col = mid%m,         where m is the no. of columns
    static boolean search_optimal(int[][] mat, int target){

        int m = mat.length;
        int n = mat[0].length;
        int s = 0;
        int e = m*n-1;
        
        while(s<=e){
            int mid = s+(e-s)/2;        // calculate mid, simply considering the length of the converted array
            int row = mid/n;        // convert to corresponding row and col, rest is same
            int col = mid%n;
            if(mat[row][col]==target) return true;

            if(target < mat[row][col]) e = mid-1;
            if(target > mat[row][col]) s = mid+1;
        }
        return false;

    }
}
