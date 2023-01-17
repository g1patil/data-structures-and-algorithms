import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 */
public class CheatSheet {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s == "")
            return 0 ;

        int result = 0 , len = s.length();
        Map<Character , Integer> map = new HashMap();

        for(int j = 0 , i = 0 ; j < len ; j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                i = Math.max(i , map.get(c));
            }
            result = Math.max(result , j - i + 1);
            map.put(c , j + 1);
        }

        return result;
    }
}
