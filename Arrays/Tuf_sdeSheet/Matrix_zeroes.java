package Arrays.Tuf_sdeSheet;

import java.util.Arrays;

public class Matrix_zeroes {
    

    public static void main(String[] args) {
        

    // 1. matrix zeroes

        // brute
            // for(int i =0; i<matrix.length; i++){
            //     for(int j=0; j< matrix[0].length; j++){
            //         // now check if the ele is 0
            //         // if so, mark the row with i, and the column with j
            //         if(matrix[i][j]==0){
            //             int k = 0;
            //             // mark row with i
            //             while(k<matrix[i].length){
            //                 if(matrix[i][k]!=0) matrix[i][k] = Integer.MIN_VALUE+10;      // can't directly mark as 0, as for even marked value the process will carry out which we don't want
            //                 k++;
            //             }
            //             // reset k, mark the column with j
            //             int p=0;
            //             while(p<matrix.length){
            //                 if(matrix[p][j]!=0) matrix[p][j] = Integer.MIN_VALUE+10;      // as if if mark already 0 ele as Integer.MIN_VALUE+10 (random value near to int-min) then can't track that value further to mark corresponding row, and column as 0;
            //                 p++;
            //             }
            //         }
            //     }
            // }
            // // finally we have the marked elements, marked them as 0;
            // for(int i =0; i<matrix.length; i++){
            //     for(int j=0; j< matrix[0].length; j++){
            //         if(matrix[i][j] == Integer.MIN_VALUE+10) matrix[i][j] =0; 
            //     }
            // }

        // better approach,
        // saving time using extra space
        // just take two extra array of size row and column length respectively
        //  better approach, saving time using extra space
        // just take two extra array of size row and column length respectively
            // int[] row = new int[matrix.length];
            // int[] col = new int[matrix[0].length];
            // // fill all with 1
            // Arrays.fill(row,1);
            // Arrays.fill(col,1);
            // for(int i =0; i<matrix.length; i++){
            //     for(int j=0; j< matrix[0].length; j++){
            //         // everytime encountered a 0 value
            //         // mark ith index of row arr, and jth index of row arr to 0
            //             // later iterate over the matrix again, and mark all the elements of 
            //         if(matrix[i][j] == 0){
            //             row[i] = 0;
            //             col[j] = 0;
            //         }
            //     }
            // }
            // // now iterate over the matrix, if row[i]==0, mark all row with i as 0,
            // // if col[i] == 0, mark all the col with i a col
            // for(int i =0; i<matrix.length; i++){
            //     for(int j=0; j< matrix[0].length; j++){
            //         if(row[i] == 0 || col[j] ==0){
            //             matrix[i][j] = 0;
            //         }
            //     }
            // }



    // optimal approach
        // without using extra spaces
        // treating the 1st row and col as the row and col array that we were taking separately   
        // because of overlapping, just take an extra variable to store 1 ele of col
            // int col0 = matrix[0][0];
            //     for(int i =0; i<matrix.length; i++){
            //         for(int j=0; j< matrix[0].length; j++){
                        
            //             // if 0 found
            //             // just , and 
            //             if(matrix[i][j] ==0){
            //                 // mark the ith index of 1st column as 0
            //                 matrix[i][0] = 0;
            //                 // mark jth index of 1st row as 0
            //                 // for 1st col, col0 should be marked, else not
            //                 if(j==0) col0=0;
            //                 else matrix[0][j] = 0;
            //             }
            //         }
            //     }
            //     // now, track for the 0 values in the 1st row and col
            //     // and mark rest of the matrix as 0, except the 1st row and col itself
            //     // will be delt later, keeping in mind the overlappings

            //     for(int i =1; i<matrix.length; i++){
            //         for(int j=1; j< matrix[0].length; j++){
            //             if(matrix[i][0] == 0 || matrix[0][j] ==0){
            //                 matrix[i][j] = 0;
            //             }
            //         }
            //     }

                
            //     // finally check if the 1st row is to marked as 0 or not
            //     // in case of matrix[0][0] ==0 
            //     if(matrix[0][0] == 0){
            //         // mark all ele of 1st row as 0
            //         for(int j =0; j<matrix[0].length; j++){
            //             matrix[0][j] = 0;
            //         }
            //     }

            //     // if 1st column is to be marked as 0, i.e. col0 ==0
            //     if(col0==0){
            //         // mark all ele of 1st column as 0
            //         for(int i =0; i<matrix.length; i++){
            //             matrix[i][0] = 0;
            //         }
            //     }



    }

}
