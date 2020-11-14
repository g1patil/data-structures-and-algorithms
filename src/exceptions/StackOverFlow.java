package exceptions;
/*
Create a stackoverflow error
*/
public class StackOverFlow {
    

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