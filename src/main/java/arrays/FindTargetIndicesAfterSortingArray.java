package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 * 2089. Find Target Indices After Sorting Arra
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result= new ArrayList();
        int smallerCount = 0 ;
        int totalOccurence = 0 ;

        for(int i : nums){
            if(i < target)
                smallerCount++;
            if(i == target)
                totalOccurence++;
        }

        while(totalOccurence > 0){
            result.add(smallerCount++);
            totalOccurence--;
        }
        return result;
    }
}
