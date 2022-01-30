package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 7. Reverse Integer
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ReverseInteger {

    public int reverseHelper(int num , int newNum){
        if (num == 0)
            return newNum;

        int digit = num % 10 ;
        num = num / 10 ;

        /* Reverse this and validate , this is the crux*/
        int sum = newNum * 10 + digit ;

        /* Validate previous step */
        if((sum - digit)/10 != newNum)
            return 0;

        return reverseHelper(num , sum );
    }
    public int reverse(int x) {
        return reverseHelper(x , 0);
    }

    @Test
    public void test_(){
        System.out.println(reverse(1534236469));
    }
}
