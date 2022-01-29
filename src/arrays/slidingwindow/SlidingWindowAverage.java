package arrays.slidingwindow;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * Algo :
 *
 * sliding window average
 *  create the two pointer
 *
 *  computation : increase the sum
 *  if window is smaller
 *      then increase the window (right pointer)
 *  else {
 *
 *      reverse the computation for the first element
 *
 *      compute the answer
 *      * increase right pointer (most important step)
 *  }
 */
public class SlidingWindowAverage {

    public double[] getSlidingWindowAverage(int[] nums , int k){
        if( k == 1 || nums == null || nums.length < k)
            return new double[0];

        int left = 0 , right = 0 , sum = 0 , length = nums.length;
        double[] avg = new double[nums.length - k + 1];

        while(right < length ){
            //computation step
            sum+=nums[right];

            //increase the window step
            if(right - left + 1  < k){
                right++;
            }else{

                //reverse the computation
                while (right - left + 1  > k){
                    sum-=nums[left];
                    left++;
                }

                //compute the answer
                if (right - left + 1 == k){
                    avg[left] = sum/k;
                    right++;
                }

            }

        }

        return avg;

    }

    @Test
    public void test_(){
        for (double d : getSlidingWindowAverage(new int[]{1,2,3,4,5} , 3)){
            System.out.print( d + " ");
        }
    }
}
