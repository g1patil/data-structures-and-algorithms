import org.junit.jupiter.api.Test;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {



    //283. Move Zeroes
    public int removeDuplicates(int[] nums) {
        int slow = 0 , fast = 0  , current = Integer.MIN_VALUE;

        while( fast < nums.length){
            int[] next = getNext(nums,current,fast);

            int nextElement = next[0];
            int nextIndex = next[1];

            if(nextIndex == -1)
                break;

            nums[slow] = nextElement;
            fast = nextIndex;
            fast++;
            slow++;
            current = nextElement;
        }
        return slow;
    }

    public int[] getNext(final int[] nums , int current , int start){
        while(start < nums.length && current == nums[start]){
            start++;
        }
        if(start >= nums.length)
            return new int[]{-1,-1};
        return new int[]{nums[start],start};
    }




    @Test
    public void test(){
        removeDuplicates(new int[]{1,1});
    }
}