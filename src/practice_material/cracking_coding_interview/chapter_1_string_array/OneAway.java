package practice_material.cracking_coding_interview.chapter_1_string_array;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author g1patil
 *
 * Check if strings are one char edit away from being equal
 * CCI 1.6
 *
 * The solution is same as the given in the book. Run the two pointers.
 * If there is match, increase both pointer.
 * If there is mismatch , increase the pointer for bigger one only.
 *
 * if size is equal , increase the pointer for both smaller and bigger one.
 */
public class OneAway {

    private boolean oneEditAway(String first, String second){
        int lengthDiff = first.length() - second.length();
        if ( Math.abs(lengthDiff) > 1  ){
            return false;
        }

        String s1 = first , s2 = second ;
        int p1  = 0 , p2 = 0 ;
        if ( first.length() > second.length()){
            s1 = second;
            s2 = first;
        }

        boolean foundUnique = false;

        while ( p1 < s1.length() && p2 < s2.length()){

            if ( s1.charAt(p1) != s2.charAt(p2)){
                if (foundUnique)
                    return false;
                foundUnique = true ;
                p2 ++ ;
                if (s1.length() == s2.length())
                    p1++ ;
            } else {
                p1 ++;
                p2 ++ ;
            }
        }

        return true;
    }
    @Test
    public void test_(){
        System.out.println(oneEditAway("pale","ple"));
        System.out.println(oneEditAway("pales","pale"));
        System.out.println(oneEditAway("pale","bale"));
        System.out.println(oneEditAway("pale","bae"));
        System.out.println(oneEditAway("aakaaa","aaaaak"));
        System.out.println(oneEditAway("aakaaa","aaaaak"));
    }
}
