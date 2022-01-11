package arrays;

import org.junit.jupiter.api.Test;
import practice_material.cracking_coding_interview.chapter3.CustomStack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 */
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        CustomStack customStack = new CustomStack();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i : nums1)
            map.put(i , -1);

        for (int i = 0; i < nums2.length; i++) {

            if (!customStack.isEmpty() && customStack.peek() > nums2[i]){
                customStack.push(nums2[i]);
                continue;
            }

            while (!customStack.isEmpty() && customStack.peek() < nums2[i]){
                int j = customStack.pop();
                map.put( j , nums2[i]);
            }

            customStack.push(nums2[i]);

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
