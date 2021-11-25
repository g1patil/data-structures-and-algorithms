package exceptions;
/*
Create a stackoverflow error
*/
public class StackOverFlow {
    

    /**
     * Call the method recursively to fill the stack.
     * After number of calls, the stack should fill and
     * method will throw stackoverflow exception.
     * */
    void dummyMethod(){
        System.out.println("Calling the method");
        dummyMethod();
    }

    public static void main(String[] args) {
        StackOverFlow stackOverFlow = new StackOverFlow();
        try {
            stackOverFlow.dummyMethod();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}