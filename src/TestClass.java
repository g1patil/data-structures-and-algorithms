import data.TreeNode;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {


    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        int[] nums = new int[envelopes.length * 2];

        int i = 0 ;
        for(int[] num : envelopes){
            Arrays.sort(num);
            nums[i++] = num[0];
            nums[i++] = num[1];
        }

        return lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int[] memoization = memoization = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            memoization[i] = 1 ;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    memoization[i] = Math.max( memoization[j] + 1 , memoization[i] );
                }
            }
        }

        int result = 1 ;

        for (int i : memoization)
            result = Math.max(result , i );

        return result;
    }

    @Test
    public void test_(){

       int[][] ints = new int[][]{
               new int[]{5,4},
               new int[]{6,4},
               new int[]{6,7},
               new int[]{2,3}
       };

       maxEnvelopes(ints);
    }

    @Test
    public void test_2(){

      divide(-1,-1);
    }

    public int divide(int dividend, int divisor) {
        int sign  = (divisor < 0 && dividend < 0) ? 1 : (divisor < 0 || dividend < 0) ? -1 : 1 ;
        int result = 0 ;
        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);

        while(dividend >= divisor){

            dividend-=divisor;
            result++;
            System.out.println(result);
        }
        return result*sign;
    }

    @Test
    public void test_3(){
        List<SomeClass> list = new ArrayList<>();
        list.add(new SomeClass(1,"jivan"));
        list.add(new SomeClass(2,"manoj"));
        list.add(new SomeClass(3,"dhana"));


        int i = 0;
        IntStream.rangeClosed(1, Integer.MAX_VALUE).asLongStream().forEach(System.out::println);
    }

    class SomeClass {
        int id;
        String name;
        SomeClass(int i , String name){this.id = i ; this.name = "jivan";}

    }


}
