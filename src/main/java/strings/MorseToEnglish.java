package strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Morse to english
 * */
public class MorseToEnglish {

    static String[] codes = new String[]{
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    };
    static Map<String,Character> codeMap = new HashMap<>();

    static {
        for (int i = 0; i < codes.length; i++) {
            codeMap.put(codes[i], (char) ('a' + i));
        }
    }
    public String getTextForMorse(String[] input){
        StringBuilder sb = new StringBuilder();
        for (String s : input){
            sb.append(codeMap.get(s));
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(
                getTextForMorse(
                        new String[]{
                                ".-","-...","-.-.","-..",".","..-.","--."
                        }
                )
        );
    }
}
