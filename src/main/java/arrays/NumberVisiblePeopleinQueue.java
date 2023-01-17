package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author g1patil
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class NumberVisiblePeopleinQueue {


    /**
     * Naive impl
     * */
    public int[] getTotalVisible(int[] nums){
        Stack<Integer> integerStack = new Stack<>();
        Stack<Integer> indexCustomStack = new Stack();

        int[] result = new int[nums.length];
        Arrays.fill(result , 0 );


        for (int i = 0; i < nums.length; i++) {

            if (!integerStack.isEmpty() && integerStack.peek() > nums[i]){
                result[indexCustomStack.peek()]++;
                integerStack.push(nums[i]);
                indexCustomStack.push(i);
                continue;
            }

            while (!integerStack.isEmpty() && integerStack.peek() < nums[i]){
                int j = integerStack.pop();
                int k = indexCustomStack.pop();
                result[k]++;
            }

            if (!indexCustomStack.isEmpty())
                result[indexCustomStack.peek()]++;
            integerStack.push(nums[i]);
            indexCustomStack.push(i);
        }


        return result;
    }

    public int[] canSeePersonsCountImproved(int[] A) {
        int n = A.length, res[] = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i])
                res[stack.pop()]++;
            if (!stack.isEmpty())
                res[stack.peek()]++;
            stack.add(i);
        }
        return res;
    }


    public int[] canSeePersonsCount(int[] heights) {
        int[] result = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            //result[i] = getTotalVisible(i , heights);
        }

        return result;
    }

    @Test
    public void test_(){
        int[] ints = new int[]{10,6,8,5,11,9};
        for (int i : getTotalVisible(ints))
            System.out.print(i + "  ");
    }
}
