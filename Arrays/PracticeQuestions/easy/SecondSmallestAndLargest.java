package Arrays.PracticeQuestions.easy;

public class SecondSmallestAndLargest {
    

    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4,5,-6,-7,-8};
        // SecondSmallestAndLargestEle(arr);

        seclargest(arr);
        
    }


// 1. Largest element in an array ✅

// 2. 2nd smallest and largest element✅
    // approach-1 : (brute force) - 
        // arrange in asc order, return the 2nd and 2ndlast element; O(N logN) ~> for sorting
    // approach-2 : 

    public static void SecondSmallestAndLargestEle(int[] arr){

        // initializing placeholders
        int small = Integer.MAX_VALUE;
        int secsmall = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int seclarge = Integer.MIN_VALUE;

        // getting the largest ele
        for(int i =0; i< arr.length; i++){
            if(arr[i] > large) large = arr[i];
        }
        // getting smallest
        for(int i =0; i< arr.length; i++){
            if(arr[i] < small) small = arr[i];
        }

        // getting the second largest ele
        for(int i =0; i< arr.length; i++){
            if(arr[i] > seclarge && arr[i] != large) seclarge = arr[i];
        }
        // getting second smallest
        for(int i =0; i< arr.length; i++){
            if(arr[i] < secsmall && arr[i] != small) secsmall = arr[i];
        } 

        System.out.println("second smallest : " + secsmall + " " + "\nsecond largest : "+seclarge); 
        
    }


    // optimal approach - maintain two variables, track the largest, once any larger value is found push the previous larger to the second largest placeholder
    public static void seclargest(int[] arr){

        int largest = Integer.MIN_VALUE;
        int sec_largest = Integer.MIN_VALUE;


        for(int i=0; i< arr.length; i++){

            if(arr[i] > largest){
                sec_largest = largest;
                largest = arr[i];
                
            }
        }
        System.out.println(sec_largest);
    }
}
