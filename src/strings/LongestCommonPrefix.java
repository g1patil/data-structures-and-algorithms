package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.LinkedList;

/**
 * @author g1patil
 * 14. Longest Common Prefix
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int index = 0 ;
        LinkedList<Character> stack = new LinkedList<>();
        boolean con = true;

        /* outer loop is based on the first string. */
        for (int i = 0; i < strs[0].length() && con; i++) {

            /* add the first char to the list */
            stack.addLast(strs[0].charAt(index));

            /* inner loop starts from 1 to rest of the strings.*/
            for (int j = 1; j < strs.length && con; j++) {

                /* if the index crossed the current string or
                * current char of the current string does not match last char
                * */
                if (index >= strs[j].length() || stack.getLast()!=strs[j].charAt(index)){
                    stack.removeLast();
                    con = false;
                }

            }
            index++;
        }
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    @Test
    public void test_(){
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    @Test
    public void test_2(){
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));
    }
}
