package strings;

import org.junit.Test;

/**
 * @auther g1patil
 *
 * Longest suffix , which is also suffix. Overlapping is allowed.
 */
public class TestString {

    private int solve(String s, int p2Bound){
        if (p2Bound == 1 && s.length() > 0 )
            return 1 ;

        int p1 = 0 , p2 = 1 ;
        int length = 0 ;

        for ( p2 = 1 ; p2 < p2Bound ; p2 ++){
            if (s.charAt(p1) == s.charAt(p2)){
                p1 ++ ;
                length ++ ;
            } else {
                p1 = 0 ;
                length = 0 ;
            }
        }
        return length;
    }
    @Test
    public void test_(){
        String pattern = "aabcdaabc";
        System.out.println(solve(pattern , pattern.length() ));
    }
}
