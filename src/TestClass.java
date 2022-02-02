import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {




    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> min = new PriorityQueue();
        PriorityQueue<Integer> max = new PriorityQueue(Comparator.reverseOrder());

        double[] result = new double[nums.length  - k + 1];


        for(int i = 0 ; i < nums.length ; i ++){

            if(max.isEmpty() || max.peek() > nums[i]){
                max.add(nums[i]);
            } else {
                min.add(nums[i]);
            }

            balanceHeap(max, min);

            if(min.size() + max.size() == 3){
                double med = 0 ;

                if(max.size() > min.size()){
                    med = max.peek();
                } else if (min.size() > max.size()){
                    med = min.peek();
                } else {
                    med = (double) (max.peek() + min.peek())/2;
                }

                int index = i - k + 1;
                result[index] = med;

                if(!max.remove(nums[index])){
                    min.remove(nums[index]);
                }
                index++;
                balanceHeap(max,min);

            }

        }

        return result;
    }

    public void balanceHeap(PriorityQueue<Integer> first , PriorityQueue<Integer> second){
        if(first.size() > second.size() + 1){
            second.add(first.poll());
        } else if (second.size() > first.size() + 1){
            first.add(second.poll());
        }
    }

    @Test
    public void test_(){
        System.out.println(medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7} , 3 ));
    }

    @Test
    public void test_2(){
        System.out.println(medianSlidingWindow(new int[]{1,4,2,3} , 3 ));
    }
}
