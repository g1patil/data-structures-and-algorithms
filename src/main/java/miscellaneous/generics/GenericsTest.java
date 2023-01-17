package miscellaneous.generics;

public class GenericsTest {

    public <T> Class<?> returnElement(T t){
    
        return t.getClass();
        
    }
    
}