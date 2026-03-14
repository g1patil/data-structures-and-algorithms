package arrays;

/**
 * 848. Shifting Letters
 * Medium
 * We have a string S of lowercase letters, and an integer array shifts.
 * Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
 * For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
 * Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.
 * Return the final string after all such shifts to S are applied.
 *
 *
 * Example 1:
 *
 * Input: S = "abc", shifts = [3,5,9]
 * Output: "rpl"
 * Explanation:
 * We start with "abc".
 * After shifting the first 1 letters of S by 3, we have "dbc".
 * After shifting the first 2 letters of S by 5, we have "igc".
 * After shifting the first 3 letters of S by 9, we have "rpl", the answer.
 *
 * ref link : https://leetcode.com/problems/shifting-letters/
 * */
public class ShiftingLetters {

    static String shiftLetter(String input, int[] shiftBy){
        char[] inputCharArray = input.toCharArray();
        for(int index = 0;index<inputCharArray.length;index++){
            inputCharArray[index] = (char) ((int) inputCharArray[index] + shiftBy[index]);
        }
        return new String(inputCharArray);
    }
    public static void main(String[] args) {
        System.out.println(shiftLetter("abc",new int[]{1,2,3}));
    }
}
