package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author g1patil
 * 1047. Remove All Adjacent Duplicates In String
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        Stack<Character> characters = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars){
            if (!characters.isEmpty() && characters.peek().equals(c)){
                characters.pop();
            } else characters.push(c);
        }

        String a = "";

        for (char c : characters){
            a = a + c ;
        }

        return a ;
    }

    @Test
    public void test_(){
        System.out.println(removeDuplicates("abbaca"));
    }
}
