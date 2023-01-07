package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 387. First Unique Character in a String
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        int[] fre = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int c  = s.charAt(i) - 'a';
            fre[c]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int c  = s.charAt(i) - 'a';
            if (fre[c] == 1)
                return i;
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(firstUniqChar("jivanivan"));
    }
}
