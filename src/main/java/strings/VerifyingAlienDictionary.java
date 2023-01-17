package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 * Verifying an Alien Dictionary
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class VerifyingAlienDictionary {

    Map<Character , Integer> orderMap ;

    public void init(String orderString){
        orderMap = new HashMap<>();
        {
            int _order = 0 ;
            for (char c : orderString.toCharArray()){
                orderMap.put(c , _order);
                _order++;
            }
        }
    }

    public boolean isAlienSorted(String[] words, String order) {
        init(order);
        for (int i = 0; i < words.length - 1 ; i++) {
            if (!areWordOrdered(words[i],words[i+1]))
                return false;
        }
        return true;
    }

    boolean areWordOrdered(String _first , String _second){
        int l1 = _first.length(), l2 = _second.length();
        for (int i = 0 , j = 0 ; i < _first.length() && j < _second.length() ; i ++ , j ++){
            if (_first.charAt(i) != _second.charAt(j)){
                if((orderMap.get(_first.charAt(i)) > orderMap.get( _second.charAt(j)))){
                    return false;
                } else return true;
            }
        }
        if (l1 > l2) return false;
        return true;
    }

    @Test
    public void test_(){
        String[] strings = new String[]{
                "word","world","row"
        };
        System.out.println(isAlienSorted(strings,"worldabcefghijkmnpqstuvxyz"));
    }
}
