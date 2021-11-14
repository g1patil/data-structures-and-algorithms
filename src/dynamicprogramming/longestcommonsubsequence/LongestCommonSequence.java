package dynamicprogramming.longestcommonsubsequence;

import org.junit.Test;

/**
 * Recursive impl for longest common sub sequence.
 *
 *
 * */
public class LongestCommonSequence {

    int[][] memoization;

    /**
     * Remember that never do p1-- or p2-- .
     * This will literally change the value of the variable for other function call as well.
     * */
    private int getLCSLength(String s1, String s2 , int p1 , int p2 ){

        if ( p1 < 0 || p2 < 0)
            return 0;

        if ( s1.charAt(p1) == s2.charAt(p2 )){
            return 1 + getLCSLength(s1,s2, p1 -1 ,p2 -1  );
        } else {
            return Math.max(getLCSLength(s1,s2, p1 -1 ,p2 ), getLCSLength(s1,s2,p1, p2 -1  ) ) ;

        }
    }

    /**
     * Remember that never do p1-- or p2-- .
     * This will literally change the value of the variable for other function call as well.
     * */
    private int getLCSLengthDP(String s1, String s2 , int p1 , int p2 ){

        if ( p1 == 0 || p2 == 0)
            return 0;

        if (this.memoization[p1 ][p2] != -1)
            return this.memoization[p1][p2];

        if ( s1.charAt(p1 -1) == s2.charAt(p2 - 1)){
            memoization[p1][p2] = 1 + getLCSLengthDP(s1,s2, p1 -1 ,p2 -1  );
        } else {
             memoization[p1][p2] = Math.max(getLCSLengthDP(s1,s2, p1 -1 ,p2 ), getLCSLengthDP(s1,s2,p1, p2 -1  ) ) ;
        }

        return memoization[p1][p2];
    }

    @Test
    public void test(){
//        String s1 = "ttjtttitttva";
//        String s2 = "aaaaaaajivzzzzzza";

        String s1 = "ttttttttptttttttt";
        String s2 = "adsfpqqqqqqqq";
        System.out.println(this.getLCSLength(s1,s2,s1.length() -1 , s2.length() -1 ));

        this.memoization = new int[s1.length() + 1][ s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if ( i == 0 || j == 0 )
                    memoization[i][j] = 0 ;
                else memoization[i][j] = -1 ;
            }

        }

        System.out.println(this.getLCSLengthDP(s1,s2,s1.length() , s2.length() ));
    }
}
