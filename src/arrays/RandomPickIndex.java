package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.*;

/**
 * @author g1patil
 * 398. Random Pick Index
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RandomPickIndex {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public RandomPickIndex(int[] nums) {
        for(int i = 0 ; i < nums.length ; i ++){
            if (map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i] , list);
            }
        }
    }

    public int pick(int target) {
        List<Integer> index = map.get(target);
        int randdom = new Random().nextInt(index.size());
        return index.get(randdom);
    }
}
