package miscellaneous;
/**
 * Silly code to show that you can call the main method. No biggy !!
 * 
 * @author g1patil
*/
public class CallMainMethod {
    public static void main(String[] args) {
        String[] names = {"names"};

        if(args.length == 0){
            System.out.println("I am calling main method");
            CallMainMethod.main(names);
        }
        
    }
}