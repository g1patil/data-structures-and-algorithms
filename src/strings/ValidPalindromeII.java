package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * 680. Valid Palindrome II
 *
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {

        int p1 = 0 , p2 = s.length() -1 ;

        while ( p1 <= p2){

            if (s.charAt(p1) == s.charAt(p2)){
                p1++;
                p2--;
            } else return isValidPalindrome(s.substring(p1, p2 )) || isValidPalindrome(s.substring(p1 + 1 , p2 + 1));

        }

        return true;
    }

    public boolean isValidPalindrome(String _string){
        int p1 = 0 , p2 = _string.length() -1 ;

        while (p1 < p2){
            if (_string.charAt(p1)!=_string.charAt(p2))
                return false;
            p1++;
            p2--;
        }
        return true;
    }

    @Test
    public void test_(){
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    @Test
    public void test_2(){
        System.out.println(isValidPalindrome("ji"));
    }
}
