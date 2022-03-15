package dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author g1patil
 * Optimizing box weights,Given an integer array of the item weights(arr) to be packed,
 * divide the item weights into two subsets, A and B ,
 * for packing into the associated boxes while respecting below conditions between A and B.
 * e.g. n =5 and arr= [3,7,5,6,2]
 */
public class SubSetTargetSumGetSet {

    public List<Integer> getSubSet(List<Integer> array){
        Collections.reverse(array);
        int sum= 0 ;
        for(int i : array){
            sum+=i;
        }
        sum = sum/2 + 1 ;
        List<Integer> result = new ArrayList<>();
        getSet( array, array.size() / 2 , 0 , 0  , sum , result );
        return result;
    }

    public boolean getSet(List<Integer> array, int count , int sum , int index ,int target , List<Integer> result){
         if ( count >= 0 && sum >= target)
             return true;

         if (index >= array.size() || count == 0)
             return false;
         int currentNum = array.get(index);

         if (getSet(array , count - 1 , sum + currentNum , index + 1 , target , result)){
             result.add(currentNum);
             return true;
         }
         if (getSet(array , count  , sum  , index + 1 , target , result)){
             return true;
         }
         return false;
    }

    @Test
    public void test_(){
        List<Integer> list = Arrays.asList(6,7);
        System.out.println(getSubSet(list));
    }
}
