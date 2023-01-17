package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author g1patil
 * 3. Longest Substring Without Repeating Characters
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        s.replaceAll("\\s" , "");

        if (s == "" || s.length() == 1)
            return 1;
        HashMap<Character , Integer> integerHashMap = new HashMap<>();
        int POINTER = 0 , currentLength = 0 , answer = 0 , LENGTH = s.length() ;

        while (POINTER < LENGTH){

            if (!integerHashMap.containsKey(s.charAt(POINTER))){
                integerHashMap.put(s.charAt(POINTER) , POINTER);
                currentLength++;
                POINTER++ ;
            } else {
                answer = Math.max(currentLength , answer);
                POINTER = integerHashMap.get(s.charAt(POINTER)) + 1 ;
                currentLength = 0 ;
                integerHashMap.clear();
            }

        }

        answer = Math.max(currentLength , answer);
        return answer;
    }

    public int lengthOfLongestSubstringOptimal(String s) {
        s.replaceAll("\\s" , "");

        if (s == "" || s.length() == 1)
            return 1;
        HashMap<Character , Integer> map = new HashMap<>();
        int slow = 0 , fast = 0 , ans = 0 , LENGTH = s.length() ;

        for (int j = 0, i = 0; j < LENGTH; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    @Test
    public void test_(){
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
