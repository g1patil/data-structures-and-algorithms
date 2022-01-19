package strings;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author g1patil
 * 383. Ransom Note
 */
@Platform(Site.LEETCODE)
public class RansomNote {
    HashMap<Character , Integer> frequency = new HashMap();

    public void buildFrequencyMap(String magazine){
        for(char c : magazine.toCharArray()){
            if(frequency.containsKey(c)){
                frequency.put(c , frequency.get(c) + 1 );
            } else frequency.put( c , 1);
        }
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        if(magazine.length() < ransomNote .length())
            return false;

        //build the frequency map
        buildFrequencyMap(magazine);

        //validate for each char if the key exist and in the same amount
        for(char c : ransomNote.toCharArray()){
            if(!frequency.containsKey(c) || frequency.get(c) == 0){
                return false;
            } else  {
                frequency.put( c , frequency.get(c) - 1 );
            }
        }

        return true;
    }

    @Test
    public void test_(){
        System.out.println(canConstruct("aa" , "ab"));
    }

    @Test
    public void test_2(){
        System.out.println(canConstruct("aab" , "aac"));
    }

    @Test
    public void test_3(){
        System.out.println(canConstruct("a" , "b"));
    }
}
