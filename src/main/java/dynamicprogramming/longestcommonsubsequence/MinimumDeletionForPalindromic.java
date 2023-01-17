package dynamicprogramming.longestcommonsubsequence;

import org.junit.jupiter.api.Test;

/**
 * Minimum number of the deletion to make the string palindromic.
 * This is same as minimum number of the deletion to making the string palindromic
 * Minimum deletion will be , actual length of the string - longest palindromic subsequence
 * */
public class MinimumDeletionForPalindromic {
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
        String s1 = "agbcba";
        //s2 will be the palindrom of the original string
        String s2 = new StringBuilder(s1).reverse().toString();

        this.memoization = new int[s1.length() + 1][ s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if ( i == 0 || j == 0 )
                    memoization[i][j] = 0 ;
                else memoization[i][j] = -1 ;
            }

        }

        System.out.println(s1.length() - this.getLCSLengthDP(s1,s2,s1.length() , s2.length() ));
    }
}
