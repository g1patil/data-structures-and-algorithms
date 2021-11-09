package sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * BucketSort algorithm
 * Create the buckets, add the numbers in bucket, sort each bucket
 * merge each bucket
 * Done !!
 *
 * */
public class BucketSort {

    public LinkedList<Float> bucketSort(final float[] floatsNumbers){
        ArrayList<LinkedList<Float>> linkedListArrayList = new ArrayList<>(floatsNumbers.length);

        for (int i = 0; i < floatsNumbers.length; i++) {
            linkedListArrayList.add(new LinkedList<>());
        }

        for (int i = 0; i < floatsNumbers.length; i++) {
            linkedListArrayList.get((int) ( floatsNumbers.length * floatsNumbers[i])).add( floatsNumbers[i]);
        }

        //sort using any method or algorithm
        linkedListArrayList.forEach( a-> Collections.sort(a));

        LinkedList<Float> floatLinkedList = new LinkedList<>();
        linkedListArrayList.forEach(a -> a.forEach( e-> {
            floatLinkedList.add( e );
        }));

        return floatLinkedList;
    }

    @Test
    public void test(){
        System.out.println(this.bucketSort(new float[]{0.9f , 0.37f,0.79f,0.52f,0.21f , 0.01f , 0.33f , 0.06f , 0.8f , 0.77f}));
    }
}
