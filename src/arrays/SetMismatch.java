package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * 645. Set Mismatch
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SetMismatch {

    public int[] findErrorNums(int[] nums) {

        boolean[] numbers = new boolean[nums.length+1];
        List<Integer> result = new ArrayList<>();

        for (int i : nums){
            if (numbers[i]){
                result.add(i);
            } else numbers[i] = true;
        }

        for (int i = 1; i < numbers.length; i++) {
            if (!numbers[i]){
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test(){
        ArrayUtility.print(findErrorNums(new int[]{3,2,3,4,6,5}));
    }
}
