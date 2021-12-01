package strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther g1patil
 */
public class BoyerMooreBadChar {

    Map<Character,Integer> characterIntegerMap ;
    static final char DEFAULT = '*';

    private void buildBadChar(String pattern){
        for (int i = 0; i < pattern.length(); i++) {
            characterIntegerMap.put( pattern.charAt(i) , pattern.length() - i - 1 ) ;
        }

        characterIntegerMap.put(DEFAULT , pattern.length());
    }

    private int getShift(char c){
        if (characterIntegerMap.containsKey(c))
            return this.characterIntegerMap.get(c);
        return characterIntegerMap.get(DEFAULT);
    }

    private int match(String pattern , String inputText){
        buildBadChar(pattern);
        return -1 ;
    }

    @Test
    public void test_(){
        String pattern = "jivan";
        String inputText = "this is jack and not jivan patil";
        this.characterIntegerMap = new HashMap<>();
        System.out.println(match(pattern, inputText));
    }
}
