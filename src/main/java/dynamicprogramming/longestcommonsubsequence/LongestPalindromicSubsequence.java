package dynamicprogramming.longestcommonsubsequence;

import org.junit.jupiter.api.Test;

public class LongestPalindromicSubsequence {
    int[][] memoization;


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
    public void test2(){
        String s1 = "abc";
        //s2 will be the palindrome of the original string
        String s2 = new StringBuilder(s1).reverse().toString();

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
