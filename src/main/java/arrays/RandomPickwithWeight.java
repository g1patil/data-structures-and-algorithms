package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 528. Random Pick with Weight
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RandomPickwithWeight {

    int[] presum ;
    int total;
    public RandomPickwithWeight(int[] w) {
        presum = new int[w.length];
        int sum = 0;
        for(int i = 0 ; i < w.length ; i++){
            sum+=w[i];
            presum[i] = sum;
        }
        total = sum;

    }

    public int getIndex(double p){
        int low= 0 , high = presum.length;

        while(low < high){
            int mid = low + (high - low)/2 ;

            if(presum[mid] < p){
                low = mid + 1;
            } else{
                high = mid;
            }
        }

        return high;
    }

    public int pickIndex() {
        return getIndex( Math.random()*total);
    }
}
