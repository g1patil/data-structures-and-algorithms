package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 258. Add Digits
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class AddDigits {

    /**
     * Reference : https://en.wikipedia.org/wiki/Digital_root
     * */
    public int addDigits(int num) {
        if(num < 10){
            return num;
        } else if ( num % 9 == 0){
            return 9;
        } else {
            return num % 9 ;
        }
    }
}
