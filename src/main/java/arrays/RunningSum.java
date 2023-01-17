package arrays;
/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.
 * 
 * 
 * Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
*/
public class RunningSum {

    public int[] runningSum(int[] nums) {
        
        for(int i=1;i< nums.length;i++){
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
    public static void main(String[] args) {
       new RunningSum().runningSum(new int[]{1,2,3,5}).toString();
    }
}