package miscellaneous.assertions;

import java.lang.reflect.Executable;

public class Assertion { 
    
    static class AssertChecker{

         public static <T> void assertthrows(Class<T> c, Executable object) {

            try{
                //TODO
            } catch (Exception e){

            }
        }

    }

    static void throwException(String s){
        throw new NullPointerException();
    }
    public static void main(String[] args) {
        //AssertChecker.assertthrows(NullPointerException.class, ()->throwException("name"));
    }
}

