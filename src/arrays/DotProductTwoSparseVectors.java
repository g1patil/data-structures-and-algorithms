package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 */
public class DotProductTwoSparseVectors {


    Map<Integer,Integer> sparseMap = new HashMap<>();
    DotProductTwoSparseVectors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i!=0)
                sparseMap.put(i , nums[i]);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductTwoSparseVectors vec) {
        return sparseMap.keySet().stream().mapToInt(k->{
            if (sparseMap.containsKey(k) && vec.sparseMap.containsKey(k)){
                int i = sparseMap.get(k) * vec.sparseMap.get(k);
                return i;
            }
            return 0;
        }).sum();
    }
}
