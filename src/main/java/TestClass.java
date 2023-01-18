import java.util.LinkedList;
import java.util.Queue;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    private int size;
    int sum = 0;
    Queue<Integer> q = new LinkedList();
    //Moving Average from Data Stream

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        sum+=val;
        q.add(val);

        if(q.size() <= size){
            return sum/q.size();
        } else {
            sum-=q.remove();
        }
        return sum/size;
    }
}
