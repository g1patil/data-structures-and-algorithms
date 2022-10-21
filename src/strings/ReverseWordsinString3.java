package strings;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * */
@Platform(Site.LEETCODE)
public class ReverseWordsinString3 {

    public String reverseWords(String s) {
        StringBuilder sbn  = new StringBuilder();

        int start = 0;

        for (int i = start; i < s.length(); ) {
            int end = getNextWhileSpaceIndex(s,start);
            int last = end - 1;
            while ( last >= i ){
                sbn.append(s.charAt(last));
                last -- ;
            }
            if (end< s.length())
                sbn.append(' ');
            i = end + 1 ;
            start = end + 1 ;

        }
        return sbn.toString();
    }

    private int getNextWhileSpaceIndex(String input , int start){
        int result = input.length() - 1 ;
        for (int i = start; i < input.length(); i++) {
            if (input.charAt(i) == ' '){
                return i;
            }
        }

        return result + 1;
    }

    @Test
    public void test(){
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("jivan"));
    }
}
