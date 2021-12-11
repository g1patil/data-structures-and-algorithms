package strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 */
public class BoyerMooreBadChar {

    Map<Character,Integer> characterIntegerMap ;
    static final char DEFAULT = '*';

    /**
     * Builds the bad character shift table. Used Map for faster performance.
     * */
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

    public void match(String pattern , String inputText){
        buildBadChar(pattern);

        int p1 = pattern.length() -1 ;
        int p2 = p1 ;
        int matchLength = 0 ;

        while ( p1 < inputText.length() && p2 < inputText.length()){
            if ( inputText.charAt(p1) == pattern.charAt(p2)){
                p1 -- ;
                p2 -- ;
                matchLength ++ ;
            } else {
                p1+= getShift( inputText.charAt(p1));
                p2 = pattern.length() -1 ;
                matchLength = 0 ;
            }

            if ( matchLength == pattern.length()){
                System.out.println("match found at index : " + (p1+ 1 ) );
                p2 = pattern.length() -1 ;
                matchLength = 0 ;
                p1+= 2*pattern.length();
            }
        }
    }

    @Test
    public void test_(){
        String pattern = "jivan";
        String inputText = "this is jack and not jivan patil , and this is van and jivan";
        this.characterIntegerMap = new HashMap<>();
        match(pattern, inputText);
    }

    @Test
    public void test_2(){
        String pattern = "nanan";
        String inputText = "jinanananpatil";
        this.characterIntegerMap = new HashMap<>();
        match(pattern, inputText);
    }

    public static void main(String[] args) {

    }
}
