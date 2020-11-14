package arrays;

/**
 *
 * 1328. Break a Palindrome
 * Medium
 * Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the string becomes the lexicographically smallest possible string that isn't a palindrome.
 * After doing so, return the final string.  If there is no way to do so, return the empty string.
 *
 *
 * Example 1:
 *
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * Example 2:
 *
 * Input: palindrome = "a"
 * Output: ""
 *
 * Ref link : https://leetcode.com/problems/break-a-palindrome/
 * */
public class BreakPalindrome {
    public static String breakPalindrome(String input){
        char a = 'a';
        String result = null;
        char[] inputCharArray = input.toCharArray();

        for (int index = 0 ; index< inputCharArray.length; index ++){
            if(inputCharArray[index] == a){
                continue;
            }
            if(inputCharArray[index] >= a){
                inputCharArray[index] = (char) ((int) inputCharArray[index] - 1);
                result = new String(inputCharArray);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(breakPalindrome("asdfgfdsa"));
    }
}
