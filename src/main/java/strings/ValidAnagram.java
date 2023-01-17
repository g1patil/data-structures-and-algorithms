package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author g1patil
 * 242. Valid Anagram
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ValidAnagram {

    // more generic. Can accommodate any char
    public boolean isAnagram(String s, String t) {
        //validate the length
        if(s.length() != t.length())
            return false;

        //build the frequency map for s
        HashMap<Character, Integer> frequencyMap = new HashMap();

        for(char c : s.toCharArray()){
            if(frequencyMap.containsKey(c)){
                frequencyMap.put(c ,  frequencyMap.get(c) + 1 );
            } else {
                frequencyMap.put(c , 1 );
            }
        }

        //iterate for each character of t. and compute result
        for(char c : t.toCharArray()){
            if(!frequencyMap.containsKey(c) || frequencyMap.get(c) < 1 ){
                return false;
            } else {
                frequencyMap.put(c , frequencyMap.get(c) -  1 );
            }
        }

        return true;
    }

    //specific to alpha , lowercase only
    public boolean isAnagramArray(String s, String t) {
        //validate the length
        if(s.length() != t.length())
            return false;

        //build the frequency map for s
        int[] charFrequency = new int[26];

        for(char c : s.toCharArray()){
            charFrequency[c - 'a']++;
        }

        //iterate for each character of t. and compute result
        for(char c : t.toCharArray()){
            charFrequency[c - 'a']--;
        }

        for(int frequency : charFrequency){
            if (frequency < 0)
                return false;
        }

        return true;
    }

    @Test
    public void test_(){
        System.out.println(isAnagram("jivan","vanji"));
    }

    @Test
    public void test_2(){
        System.out.println(isAnagram("jivan","van"));
    }

    @Test
    public void test_3(){
        System.out.println(isAnagram("jivan","van"));
    }

    @Test
    public void test_4(){
        System.out.println('c');
    }
}
