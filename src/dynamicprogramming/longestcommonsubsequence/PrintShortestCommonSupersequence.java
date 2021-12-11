package dynamicprogramming.longestcommonsubsequence;

import org.junit.jupiter.api.Test;

public class PrintShortestCommonSupersequence {

    int[][] topDown ;
    String subSequence ;

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
        return topDown[p1][p2];
    }

    @Test
    public void test3(){
        String s1 = "acbcf";
        String s2 = "abcdaf";

        this.topDown = new int[s1.length() + 1][ s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if ( i == 0 || j == 0 )
                    topDown[i][j] = 0 ;
                else topDown[i][j] = 0 ;
            }

        }

        this.getLCSLengthTopDown(s1,s2,s1.length() , s2.length() );
        System.out.println(subSequence);

        int p1=0,p2=0,p3=0;

        while (p3 < subSequence.length()){
            while (s1.charAt(p1) != subSequence.charAt(p3)){
                System.out.print(s1.charAt(p1));
                p1++ ;
            }
            while (s2.charAt(p2) != subSequence.charAt(p3)){
                System.out.print(s2.charAt(p2));
                p2++ ;
            }

            System.out.print(subSequence.charAt(p3));

            while (p1 < s1.length() && s1.charAt(p1) == subSequence.charAt(p3)){
                p1++ ;
            }
            while (p2 < s2.length() && s2.charAt(p2) == subSequence.charAt(p3)){
                p2++ ;
            }
            p3++;
        }
    }
}
