package Arrays.Tuf_sdeSheet;

import StacksAndQueues.Queues.Questions.Reverse;

public class RotateMatrix {
    
    // brute
    // Take another dummy matrix of n*n,
    //  take the first row of the matrix and put it in the last column of the dummy matrix,
    //  take the second row of the matrix, and put it in the second last column of the matrix and so on...
    // Time and space complexity of O(N^2);


    // optimal
    // Transpose the matrix.
    // Reverse each row of the matrix.
    // TC =  O(N*N) + O(N*N), one for transposing, and another for swapping each row
    // SC = O(1), as no extra space needed
    public void rotate(int[][] matrix) {
        
        transpose_sqMat(matrix);       

        int col1 =0;
        int col2 = matrix[0].length-1;

        while(col1 < col2){
            for(int row=0; row<matrix.length; row++){
               int temp = matrix[row][col1];
                matrix[row][col1] = matrix[row][col2];
                matrix[row][col2] = temp; 
            }
            col1++;
            col2--;
        }

    }
    // in place transpose - only possible for square matrix
    static void transpose_sqMat(int[][] matrix){

    // j starts next to the diagonal
    // basically only iterate and swap with the upper triangular part to avoid redundant swaps
        for(int i =0; i<=matrix.length; i++){
            for(int j =i+1; j<matrix[0].length; j++ ){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


}
