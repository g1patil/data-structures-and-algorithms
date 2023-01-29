package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 1790. Check if One String Swap Can Make Strings Equal
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class OneSwap {

    public boolean areAlmostEqual(String s1, String s2) {
        if(s2.length()!=s2.length())
            return false;

        if(s1.equals(s2))
            return true;
        int diff = 0;
        int[] chars = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
            chars[s1.charAt(i)-'a']++;
            chars[s2.charAt(i)-'a']--;
        }
        for(int i : chars){
            if(i!=0)
                return false;
        }
        return diff == 2 || diff == 0 ;
    }
}
