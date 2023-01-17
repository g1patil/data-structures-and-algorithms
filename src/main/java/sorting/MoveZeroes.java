package sorting;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 283. Move Zeroes
 */
@Platform(Site.LEETCODE)
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int slowPointer = 0, fastPointer = 0;

        while ( fastPointer < nums.length ){

            /* look for first zero */
            while (slowPointer < nums.length &&  nums[slowPointer] != 0)
                slowPointer++;

            /* if the fast pointer got left behind, bring it to same level*/
            if (fastPointer == 0 && slowPointer > 0)
                fastPointer = slowPointer;

            /* look for first non-zero */
            while (fastPointer < nums.length && nums[fastPointer] == 0)
                fastPointer++;

            /* break if the pointers go out */
            if (fastPointer >= nums.length || slowPointer >= nums.length)
                break;

            /* swap the elements */
            int temp = nums[fastPointer];
            nums[fastPointer] = nums[slowPointer];
            nums[slowPointer] = temp;

            /* increase the pointers to next */
            slowPointer++;
            fastPointer++;

        }
    }

    @Test
    public void test_(){
        int[] ints = new int[]{1,0};
        moveZeroes(ints);
    }
}
