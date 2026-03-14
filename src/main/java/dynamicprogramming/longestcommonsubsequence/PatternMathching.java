package dynamicprogramming.longestcommonsubsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PatternMathching {
    int[][] topDown ;
    String subSequence ;

    private String getLCSLengthTopDown(String s1, String s2 , int p1 , int p2 ){

        for (int i = 1; i <= p1 ; i++) {
            for (int j = 1; j <= p2; j++) {
                if ( s1.charAt(i -1) == s2.charAt(j - 1)){
                    this.topDown[i][j] = 1 + this.topDown[ i -1 ][ j -1 ];
                } else this.topDown[i][j] = Math.max( this.topDown[ i ][ j -1 ], this.topDown[ i -1 ][ j ] );
            }
        }
        int counter = topDown[p1][p2];

        StringBuilder stringBuilder = new StringBuilder();
        while ( counter!=0){
            if (s1.charAt(p1 -1 ) == s2.charAt(p2 -1 )){
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

        subSequence =  stringBuilder.reverse() .toString();
        return subSequence;
    }

    @Test
    public void test(){
        String s1 = "XYZ";
        String s2 = "XRUYACZ";
        this.topDown = new int[s1.length() + 1 ][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s1.length(); j++) {
                if ( i == 0 || j == 0 )
                    topDown[i][j] = 0 ;
                else topDown[i][j] = 0 ;
            }

        }

        Assertions.assertEquals( this.getLCSLengthTopDown( s1 , s1 , s1.length() , s1.length()).length() ,
                Math.min( s1.length() , s2.length())
                );
    }
}
