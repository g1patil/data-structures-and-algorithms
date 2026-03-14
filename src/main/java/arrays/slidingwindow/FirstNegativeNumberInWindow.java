package arrays.slidingwindow;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author g1patil
 * First negative integer in every window of size k
 */
@Platform(Site.GEEKFORGEEKS)
public class FirstNegativeNumberInWindow {

    public List<Integer> printFirstNegativeInteger(int array[], int N, int K) {
        int start = 0  , end = 0 ;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        while (end < N ){
            /* do the calculations , which is -ve check */
            if (array[end] < 0){
                queue.add(array[end]);
            }

            /* check is window size , increase the pointers based on it. */

            if (end - start + 1 < K ){
                end++;
            } else {
                if (queue.isEmpty()){
                    result.add(0);
                } else {
                    result.add(queue.peek());
                }

                if (!queue.isEmpty() && queue.peek() == array[start])
                    queue.poll();

                start++;
                end++;
            }


        }

        return result;

    }

    @Test
    public void test_(){
        int[] input = new int[]{
                12,-1,-7,8,-15,30 , 16,28
        };
        System.out.println(printFirstNegativeInteger(input , input.length , 3 ));
    }
}
