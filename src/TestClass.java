import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    int size;
    int currentSize = 0 ;
    Queue<Integer> integers = new LinkedList<>();
    double avg;

    public TestClass(int size) {
        this.size = size;
    }

    // 346. Moving Average from Data Stream
    public double next(int val) {
        integers.add(val);
        avg+=val;
        if(currentSize < size){
            ++currentSize;
            return avg/currentSize;
        } else {
            avg-=integers.poll();
            return avg/size;
        }
    }

    @Test
    public void test(){

    }

    public static void main(String[] args){
        TestClass testClass = new TestClass(3);

        System.out.println(testClass.next(1));
        System.out.println(testClass.next(10));
        System.out.println(testClass.next(3));
        System.out.println(testClass.next(5));
    }
}