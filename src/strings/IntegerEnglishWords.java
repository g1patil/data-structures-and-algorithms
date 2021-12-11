package strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TODO
 * 273. Integer to English Words
 *
 * Convert a non-negative integer num to its English words representation.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 *
 * Input: num = 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * */
public class IntegerEnglishWords {

    private String numberToWords(int num) {
        return null;
    }

    @Test
    public void test(){
        String result = numberToWords(10);
        Assertions.assertEquals("Ten",result);
    }
}
