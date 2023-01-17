package arrays;

import org.junit.jupiter.api.Test;
import practice_material.cracking_coding_interview.chapter3.CustomStack;

/**
 * @author g1patil
 *
 * Sample practice for the monotonic stack
 */
public class NextGreaterElement {

    public void nextGreater(int[] ints){

        CustomStack integerCustomStack = new CustomStack();

        for (int i = 0; i < ints.length; i++) {

            if (!integerCustomStack.isEmpty() && integerCustomStack.peek() > ints[i]){
                integerCustomStack.push(ints[i]);
                continue;
            }

            while (!integerCustomStack.isEmpty() && integerCustomStack.peek() < ints[i]){
                int j = integerCustomStack.pop();
                System.out.println("For " + j + " next greater is " + ints[i]);
                continue;
            }

            integerCustomStack.push(ints[i]);
        }
    }

    @Test
    public void test_(){
        nextGreater(new int[]{5,3,2,10,6,8,1,4,12,7,4});
    }
}
