package dynamicprogramming.longestcommonsubsequence;

import org.junit.Test;

public class LongestCommonString {

    int[][] topDown ;

    private int getLCSLength(String s1, String s2 , int p1 , int p2 , int count){

        if ( p1 == 0 || p2 == 0)
            return count;

        if ( s1.charAt(p1 -1 ) == s2.charAt(p2 - 1)){
            count =  getLCSLength(s1,s2, p1 -1 ,p2 -1  , 1 + count);
        } else {
            count = Math.max( count , Math.max(
                    getLCSLength(s1,s2, p1 -1 ,p2 , 0 ),
                    getLCSLength(s1,s2,p1, p2 -1 , 0 )
            ));

        }

        return count ;
    }

    private int getLCSLengthTopDown(String s1, String s2 , int p1 , int p2 ){
        int result = 0 ;
        for (int i = 1; i <= p1 ; i++) {
            for (int j = 1; j <= p2; j++) {
                if ( s1.charAt(i -1) == s2.charAt(j - 1) ){
                    this.topDown[i][j] = 1 + this.topDown[ i -1 ][ j -1 ];
                    result = Math.max( result , this.topDown[i][j] );
                } else this.topDown[i][j] = 0 ;
            }
        }

        return topDown[p1][p2];
    }

    @Test
    public void test(){
        String s1 = "jivan";
        String s2 = "jizzzan";

        System.out.println(this.getLCSLength(s1,s2,s1.length() , s2.length() , 0 ));

    }
    @Test
    public void test3(){
        String s1 = "pzzzzzppppppjippppatilppp";
        String s2 = "aaajiaapatilaazzzzzza";

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
