package dynamicprogramming.knapsack;

import org.junit.jupiter.api.Test;

/**
 * Maximum sum such that no two elements are adjacent
 *
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint
 * that no 2 numbers in the sequence should be adjacent in the array. So 3 2 7 10 should
 * return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
 * Answer the question in most efficient way.
 *
 * GFG : https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/?ref=leftbar-rightbar
 *
 * */
public class MaxSumNoAdjacent {

    public int getMaxSum(int[] ints , int index , int max){

        if (index > ints.length - 1)
            return max ;

        int temp = Math.max( getMaxSum( ints , index +  2 , max + ints[index]) ,
                getMaxSum( ints , index +  1 , max  )  ) ;

        max = Math.max( temp , max ) ;

        return max ;

    }
    @Test
    public void test_(){
        int[] ints = new int[]{5,  5, 10, 40, 50, 35 };
        System.out.println( getMaxSum( ints , 0 , 0 ));
    }
}
