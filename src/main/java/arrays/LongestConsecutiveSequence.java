package arrays;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * Node : only works for +ve ints
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int length = Integer.MIN_VALUE;
        for (int l : nums)
            length = Math.max( l , length);

        boolean[] flags = new boolean[length + 1];

        for (int index : nums)
            flags[index] = true;

        int i  = 0 , maxLength = 0 ;

        for (int j = 0; j < flags.length; j++) {
            if (flags[j]){
                i ++;
            } else i = 0;
            maxLength = Math.max(i , maxLength );
        }

        return maxLength;
    }

    @Test
    public void test_(){
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
