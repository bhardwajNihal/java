package StacksAndQueues.Stacks.Arr_Stack_implementation;

public class DynamicArrStack extends CustomStack{
 
    // defining constructors
    DynamicArrStack(){
        super();
    }
    
    DynamicArrStack(int size){
        super(size);
    }


    public boolean push(int value) throws Exception{

        // if stack is full
        // then create a new arr of double capacity
        // copy the entire previous element

        if(isFull()){
            int[] temp = new int[data.length * 2];

            // copy all elements of data to this
            for(int i =0;i<data.length;i++){
                temp[i] = data[i];
            }

            // finally replace original data to temp
            data = temp;        // data is now updated
        }

        // at this point it's assured the stack is not full,as if full the size is already doubled, simply call the push method of the parent class
        return super.push(value);

    }


    public static void main(String[] args) throws Exception{
        
        DynamicArrStack stk = new DynamicArrStack(3);

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        

       System.out.println( stk.pop());
       System.out.println( stk.pop());
       System.out.println( stk.pop());
       System.out.println( stk.pop());
       System.out.println( stk.pop());
       System.out.println( stk.pop());
       System.out.println( stk.pop());
       System.out.println( stk.pop());

    //    System.out.println( stk.pop());
    //    System.out.println( stk.pop());



    }
}
