package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.*;

/**
 * @author g1patil
 * 414. Third Maximum Number
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Set<Integer> set = new TreeSet(Comparator.reverseOrder());
        Set<Integer> visited = new HashSet();

        for(int n : nums){
            set.add(n);
            visited.add(n);
        }

        int i = 0;
        int k = visited.size() >= 3 ? 3 : 1 ;


        int result = 0;

        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            i++;
            result = (int) iterator.next();

            if(i == k)
                break;
        }

        return result;
    }
}
