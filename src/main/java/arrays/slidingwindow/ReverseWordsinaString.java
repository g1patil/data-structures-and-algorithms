package arrays.slidingwindow;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 186. Reverse Words in a String II
 */
@Platform(Site.LEETCODE)
public class ReverseWordsinaString {

    public void reverseWord(char[] chars , int low , int high){
        while (low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;

            low++;
            high--;
        }
    }

    public void reverseWords(char[] s) {
        reverseWord(s, 0 , s.length - 1 );
        int p1 = 0 , p2 = 0 , length = s.length ;
        while (p2 < length){
            while ( p2 < length && s[p2] != ' ')
                p2++;
            reverseWord(s , p1 , p2 - 1);
            p1 = p2+1;
            p2++;
        }
    }

    @Test
    public void test_(){
        reverseWords(new char[]{'j','i','v','a','n',' ','w','o','n'});
    }
}
