package arrays;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class NumberVisiblePeopleinQueue {


    public int getTotalVisible(int index , int[] heights){
        int target = heights[index];
        int max = Integer.MIN_VALUE;
        int count = 0 ;
        boolean found = false;

        for (int i = index+1; i < heights.length ; i++) {
            if (heights[i] > max && !found){
                count++;
                max = Math.max(max , heights[i]);

                if (heights[i] > target)
                    found = true;
                if (found)
                    break;
            }
        }
        return count;
    }


    public int[] canSeePersonsCount(int[] heights) {
        int[] result = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            result[i] = getTotalVisible(i , heights);
        }

        return result;
    }

    @Test
    public void test_(){
        int[] ints = new int[]{5,1,2,3,10};
        for (int i : canSeePersonsCount(ints))
            System.out.print(i + "  ");
    }
}
