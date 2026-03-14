package strings;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 9. Palindrome Number
 */
@Platform(Site.LEETCODE)
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String number = Integer.toString(x);

        for(int i = 0 , j = number.length()-1 ; i < number.length() && j >= 0 ; i ++ , j --){
            if(number.charAt(i)!=number.charAt(j))
                return false;
        }

        return true;

    }

    @Test
    public void test_(){
        System.out.println(isPalindrome(101));
    }

    @Test
    public void test_2(){
        System.out.println(isPalindrome(0));
    }
}
