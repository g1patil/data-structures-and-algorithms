package arrays.slidingwindow;

import annotation.Pattern;
import annotation.Platform;
import annotation.Site;
import annotation.Topic;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author g1patil
 * Count Occurences of Anagrams
 */
@Pattern(Topic.SLIDINGWINDOW)
@Platform(Site.GEEKFORGEEKS)
public class CountOccurrencesOfAnagrams {

    Map<Character,Integer> map = new HashMap();
    int uniCharCount = 0 ;
    int windowLength = 0 ;

    public void initMap(String _pattern){
        for (char c : _pattern.toCharArray()){
            int count =  map.getOrDefault(c , 0) + 1;
            map.put(c , count  );
        }
        uniCharCount = map.size();
        windowLength = _pattern.length();
    }

    public int countAnagrams(String string, String pattern) {
        initMap(pattern);
        int start = 0,end = 0 ;
        int result = 0 ;

        while (end < string.length()){
            char currentChar = string.charAt(end);

            if (map.containsKey(currentChar)){
                int currentCount = map.get(currentChar);
                currentCount --;

                if (currentCount == 0)
                    uniCharCount--;

                map.put(currentChar, currentCount);
            }

            if (end - start + 1 < windowLength){
                end++ ;
            } else {
                if (uniCharCount == 0){
                    result++;
                }

                if (map.containsKey(string.charAt(start))){
                    int currentCount = map.get(string.charAt(start));
                    if (currentCount == 0)
                        uniCharCount++;
                    currentCount++;

                    map.put(string.charAt(start), currentCount);
                }

                start++;
                end++;
            }

        }

        return result;

    }

    @Test
    public void test_(){
        String input = "forxxorfxdofr";
        String pattern = "for";

        System.out.println(countAnagrams(input, pattern));
    }
}
