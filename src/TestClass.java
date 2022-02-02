import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {


    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null)
            return true;
        Map<Character,Integer> map = new HashMap();

        for(char c : magazine.toCharArray()){
            if(map.containsKey(c)){
                map.put(c , map.get(c) + 1 );
            } else map.put(c , 1);
        }

        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c) || map.get(c) == 0){
                return false;
            } else {
                map.put(c , map.get(c) -1 );
            }
        }

        return true;
    }

    @Test
    public void test_(){
        System.out.println(canConstruct("hello" , "hlo world"));
    }

}
