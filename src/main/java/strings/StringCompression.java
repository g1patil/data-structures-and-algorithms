package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 443. String Compression
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class StringCompression {

    public int compress(char[] chars) {
        int slowPointer = 0 , fastPointer = 0 , length = chars.length;
        int currentLength ;

        while (fastPointer < length){
            currentLength = 0 ;
            char currentChar = chars[fastPointer];

            while (fastPointer < length && currentChar == chars[fastPointer]){
                fastPointer++;
                currentLength++;
            }

            chars[slowPointer++] = currentChar;

            if (currentLength > 1){
                for (char c : Integer.toString(currentLength).toCharArray())
                    chars[slowPointer++] = c ;
            }

        }

        return slowPointer;
    }

    @Test
    public void test_(){
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }
}
