package strings;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * */
@Platform(Site.LEETCODE)
public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        Map<Character,Integer> characterIntegerMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c  = s.charAt(i);
            if (characterIntegerMap.containsKey(c))
                return characterIntegerMap.get(c);
            else characterIntegerMap.put(c, i);
        }
        return -1;
    }

    @Test
    public void test(){

    }
}
