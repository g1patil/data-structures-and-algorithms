package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 * 13. Roman to Integer
 * O(9) - > O(1)
 * Max roman is : MMMCMXCIX
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class Roman2Integer {

    Map<Character,Integer> ROMAN ;

    public void init(){
        ROMAN = new HashMap<>();
        ROMAN.put('I', 1);
        ROMAN.put('V', 5);
        ROMAN.put('X', 10);
        ROMAN.put('L', 50);
        ROMAN.put('C', 100);
        ROMAN.put('D', 500);
        ROMAN.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.isBlank())
            return 0;
        init();
        int result = 0 , last = Integer.MAX_VALUE;

        for(char c : s.toCharArray()){
            int value = ROMAN.get(c);

            if (value > last){
                result-=last;
                value-=last;
                result+=value;
            } else {
                result+=value;
                last = value;
            }
        }

        return result;
    }

    @Test
    public void test_(){
        System.out.println(romanToInt("MMMCMXCIX"));
    }
}
