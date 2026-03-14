package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author https://leetcode.com/akshayaamar05
 * 8. String to Integer (atoi)
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class StringtoInteger {

    public int myAtoi(String s) {
        final int length = s.length() , limit = Integer.MAX_VALUE/10;
        int index = 0 , sign = 1, result = 0;

        if (length == 0)
            return 0;

        //traverse the white space
        while ( index < length && s.charAt(index) == ' ')
            index++;

        if (index == length)
            return 0;

        if (s.charAt(index) == '-' || s.charAt(index) == '+'){
            sign = s.charAt(index) == '-' ? -1 : 1 ;
        }

        while ( index < length && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0' ;

            if (result > limit || result == limit && digit > 7){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit ;
            index ++;
        }
        return sign * result;
    }

    @Test
    public void test_(){
        System.out.println(myAtoi("1234567864346354634645"));
    }

}
