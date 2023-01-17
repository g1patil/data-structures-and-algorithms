package searching;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 1011. Capacity To Ship Packages Within D Days
 */
@Platform(Site.LEETCODE)
public class CapacityToShipPackagesWithinDDays {


    /**
     * Reference : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/256729/JavaC%2B%2BPython-Binary-Search
     * */
    public int shipWithinDays(int[] weights, int days) {
        int low = 0,  high = 0 ;

        for(int i : weights){
            low = Math.max(low , i);
            high+=i;
        }

        while (low < high){
            int mid = (high + low)/2 ;
            int sum = 0 ; int currentDay = 1 ;

            for(int w : weights){
                if ( sum + w > mid){
                    currentDay = currentDay + 1 ;
                    sum = 0 ;
                }
                sum+=w ;
            }

            if (currentDay > days)
                low = mid + 1;
            else high = mid ;

        }

        return high;
    }

    int result = -1 ;
    public int shipWithinDaysMine(int[] weights, int days) {
        int low = 0,  high = 0 ;

        for(int i : weights){
            low = Math.max(low , i);
            high+=i;
        }

        while (low < high){
            int mid = (high + low)/2 ;

            if (countDays(weights , mid , days) > days ){
                low = mid + 1 ;
            } else {
                result = mid ;
                high = mid  ;
            }
        }

        return result;
    }

    private int countDays(int[] weights, int mid, int days) {
        int sum = 0 ; int count = 1 ;
        for (int i : weights){
            if (sum + i > mid){
                count++;
                sum = 0 ;
            }
            sum+=i ;
        }
        return count ;
    }


    @Test
    public void test_(){
        System.out.println(shipWithinDaysMine(new int[]{1,2,3,4,5,6,7,8,9,10} , 5 ));
    }
}
