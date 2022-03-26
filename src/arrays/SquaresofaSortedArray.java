package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 977. Squares of a Sorted Array
 * Note : optimal is at the bottom
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SquaresofaSortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        int minIndex = 0 , min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i ++){
            nums[i] = nums[i]*nums[i];
            if( nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
        }

        int left = minIndex - 1 , right = minIndex , resultIndex = 0;

        while(left >= 0 && right < nums.length){

            if(nums[left] < nums[right]){
                squares[resultIndex++]=nums[left];
                left--;
            } else {
                squares[resultIndex++]=nums[right];
                right++;
            }
        }
        while(left >= 0){
            squares[resultIndex++]=nums[left];
            left--;
        }

        while(right < nums.length){
            squares[resultIndex++]=nums[right];
            right++;
        }
        return squares;
    }

    public int[] sortedSquaresOptimal(int[] nums) {
        int[] sqr = new int[nums.length];
        int left = 0 , right = nums.length - 1;

        for(int i = nums.length - 1  ; i >=0 ; i --){
            if(Math.abs(nums[left]) < Math.abs(nums[right]) ){
                sqr[i] = nums[right] * nums[right] ;
                right --;
            } else {
                sqr[i] = nums[left] * nums[left] ;
                left++;
            }
        }
        return sqr;
    }
}
