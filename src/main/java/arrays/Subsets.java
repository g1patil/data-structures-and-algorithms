package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 * 78. Subsets
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
                    List<List<Integer>> newSet = new ArrayList<>();
                    for (List<Integer> list : result)
                        newSet.add(new ArrayList<>(list));
                    for (int j = 0; j < newSet.size(); j++) {
                        newSet.get(j).add(nums[i]);
                    }
                    for (List<Integer> list : newSet)
                        result.add(list);

        }
        return result;
    }

    @Test
    public void test_(){
        System.out.println(subsets(new int[]{1,2,2}));
    }
}
