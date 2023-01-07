package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * @author g1patil
 * 1985. Find the Kth Largest Integer in the Array
 * Very good and very tricky question.
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FindtheKthLargestIntegerinArray {

    public String kthLargestNumber(String[] nums, int k) {

        /*Crux of this also. If the length are equal then, regular string compare , if non-equal then length*/
        PriorityQueue<String> queue= new PriorityQueue<String>((o1,o2)->{
            if (o1.length() == o2.length()){
                return o1.compareTo(o2);
            }

            return Integer.compare(o1.length(),o2.length());
        });

        for (String s : nums){
            queue.add(s);
        }


        while (queue.size() > k)
            queue.poll();
        return queue.peek();
    }

    @Test
    public void test_(){
        System.out.println(kthLargestNumber(new String[]{"39","31","36","760","100"}, 4 ));
    }

    @Test
    public void test_2(){
        System.out.println(kthLargestNumber(new String[]{"10000000000000000","4","9","7","8" , ""}, 1 ));
    }
}
