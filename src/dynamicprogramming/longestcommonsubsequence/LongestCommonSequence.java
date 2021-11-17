package dynamicprogramming.longestcommonsubsequence;

import org.junit.Test;

/**
 * Recursive impl for longest common sub sequence.
 *
 *
 * */
public class LongestCommonSequence {

    int[][] memoization;
    int[][] topDown ;

    /**
     * Remember that never do p1-- or p2-- .
     * This will literally change the value of the variable for other function call as well.
     * */
    private int getLCSLength(String s1, String s2 , int p1 , int p2 ){

        if ( p1 == 0 || p2 == 0)
            return 0;

        if ( s1.charAt(p1 -1 ) == s2.charAt(p2 - 1)){
            return 1 + getLCSLength(s1,s2, p1 -1 ,p2 -1  );
        } else {
            return Math.max(getLCSLength(s1,s2, p1 -1 ,p2 ), getLCSLength(s1,s2,p1, p2 -1  ) ) ;

        }
    }

    /**
     * This is memoization technique
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

    /**
     * This is top-down technique
     * Remember that never do p1-- or p2-- .
     * This will literally change the value of the variable for other function call as well.
     * */
    private int getLCSLengthTopDown(String s1, String s2 , int p1 , int p2 ){

        for (int i = 1; i <= p1 ; i++) {
            for (int j = 1; j <= p2; j++) {
                if ( s1.charAt(i -1) == s2.charAt(j - 1) ){
                    this.topDown[i][j] = 1 + this.topDown[ i -1 ][ j -1 ];
                } else this.topDown[i][j] = Math.max( this.topDown[ i ][ j -1 ], this.topDown[ i -1 ][ j ] );
            }
        }
        int counter = topDown[p1][p2];

        StringBuilder stringBuilder = new StringBuilder();
        while ( counter!=0){
            if (s1.charAt(p1 -1 ) == s2.charAt(p2 -1 )){
                System.out.println(s1.charAt(p1 -1 ));
                stringBuilder.append(s1.charAt(p1 -1 ));
                counter -- ;
                p1-- ;
                p2 -- ;
            } else {
                if ( topDown[p1][p2 -1] == counter){
                    counter = topDown[p1][p2 -1] ;
                    p2 --;
                } else {
                    counter = topDown[p1 - 1][p2] ;
                    p1 -- ;
                }
            }
        }

        System.out.println( stringBuilder.reverse());
        return topDown[p1][p2];
    }

    @Test
    public void test(){
        String s1 = "ttjtttitttva";
        String s2 = "aaaaaaajivzzzzzza";

        System.out.println(this.getLCSLength(s1,s2,s1.length() , s2.length() ));

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

    @Test
    public void test2(){
        String s1 = "ttttttttptttttttt";
        String s2 = "adsfpqqqqqqqq";

        System.out.println(this.getLCSLength(s1,s2,s1.length() , s2.length() ));

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

    @Test
    public void test3(){
        String s1 = "pppppppjppppipppv";
        String s2 = "jiv";

        this.topDown = new int[s1.length() + 1][ s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if ( i == 0 || j == 0 )
                    topDown[i][j] = 0 ;
                else topDown[i][j] = 0 ;
            }

        }

        System.out.println(this.getLCSLengthTopDown(s1,s2,s1.length() , s2.length() ));
    }
}
