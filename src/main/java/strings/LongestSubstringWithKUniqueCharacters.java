package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author g1patil
 * 340. Longest Substring with At Most K Distinct Characters
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LongestSubstringWithKUniqueCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> frequencyMap = new HashMap();
        int slowPointer = 0 , fastPointer = 0  , maxLength = 0 ;
        int length = s.length();

        while(fastPointer < length){

            //build the frequency map
            calculateFrequency(frequencyMap , s, fastPointer);

            //calculate the answer
            if (frequencyMap.size() <= k)
                maxLength = Math.max(maxLength , fastPointer - slowPointer + 1 );

            //reduce the frequency
            if(frequencyMap.size() > k){

                while(frequencyMap.size() > k){
                    int f = frequencyMap.get(s.charAt(slowPointer));

                    if(f == 1){
                        frequencyMap.remove(s.charAt(slowPointer));

                    }
                    else {
                        frequencyMap.put( s.charAt(slowPointer) , f - 1 );
                    }
                    slowPointer++;

                }

            }

            fastPointer++;

        }

        return maxLength;
    }

    private void calculateFrequency(HashMap<Character, Integer> map , String s , int fastPointer) {
        if(map.containsKey(s.charAt(fastPointer))){
            map.put( s.charAt(fastPointer) , map.get(s.charAt(fastPointer)) + 1 );
        } else {
            map.put( s.charAt(fastPointer) , 1 );
        }
    }

    @Test
    public void test_(){
        System.out.println(lengthOfLongestSubstringKDistinct("aaaaabbbbbccccccccdef" , 3 ));
    }

    @Test
    public void test_2(){
        System.out.println(lengthOfLongestSubstringKDistinct("a" , 2 ));
    }
}
