package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 50. Pow(x, n)
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class Pow {


    public double myPow(double x, int n) {
        long N = n ;

        if (n < 0 ){
            x = 1 / x;
            N= -N ;
        }

        double result =  x ;
        double one = 1;
        for (long i = N; i > 0; i= i/2) {
            if ( i % 2 == 1){one = one * result;}

            result = result * result;
        }

        return one;
    }

    @Test
    public void test_(){
        System.out.println(myPow(0.00001 , 2147483647));


    }
}
