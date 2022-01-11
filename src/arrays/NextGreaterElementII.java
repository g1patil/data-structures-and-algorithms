package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author g1patil
 * 503. Next Greater Element II
 */
@Platform(Site.LEETCODE)
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Integer> indexCustomStack = new Stack();

        int[] result = new int[nums.length];
        Arrays.fill(result , -1 );


        int[] newNums = new int[nums.length*2];

        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
            newNums[nums.length + i] = nums[i];
        }

        for (int i = 0; i < newNums.length; i++) {

            if (!integerStack.isEmpty() && integerStack.peek() > newNums[i]){
                integerStack.push(newNums[i]);
                indexCustomStack.push(i);
                continue;
            }

            while (!integerStack.isEmpty() && integerStack.peek() < newNums[i]){
                int j = integerStack.pop();
                int k = indexCustomStack.pop();
                if (k < result.length)
                    result[k] = newNums[i];
            }

            integerStack.push(newNums[i]);
            indexCustomStack.push(i);
        }

        return result;
    }

    @Test
    public void test_(){
        nextGreaterElements(new int[]{1,2,3,4,3});
    }
}
