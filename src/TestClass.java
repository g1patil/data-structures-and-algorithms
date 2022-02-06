import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {



    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int result = 0 ;
        Map<Integer,Integer> map = new HashMap();

        for(int i : nums){

            if(!map.containsKey(i)){

                int left = map.containsKey(i -1 ) ? map.get(i - 1) : 0 ;
                int right = map.containsKey(i  + 1 ) ? map.get(i + 1) : 0 ;
                int length = left + right + 1 ;

                result = Math.max(result , length);

                map.put(i , length);
                map.put( i - left, length);
                map.put( i + right , length);


            } else {
                continue;
            }
        }

        return result ;
    }

    @Test
    public void test_(){
    }

}
