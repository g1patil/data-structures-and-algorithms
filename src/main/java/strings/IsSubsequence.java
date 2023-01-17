package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 392. Is Subsequence
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int j = 0 ;
        for (int i = 0; i < t.length() && j < s.length(); i++) {
            if (s.charAt(j) == t.charAt(i)){
                j++;
            }
        }
        return j == s.length();
    }

    @Test
    public void test(){
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
