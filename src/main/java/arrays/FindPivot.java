package arrays;

import org.junit.jupiter.api.Test;

/**
 * Find the element, such that all the elements
 * left to it are smaller thant itself and all
 * on the right are bigger than itself
 *
 * Algo : find local max for each element
 * find local min in reverse for each element
 * */
public class FindPivot {

    private int getPivot(int[] ints){
        int[] local_min = new int[ints.length];
        int[] local_max = new int[ints.length];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < ints.length; i++) {
            if(ints[i] > max){
                local_max[i] = ints[i];
                max = ints[i];
            } else local_max[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for(int i = ints.length - 1 ; i >= 0 ; i--) {
            if(ints[i] < min ){
                local_min[i] = ints[i];
                min = ints[i];
            } else local_min[i] = min;
        }

        for(int i = 0; i < ints.length; i++) {
            if(local_min[i] == local_max[i])
                return local_min[i];
        }

        return -1;
    }
    @Test
    public void test(){
        // 4,2,1,5,9,6,7
        // 4,4,4,5,9,9,7  local max
        // 1,1,1,5,6,6,7  local min

        System.out.println(
                getPivot(new int[]{4,2,1,5,9,6,7})
        );
    }
}
