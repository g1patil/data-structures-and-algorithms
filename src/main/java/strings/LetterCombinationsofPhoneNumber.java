package strings;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * 17. Letter Combinations of a Phone Number
 */
@Platform(Site.LEETCODE)
public class LetterCombinationsofPhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            int _digit = Character.getNumericValue(digits.charAt(i));

            while (result.peek().length()!=(i + 1)){
                String _s = result.remove();
                for ( char c : mapping[_digit].toCharArray()){
                    result.addLast(_s + c);
                }
            }

        }

        return result;
    }

    @Test
    public void test_(){
        System.out.println(letterCombinations("234"));
    }
}
