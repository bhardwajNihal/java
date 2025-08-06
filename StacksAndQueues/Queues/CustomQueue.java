package StacksAndQueues.Queues;

public class CustomQueue {
    
    // initializing queue
    // same as stack
    // have an array of values
    // have a pointer to tract the end of the queue;
    // the items are added to the end and 
    // removed from the front

    protected int[] data;
    int end = 0;        // initially point at the 1st index, ele is added then the end moves ahead

    // default value
    private static final int DEFAULT_SIZE = 10;     // want it to remain fixed by default

    // defining constructors
    CustomQueue(){
        this.data = new int[DEFAULT_SIZE];
    }

    // parameterized
    CustomQueue(int size){
        this.data = new int[size];
    }


    //methods
        // push 
        public boolean push(int val) throws Exception{
            if(isfull()){
                throw new Exception("Can't push to a full queue!");
            }
            data[end++] = val;
            return true;
        }

        // remove - the 1st item to be added is the 1st one to be removed
        // just push all the elements to the left, the 1st item will be automatically removed
        // unoptimal but works, with at complexity of O(N).

        public int remove() throws Exception{
            if(isEmpty()){
                throw new Exception("Can't remove from an empty queue.");
            }
            
            int removed = data[0];
            for(int i =0; i< data.length-1; i++){
                data[i] = data[i+1];
            }
            // finally preceed the end
            end--;
            return removed;
        }


        // isempty
        public boolean isEmpty(){
            return end == 0;
        }
        // isfull
        public boolean isfull(){
            return end == data.length;
        }

        // front
        public int front() throws Exception{
            if(isEmpty()){
                throw new Exception("Can't fetch the front of an empty queue!");
            }
            return data[0];
        }

        //display
        public void display(){

            for(int i =0;i < end; i++){
                System.out.print(data[i] + " ");
            }
            System.out.println("end");
        }


        public static void main(String[] args) throws Exception {
            CustomQueue que = new CustomQueue(5);

            que.push(1);        // <--- front, 1st one to be removed
            que.push(2);
            que.push(3);
            que.push(4);
            que.push(5);

            que.display();
            // System.out.println(que.front());

            // System.out.println(que.remove());
            // System.out.println(que.remove());
            // System.out.println(que.remove());
            // System.out.println(que.remove());
            // System.out.println(que.remove());
            System.out.println(que.isEmpty());
            System.out.println(que.isfull());

        }
}
