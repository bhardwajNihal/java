public class B3_Args {

    // function to understand what string[] args is and how to pass it as arguments
    // just pass the arguments in the terminal using java Args.java ...args
    public static void main(String[] args) {            
        if(args.length==0){
            System.out.println("No arguments passed!");
        }
        else{
            for( byte i=0; i<args.length ; i++){
                System.out.println("args" + i + " - " + args[i]);
            }
        }
    }
}