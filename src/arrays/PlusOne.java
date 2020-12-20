package arrays;
/**
 * 66. Plus One
 * Easy

 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 *
 * */
public class PlusOne {

    /**
     * @param number int array of numbers
     * @return int[] of numbers increment by 1
     * */
    public int[] incrementNumber(int[] number,int incrementBy){
        int sum=0;
        int[] answer = null;

        for(int index= number.length -1 ;index >=0 ; index --){
            sum = number[index] + incrementBy;
            number[index] = sum % 10 ;
            incrementBy = sum / 10 ;
        }

        if(incrementBy  == 1){
            answer = new int[number.length + 1];
            answer[0] = 1;

            for (int i = 1; i <= number.length; i ++){
                answer[i] = number[i-1];
            }
        }
        return (incrementBy == 1) ? answer : number;
    }

    public static void main(String[] args) {
        new PlusOne().incrementNumber(new int[]{9,9,9},9);
    }
}
