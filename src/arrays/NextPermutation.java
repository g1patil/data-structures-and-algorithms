package arrays;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int lastNumber = nums[nums.length - 1];

        for(int index = nums.length - 1 ; index >=0 ; index --){
            for(int j = index - 1;  j >= 0 ; j --){

                if(nums[j] < nums[index]){
                    int temp = nums[index];
                    nums[index] = nums[j];
                    nums[j] = temp;

                    int p1 = j + 1  , p2 = nums.length - 1;

                    while(p1 < p2){
                        temp = nums[p1];
                        nums[p1] = nums[p2];
                        nums[p2] = temp;
                        p1++;
                        p2--;
                    }

                    return;
                }
            }
        }

        int p1 = 0  , p2 = nums.length - 1;

        while(p1 < p2){
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;
        }



    }

    @Test
    public void test_(){
        int[] ints = new int[]{4,2,0,2,3,2,0};
        nextPermutation(ints);
        System.out.println(ints);
    }
}
