package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraversal {

    // given a matrix, traverse and print ele in spiral order

    // 1 2 3
    // 4 5 6
    // 7 8 9 ===> 1,2,3,6,9,8,7,4,5

    public static List<Integer> spiralTraversal(int[][] matrix) {

        int top = 0;
        int left = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;

        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left<= right) {

            // top row traversal, left to right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            
            // last column traversal, top to bottom
            for(int i = top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }

            right--;
    
            // bottom row: right → left (checking if row still valid)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // left column: bottom → top (checking if col still valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
       
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralTraversal(mat);
    }
}
