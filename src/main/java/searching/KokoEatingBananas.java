package searching;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 875. Koko Eating Bananas
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class KokoEatingBananas {

    int result = -1 ;
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1 ;int max = Integer.MIN_VALUE;
        for (int currentPile : piles){
            max = Math.max( max , currentPile);
        }


        while (min < max) {
            int mid = (min + max)/2 ;

            if (calculateHours(piles , mid) > h){
                min = mid + 1 ;
            } else {
                result = mid ;
                max = mid;
            }
        }

        return max;
    }

    private int calculateHours(int[] piles, int capacity) {
        int hour = 0 ;
        for ( int currentPile : piles){

            if (currentPile > capacity){
                if ( currentPile % capacity > 0){
                    hour = hour + currentPile/capacity + 1;
                } else hour = hour + currentPile/capacity;
            } else hour ++ ;
        }
        return hour;
    }

    @Test
    public void test_(){
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20} , 6 ));
    }

    @Test
    public void test_2(){
        System.out.println(minEatingSpeed(new int[]{50} , 49 ));
    }
}
