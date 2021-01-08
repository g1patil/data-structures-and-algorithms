package strings;

import org.junit.Assert;
import org.junit.Test;
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
public class GroupAnagrams {

    /**
     * Function to return the list of list of strings. Each list will be group of anagrams.
     * Combined all the lists and return list of lists
     * @param strs input strings
     * @return returns list of lists. Each list in that is group of anagram.
     * */
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> listList = new ArrayList<List<String>>();
        Map<String,List<String>> listMap = new HashMap<>();
        for (String string : strs){


            char[] characters =  string.trim().replaceAll("\\s","").toCharArray();
            Arrays.sort(characters);
            String key = String.valueOf( characters);
            if( listMap.containsKey(key) ){
                listMap.get( key ).add( string );
            } else {
                List<String> o = new ArrayList<>();
                o.add(string);
                listMap.put( key , o);
            }

        }

        listMap.keySet().forEach(key-> listList.add(listMap.get(key)));
        return listList;
    }

    @Test
    public void test(){
        List<List<String>> result = groupAnagrams(new String[]{"ab","ba"});
        Assert.assertNotNull(result);
        Assert.assertEquals(1,result.size());
    }

    @Test
    public void test2(){
        List<List<String>> result = groupAnagrams(new String[]{"ab"," ba"});
        Assert.assertNotNull(result);
        Assert.assertEquals(1,result.size());
    }

    @Test
    public void test3(){
        List<List<String>> result = groupAnagrams(new String[]{"ji van"," nav ji", "ji", " j i ", "pa"});
        Assert.assertNotNull(result);
        Assert.assertEquals(3,result.size());
    }

}
