import java.util.ArrayList;
import java.util.Arrays;

public class DS_1_Arrays {

    public static void main(String[] args) {
        
        // int[][] arr ={          // non-uniform 2d array
        //             {1,2,3,4},
        //             {1,2},
        //             {1,2,3,4,5}
        //             };
        
        // for(int i=0; i<arr.length; i++){
        //     for (int j=0; j<arr[i].length ;j++){
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }



    // // Dynamic Array --> Arraylist (similar to vertors in C++)
    //     ArrayList<Integer> list1 = new ArrayList<>(10);

    // // can add as many elements, irrespective of the initial capacity
    // // arrayList  are used when the no. of elements to be present in the array are not known upfront.
    //     list1.add(10);
    //     list1.add(20);
    //     list1.add(30);
    //     list1.add(10);
    //     list1.add(20);

    //     for(int nums : list1){              // enhanced for loop to print array elements
    //         System.out.print(nums + " ");
    //     }
    //     System.out.println();


    
    int [] arr = {1,2,13,4,50,6};
    swap(arr,0,3);
    System.out.println(Arrays.toString(arr));

    System.out.println(maxEle(arr));

    int[] arr2 = {1,2,3,4,5,6};
    reverseArr(arr2);
    System.out.println(Arrays.toString(arr2));
    }


    // q - swap elements of an array 
    static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;   
    }

    // max ele of an array 
    static int maxEle(int arr[]){
        int max =Integer.MIN_VALUE;
        for(int i =0;i < arr.length;i++){
            if(arr[i] > max){ 
                max = arr[i];
            };
        }
        return max;
    }



    // reverse an array 
    static void reverseArr(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while (i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}