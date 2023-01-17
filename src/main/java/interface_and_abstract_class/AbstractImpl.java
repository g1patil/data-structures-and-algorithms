package interface_and_abstract_class;

public class AbstractImpl extends MyAbstractClass{
    @Override
    public String printSomething() {
        MyAbstractClass instance = new MyAbstractClass() {
            @Override
            public String printSomething() {
                return null;
            }
        };
        
        return null;
    }
    public void some(){

    }
}
