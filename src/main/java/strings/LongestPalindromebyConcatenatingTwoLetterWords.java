package strings;

import annotation.Platform;
import annotation.Site;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author g1patil
 */
@Platform(Site.LEETCODE)
public class LongestPalindromebyConcatenatingTwoLetterWords {

    public int longestPalindrome(String[] strs) {
        Map<String, List<String>> listMap = new HashMap<>();
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

        StringBuilder sb = new StringBuilder();
        listMap.keySet().stream().forEach( k->{
            List<String> list = listMap.get(k);

            if (list.size() == 2){

            }
        });

        return -1;

    }
}
