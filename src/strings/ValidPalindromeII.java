package strings;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * 680. Valid Palindrome II
 *
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int count = 0 ;
        if (s.isBlank() || s.length() == 1 || s.length() == 2){
            return true;
        }

        int p1 = 0 , p2 = s.length() -1 ;

        while ( p1 <= p2){

            if (s.charAt(p1) == s.charAt(p2)){
                p1++;
                p2--;
            } else if ( s.charAt(p1+1) == s.charAt(p2)){
                count ++;
                p1++;
            } else if (s.charAt(p1) == s.charAt(p2 - 1)){
                count++;
                p2 --;
            } else {
                count = 2 ;
                break;
            }
        }

        return count  <=  1  ;
    }

    @Test
    public void test_(){
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
