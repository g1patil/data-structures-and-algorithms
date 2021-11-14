package dynamicprogramming.longestcommonsubsequence;

import org.junit.Test;

/**
 * Recursive impl for longest common sub sequence.
 *
 *
 * */
public class LongestCommonSequence {

    /**
     * Remember that never do p1-- or p2-- .
     * This will literally change the value of the variable for other function call as well.
     * */
    private int getLCSLength(String s1, String s2 , int p1 , int p2 ){

        if ( p1 == 0 || p2 == 0)
            return 0;

        if ( s1.charAt(p1 -1 ) == s2.charAt(p2 -1 )){
            return 1 + getLCSLength(s1,s2, p1 -1 ,p2 -1  );
        } else {
            return Math.max(getLCSLength(s1,s2, p1 -1 ,p2 ), getLCSLength(s1,s2,p1, p2 -1  ) ) ;

        }
    }

    @Test
    public void test(){
        String s1 = "ttjtttitttv";
        String s2 = "aaaaaaajivzzzzzz";
        System.out.println(this.getLCSLength(s1,s2,s1.length() , s2.length() ));
    }
}
