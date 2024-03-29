package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author https://leetcode.com/dietpepsi
 * 301. Remove Invalid Parentheses
 */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result  = new ArrayList();
        remove(s , result , 0 , 0 , new char[]{'(',')'});
        return result;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int i = last_i , stack = 0; i < s.length(); i++) {
            if(s.charAt(i) == par[0])
                stack++;
            if (s.charAt(i) == par[1])
                stack--;
            if (stack >=0)
                continue;

            for (int j = last_j; j <= i ; j++) {
                if(s.charAt(j) == par[1] && (j == last_j || s.charAt(j-1) != par[1] ) )
                    remove(s.substring(0 , j) + s.substring(j+1) , ans , i , j , par);
            }

            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(')
            remove( reversed , ans , 0,0, new char[]{')','('});
        else ans.add(reversed);
    }

    @Test
    public void test_(){
        System.out.println(removeInvalidParentheses("()())"));
    }
}
