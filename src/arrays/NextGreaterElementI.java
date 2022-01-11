package arrays;

import org.junit.jupiter.api.Test;
import practice_material.cracking_coding_interview.chapter3.Stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 */
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack stack = new Stack();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i : nums1)
            map.put(i , -1);

        for (int i = 0; i < nums2.length; i++) {

            if (!stack.isEmpty() && stack.peek() > nums2[i]){
                stack.push(nums2[i]);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() < nums2[i]){
                int j = stack.pop();
                map.put( j , nums2[i]);
            }

            stack.push(nums2[i]);

        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;

    }

    @Test
    public void test_(){
        int[] nums1 = new int[]{4,1,2};
        int[] num2 = new int[]{1,3,4,2};

        nextGreaterElement(nums1,num2);
    }
}
