package Algorithms.searching;

import java.util.Arrays;

public class A3_Search2dArray {
     

    public static void main(String[] args) {
        
        // int[][] matrix = {
        //     {1,4,6,8},
        //     {3,5,7,9},
        //     {5,8,10,11},
        //     {8,10,15,17}};
        //     System.out.println(Arrays.toString(searchInRCsortedMatrix(matrix, 8)));

        int[][] matrixSerialSorted = {
            {1,4,6,8},
            {10,11,12,15},
            {20,22,23,24},
            {25,30,32,34}};

            System.out.println(Arrays.toString(searchInSortedMatrix(matrixSerialSorted, 210)));
    }


    // for any m x n matrix.
    // Linear search is pretty straight forward. just traverse through each element.
    // will find the target in O(N^2) time complexity.


    // For a row-wise and column-wise sorted matrix
    // approach is to eliminate as many rows and columns possible, 
    // to find find target in O(N).


    static int[] searchInRCsortedMatrix(int[][] matrix, int target ){

        int row = 0;
        int column = matrix[0].length-1;    // for rectangular array

        // start iterating from the top-right corner
        // compare with target, start eliminating the row and column

        while(column >=0 && row < matrix.length){
            
            if(matrix[row][column] == target) return new int[] {row,column};

            else if(matrix[row][column] < target) row++;
            else column --;
        }
        return new int[] {-1,-1};
    }


    // for the serially sorted matrix

    static int[] searchInSortedMatrix(int[][] arr, int target){


        int startRow = 0;
        int endRow = arr.length - 1;

        while (startRow <= endRow) {
            
            int midRow = startRow + (endRow-startRow)/2;

            if(target > arr[midRow][arr[midRow].length-1]) startRow = midRow+1;
            else if (target < arr[midRow][0]) endRow = midRow-1;

            for(int c = arr[midRow].length-1; c>=0; c--){

                if(arr[midRow][c] == target) return new int[] {midRow,c};

            }

        }
        return new int[] {-1,-1};
    }


}
