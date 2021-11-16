package dynamicprogramming.longestcommonsubsequence;

import org.junit.Test;

public class LongestCommonString {

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

    @Test
    public void test(){
        String s1 = "jivan";
        String s2 = "jizzzan";

        System.out.println(this.getLCSLength(s1,s2,s1.length() , s2.length() , 0 ));

    }
}
