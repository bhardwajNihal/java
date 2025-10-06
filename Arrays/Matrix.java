package Arrays;

import java.util.Arrays;

public class Matrix {

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

    // for other matrices
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }



    // Matrix multiplication
    public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        // Check multiplication validity
        if (B.length != n) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication!");
        }

        int[][] result = new int[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    



    public static void main(String[] args) {
        
        int[][] mat = {{1,2,3},{1,2,3},{1,2,3}};

        for(int[] row : mat){
            System.out.println(Arrays.toString(row) + ", ");
        }
        transpose_sqMat(mat);

        
        for(int[] row : mat){
            System.out.println(Arrays.toString(row) + ", ");
        }

    }
}
