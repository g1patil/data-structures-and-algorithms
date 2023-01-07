package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Return K largest element in array
 *
 * */
public class KLargestElementInArray {

    /**
     * @param k target elements size
     * @param inputs integer array elements
     * @return integer array of size k , with k largest elements
     * */
    private int[] getKLargestElements(int[] inputs,int k){
        int[] result = new int[k];
        Queue<Integer> integerQueue = new PriorityQueue<>();

        if(inputs.length ==0 || inputs.length < k )
            return null;

        for (int number : inputs){
            integerQueue.add(number);
            if(integerQueue.size() > k){
                integerQueue.poll();
            }
        }

        int count = 0;

        for (Integer integer : integerQueue) {
            result[count]=integer;
            count++;
        }

        return result;
    }

    @Test
    public void test(){
        int[] result = getKLargestElements(new int[]{200,9,3,7,1,11,4,19,100},3);
        Assertions.assertEquals(3,result.length);
        Assertions.assertArrayEquals(new int[]{19,100,200}, result);
    }
}
