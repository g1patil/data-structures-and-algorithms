package arrays;

import annotation.Platform;
import annotation.Site;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 49. Group Anagrams Given an array of strings strs, group the anagrams
 * together. You can return the answer in any order. An Anagram is a word or
 * phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
@Platform(Site.LEETCODE)
public class GroupAnagrams {

    Collection<List<String>> groupAnagrams(String[] inputArray){
        Map<String,List<String>> map = new HashMap<>();
        List<String> placeHolderValue = null;

        for(String element : inputArray){
            String uniqueKey = new String(element).replaceAll("\\s", "");

            char[] charArray = uniqueKey.toCharArray();
            Arrays.sort(charArray);
            uniqueKey = String.valueOf(charArray);
            
            if(map.containsKey(uniqueKey)){
                placeHolderValue = map.get(uniqueKey);
                placeHolderValue.add(element);
                map.put(uniqueKey, placeHolderValue);
              
            } else {
                List<String> value = new ArrayList<>();
                value.add(element);
                map.put( uniqueKey, value);
            }
        }

       return map.values();

    }
    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"jivan","vanji","manoj","nojma","pooja",""}));
    }
    
}