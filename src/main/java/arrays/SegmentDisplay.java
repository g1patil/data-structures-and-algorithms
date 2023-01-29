package arrays;

import org.junit.Test;

/**
 * <a href="https://www.geeksforgeeks.org/find-element-using-minimum-segments-seven-segment-display/">
 *     Find element using minimum segments in Seven Segment Display
 *     </a>
 * */
public class SegmentDisplay {
    int[] segment = new int[]{ 6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    public int getCount(int[] ints){
        int max = Integer.MAX_VALUE , result = 0;

        for (int i : ints){
            int total = getCount(i);
            if (total < max){
                max = total;
                result = i;
            }
        }
        return result;
    }

    public int getCount(int number){
        int result = 0;
        while (number > 0){
            result+=segment[number % 10];
            number/=10;
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(
                getCount(
                        new int[]{489, 206, 745, 123, 756}
                )
        );
    }
}
