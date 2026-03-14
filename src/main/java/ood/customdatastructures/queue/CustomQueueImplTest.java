package ood.customdatastructures.queue;

import org.junit.jupiter.api.Test;

/**
 * Test clas for CustomQueue
 * */
public class CustomQueueImplTest {

    @Test
    public void test(){
        CustomQueue<Integer> customQueue = new CustomQueueImpl<>();
        customQueue.add(1);
        customQueue.add(2);
        customQueue.add(3);
        customQueue.add(4);

        System.out.println(
                customQueue.poll()
        );
        System.out.println(
                customQueue.poll()
        );
        System.out.println(
                customQueue.poll()
        );
        System.out.println(
                customQueue.poll()
        );

        System.out.println(
                customQueue.isEmpty()
        );
    }

    @Test
    public void test2(){
        CustomQueue<Double> customQueue = new CustomQueueImpl<>();
        customQueue.add(1D);
        customQueue.add(2D);
        customQueue.add(3D);
        customQueue.add(4D);

        System.out.println(
                customQueue.poll()
        );
        System.out.println(
                customQueue.poll()
        );
        System.out.println(
                customQueue.poll()
        );
        System.out.println(
                customQueue.poll()
        );

        System.out.println(
                customQueue.isEmpty()
        );
    }

    @Test
    public void test3(){
        CustomQueue<String> customQueue = new CustomQueueImpl<>();
        customQueue.add("a");
        customQueue.add("a1");
        customQueue.add("a3");
        customQueue.add("a4");

        System.out.println(
                customQueue.poll()
        );
        System.out.println(
                customQueue.poll()
        );
        System.out.println(
                customQueue.poll()
        );
        System.out.println(
                customQueue.poll()
        );

        System.out.println(
                customQueue.isEmpty()
        );
    }
}
