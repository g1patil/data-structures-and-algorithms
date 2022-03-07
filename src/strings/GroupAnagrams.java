package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

/*
 * 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class GroupAnagrams {

    /**
     * Function to return the list of strings. Each list will be group of anagrams.
     * Combined all the lists and return list of lists
     * @param strs input strings
     * @return returns list of lists. Each list in that is group of anagram.
     * */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> listMap = new HashMap<>();
        for (String string : strs){
            int[] freq = new int[26];

            for(char c : string.toCharArray()){
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i : freq){
                sb.append("#");
                sb.append(i);
            }
            String key = sb.toString();

            if (listMap.containsKey(key)){
                listMap.get(key).add(string);
            }else {
                List<String> list = new ArrayList<>();
                list.add(string);
                listMap.put(key , list);
            }
        }

        return new ArrayList(listMap.values());
    }

    @Test
    public void test(){
        List<List<String>> result = groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
        System.out.println(result);
    }

    @Test
    public void test2(){
        List<List<String>> result = groupAnagrams(new String[]{"ab"," ba"});
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1,result.size());
    }

    @Test
    public void test3(){
        List<List<String>> result = groupAnagrams(new String[]{"ji van"," nav ji", "ji", " j i ", "pa"});
        Assertions.assertNotNull(result);
        Assertions.assertEquals(3,result.size());
    }

}
