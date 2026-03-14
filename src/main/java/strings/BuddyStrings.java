package strings;

import org.junit.jupiter.api.Test;

/**
 * 859. Buddy Strings
 * */
public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        int diff = 0;
        int[] chars = new int[26];

        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); ++i)
                count[s.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        }
        for(int i = 0; i < goal.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)){
                diff++;
            }
            chars[s.charAt(i)-'a']++;
            chars[goal.charAt(i)-'a']--;
        }
        for(int i : chars){
            if(i!=0)
                return false;
        }
        return diff == 2 || diff == 0 ;
    }

    @Test
    public void test(){
        System.out.println(
                buddyStrings(
                        "abab","abab"
                )
        );
    }
}
