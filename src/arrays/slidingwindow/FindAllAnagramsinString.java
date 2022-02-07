package arrays.slidingwindow;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author g1patil
 * 438. Find All Anagrams in a String
 *
 * Sliding window
 *  Frequency map with number of unique charactes
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FindAllAnagramsinString {

    int uniCharCount , windowLength  ;
    Map<Character,Integer> map = new HashMap<>();

    public void freqCal(String s){

        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c , 1);
            } else map.put(c , map.get(c) + 1 );
        }

        uniCharCount = map.size();
        windowLength = s.length();
    }

    public List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> result = new ArrayList();
        freqCal(s2);

        if(s1 == null || s2 == null)
            return result;

        int start = 0 , end = 0 ;

        while(end < s1.length()){
            char c = s1.charAt(end);

            //calculations phase
            if(map.containsKey(c)){
                int count = map.get(c);
                count--;

                if(count == 0)
                    uniCharCount--;

                map.put(c, count);
            }

            //window is smaller than increase window length
            if(end - start + 1 < windowLength){
                end++;
            } else {

                //calculate the result
                if(uniCharCount == 0)
                    result.add(start);

                //reverse the result
                if(map.containsKey(s1.charAt(start))){
                    int count = map.get(s1.charAt(start));

                    if(count == 0)
                        uniCharCount++;
                    count++;
                    map.put(s1.charAt(start) , count);

                }

                //increase flags
                start++;
                end++;
            }
        }

        return result;
    }
}
