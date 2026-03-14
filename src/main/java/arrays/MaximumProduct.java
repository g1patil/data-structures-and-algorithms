package arrays;

/**
 * 628. Maximum Product of Three Numbers
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: 6
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 24
 * Example 3:
 *
 * Input: nums = [-1,-2,-3]
 * Output: -6
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 * */
public class MaximumProduct {

    /**
     * Find two elements with largest product
     * @param nums input array of numbers
     * @return largest possible product of two number
     * */
    int maximumProduct(int[] nums){
        int p1,p2,p3,max=Integer.MIN_VALUE;
        int largestNumber=Integer.MIN_VALUE;

        for(int i=0; i < nums.length-2; i++){
            for(int j= i+1; j < nums.length-1; j++){
                for (int k = j+1; k < nums.length ; k ++){
                    max = Math.max(nums[i] * nums[j] * nums[k] , max);
                }
            }
        }
        return max ;
    }
    /**
     * @param input input array of integers
     * @return max product of three integers.
     * */
    int maximumProductLinear(int[] input){
        int m1=0;int m2=0;int m3=0,n1,n2;

        n1 = 0;
        n2 = 0;
        
        for(int number : input){
            if(m1 < number){
                m3 = m2;
                m2 = m1;
                m1 = number;
            }

            if( number < n1 ){
                n2 = n1;
                n1 = number;
            }

        }

        return Math.max(n1*n2*m1, m1*m2*m3);
    }

    public static void main(String[] args) {

        System.out.println(new MaximumProduct().maximumProduct(new int[]{-100,-2,-3,1}));

        System.out.println(new MaximumProduct().maximumProductLinear(new int[]{-10,0,7,2,10,-19,20,1,3,5,-26}));
    }
}
