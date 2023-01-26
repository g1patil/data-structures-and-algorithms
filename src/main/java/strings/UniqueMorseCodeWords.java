package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 804. Unique Morse Code Words
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class UniqueMorseCodeWords {

    Map<Character,String> codesMap = new HashMap<>();

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> unique = new HashSet<>();

        for(String w : words){
            StringBuilder sb = new StringBuilder();
            for(Character c : w.toCharArray()){
                sb.append( codesMap.get(c) );
            }
            unique.add(sb.toString());
        }
        return unique.size();
    }

    public void buildCodes(){
        String[] codes = new String[]{
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };

        for(int i = 0; i < 26; i++) {
            codesMap.put((char) ('a' + i), codes[i]);
        }
    }

    @Test
    public void test(){
        buildCodes();
        System.out.println(
                uniqueMorseRepresentations(
                        new String[]{
                                "gin","zen","gig","msg"
                        }
                )
        );
    }
}
