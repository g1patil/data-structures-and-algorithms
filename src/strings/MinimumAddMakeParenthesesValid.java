package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 921. Minimum Add to Make Parentheses Valid
 * @author jivanpatil
 *
 * Minimum paratehnsis remove to make it valid is same as minimum to add.
 * */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class MinimumAddMakeParenthesesValid {


    public int minAddToMakeValid(String s) {
        int result = 0 , currentCount = 0;

        for(char c : s.toCharArray()){
            if( c == '('){
                currentCount++;
            } else if ( c == ')'){
                if(currentCount > 0 ){
                    currentCount--;
                } else {
                    result++;
                }
            }
        }

        return result + currentCount;
    }
}
