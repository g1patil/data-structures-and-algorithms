package arrays;

import org.junit.jupiter.api.Test;
import practice_material.cracking_coding_interview.chapter3.Stack;

/**
 * @author g1patil
 *
 * Sample practice for the monotonic stack
 */
public class NextGreaterElement {

    public void nextGreater(int[] ints){

        Stack integerStack = new Stack();

        for (int i = 0; i < ints.length; i++) {

            if (!integerStack.isEmpty() && integerStack.peek() > ints[i]){
                integerStack.push(ints[i]);
                continue;
            }

            while (!integerStack.isEmpty() && integerStack.peek() < ints[i]){
                int j = integerStack.pop();
                System.out.println("For " + j + " next greater is " + ints[i]);
                continue;
            }

            integerStack.push(ints[i]);
        }
    }

    @Test
    public void test_(){
        nextGreater(new int[]{5,3,2,10,6,8,1,4,12,7,4});
    }
}
