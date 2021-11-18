package dynamicprogramming.longestcommonsubsequence;

import org.junit.Test;

public class LongestRepeatingSequence {

    int[][] topDown ;
    String subSequence ;

    private int getLCSLengthTopDown(String s1, String s2 , int p1 , int p2 ){

        for (int i = 1; i <= p1 ; i++) {
            for (int j = 1; j <= p2; j++) {
                if ( s1.charAt(i -1) == s2.charAt(j - 1)  && i != j ){
                    this.topDown[i][j] = 1 + this.topDown[ i -1 ][ j -1 ];
                } else this.topDown[i][j] = Math.max( this.topDown[ i ][ j -1 ], this.topDown[ i -1 ][ j ] );
            }
        }
        int i = p1 , j = p1 ;

        StringBuilder stringBuilder = new StringBuilder();
        while (  i > 0 && j > 0){
            if ( topDown[i][j] == (topDown[i-1][j-1] + 1) ){
                stringBuilder.append(s1.charAt(i -1 ));
                i-- ;
                j-- ;
            } else if ( topDown[i][j] == topDown[i-1][j])
                    i-- ;
            else j--;
            }

        subSequence =  stringBuilder.reverse() .toString();
        return topDown[p1][p2];
    }

    @Test
    public void test(){
        String s1 = "AABEBCDD";
        this.topDown = new int[s1.length() + 1 ][s1.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s1.length(); j++) {
                if ( i == 0 || j == 0 )
                    topDown[i][j] = 0 ;
                else topDown[i][j] = 0 ;
            }

        }

        this.getLCSLengthTopDown( s1 , s1 , s1.length() , s1.length());
    }
}
