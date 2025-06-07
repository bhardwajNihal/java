package Arrays.searching;

import java.util.Arrays;

public class A1_LinearSearch {
    
    public static void main(String[] args) {
        
        // int arr [] = {1,2,3,4,5,6};
        // System.out.println(LS(arr, 59));        // ls in int arr
        // System.out.println(LS2("lakhan", 'x')); // ls in string

        // ls in range --> just start and terminate with start and end instead of 0 and arr.length
        // find minimum element in a given arr

        // ls in 2d array
        // int [][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
        // System.out.println(Arrays.toString(LSin2dArr(arr2,5)));

        // min and max value in a 2d array


        // Q. find the no.of elements in the array with even no. of digits
        // [12,3,556,1234,543] ---> 2
        // int [] arr3 = {1,1234,1,-1223,0,100,-1000};
        // System.out.println(findEleWithEvenNoOfDigits(arr3));


        // System.out.println(countDigits(-124));

        // // max wealth
        // int[][] arr = {{1,2,3},{1,-4,2},{1,10,1}};
        // System.out.println(maxWealth(arr));

    }

    static int LS(int[] arr, int target){

        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }

    static boolean LS2(String str, char target){
        if(str.length()==0) return false;       // length() is a inbuild string method in java
        for(char ch : str.toCharArray()){       // toCharArray() converts raw string to a char array
            if(target==ch) return true;
        }
        return false;
    }
    

    static int[] LSin2dArr(int[][] arr, int target){

        for(int i=0; i<arr.length ;i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] == target) return new int[] {i,j};
            }
        }
        return new int[] {-1,-1};
    }


    // count the no. of digits
    static int countDigits(int num){

        if(num<0) num *= -1;
        if(num==0) return 1;

        int count = 0;
        while(num>0){
            num/=10;
            count++;
        }
        return count;
    }


    static int findEleWithEvenNoOfDigits(int [] arr){
        int countEle = 0;
        for(int i =0;i<arr.length;i++){
            if(countDigits(arr[i])%2==0) countEle++;
        }
        return countEle;
    }


    //Q. leetcode : find max wealth
    // in a 2d array, a row represents a person amount in different bank accouts, total wealth will be the sum of all accounts

    static int maxWealth(int[][] arr){

        int maxAmount = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int currentAmount = 0;
            for(int j=0;j<arr[i].length;j++){
                currentAmount += arr[i][j];
            }
            if(currentAmount > maxAmount) maxAmount = currentAmount;
        }

        return maxAmount;
    }

}
