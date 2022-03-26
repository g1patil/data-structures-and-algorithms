package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * 1614. Maximum Nesting Depth of the Parentheses
 *
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MaximumNestingDepthoftheParentheses {

    public int maxDepth(String s) {
        int result = 0 ;
        int count = 0 ;

        for(char c : s.toCharArray()){
            if(c == '(' ){
                count++;
            } else if( c == ')' ) {
                if(count >0)
                    count--;
            }
            result = Math.max(result , count);
        }
        return result;
    }
}
