package miscellaneous;


/**
 * Can Place Flowers
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 *
 *
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 * */
public class CanPlaceFlowers {

    boolean canPlaceFlowers(int[] input, int target){
        //edge case handle


        for(int index=0; index < input.length-2; index ++){
            if(input[index]==0 && input[index+1]==0 && input[index+2] ==0){
                placeFlower(input,index+1);
                target--;
            }
        }

        return target==0;
    }

    void placeFlower(int[] input, final int place){
        input[place] = 1;
    }

    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1,0,0,0,1},2));
    }
}
