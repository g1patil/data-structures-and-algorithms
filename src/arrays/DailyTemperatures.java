package arrays;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author g1patil
 * 739. Daily Temperatures
 */
@Platform(Site.LEETCODE)
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        int[] result = new int[temperatures.length];
        Arrays.fill(result , 0);

        for (int i = 0; i < temperatures.length; i++) {

            if (!integerStack.isEmpty() && integerStack.peek() > temperatures[i]){
                integerStack.push(temperatures[i]);
                indexStack.push(i);
                continue;
            }

            while (!integerStack.isEmpty() && integerStack.peek() < temperatures[i]){
                int j = integerStack.pop();
                int k = indexStack.pop();
                result[k] = i - k  ;
            }

            integerStack.push(temperatures[i]);
            indexStack.push(i);
        }

        ArrayUtility.print(result);

        return result;

    }

    @Test
    public void test_(){
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
