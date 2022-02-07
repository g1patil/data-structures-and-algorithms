package arrays.slidingwindow;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 *
 * 76. Minimum Window Substring
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MinimumWindowSubstring {

    int uniCharCount , windowLength  ;
    Map<Character,Integer> map = new HashMap<>();

    //build the frequency map
    public void freqCal(String s){

        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c , 1);
            } else map.put(c , map.get(c) + 1 );
        }

        uniCharCount = map.size();
        windowLength = s.length();
    }


    public String minWindowMy(String s, String t) {

        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }

        int min = s.length()+1;;
        int p1 = 0;

        freqCal(t);

        int  start = 0 , end = 0 , count = 0 ;

        while (end < s.length() ){

            if (map.containsKey(s.charAt(end))){
                map.put(s.charAt(end) , map.get(s.charAt(end)) - 1 );
                if (map.get(s.charAt(end)) == 0 )
                    uniCharCount--;

                while (uniCharCount == 0 ){
                    if (end - start + 1 < min){
                        min = end - start + 1 ;
                        p1 = start;
                    }

                    if (map.containsKey(s.charAt(start))){
                        if (map.get(s.charAt(start)) == 0)
                            uniCharCount++;
                        map.put(s.charAt(start) , map.get(s.charAt(start)) + 1 );
                    }
                    start++;
                }
            }
            end++;

        }

        if (min > s.length())
            return "";
        return s.substring(p1 , p1 + min);
    }

    @Test
    public void test_(){
        System.out.println( minWindowMy("ADOBECODEBANC" , "ABC"));
    }
}
