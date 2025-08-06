package StacksAndQueues.Stacks.Arr_Stack_implementation;

public class CustomStack {
    
    protected int[] data;
    // default size value
    private static final int DEFAULT_SIZE = 10;

    // pointer to keep track of the whole stack
    private int ptr = -1;           // initially at -1;

    // parameterized constructor to initialize the stack with the given size
    CustomStack(int size){
        this.data = new int[size];
    }

    // constructor to initialize the stack with the default value
    CustomStack(){
        this(DEFAULT_SIZE);         // calling constructor inside the constructor, with the default size
    }


    //methods
        // push 
        public boolean push(int val) throws Exception{

            if(isFull()){
                throw new Exception("Can't push in an full stack!");
            }
            data[++ptr] = val;
            return true;
        }
        // pop
        public int pop() throws Exception{
            if(isEmpty()){
                throw new Exception("Can't pop in an empty stack!");
            }
            return data[ptr--];
        }
        
        
        // peek
        public int peek() throws Exception{
            if(isEmpty()){
                throw new Exception("Can't peek in an empty stack!");
            }
            return data[ptr];
        }


        // isEmpty
        public boolean isEmpty(){
            return ptr == -1;
        }
        // isFull
        public boolean isFull(){
            return ptr == data.length-1;
        }


        public static void main(String[] args) throws Exception {
            CustomStack stack = new CustomStack(5);

            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            // stack.push(5);

            System.out.println("1st out");
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            // System.out.println(stack.pop());
            // System.out.println(stack.pop());
            
            // System.out.println(stack.peek());
            // System.out.println(stack.isEmpty());
            // System.out.println(stack.isFull());
        }


}
