package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;


/**
 * @author jivanpatil
 * 1249. Minimum Remove to Make Valid Parentheses
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MinimumRemove2MakeValidParentheses {

    LinkedList<Brace> list = new LinkedList<>();
    Set<Character> characterSet = new HashSet<>();

    {
        characterSet.add('(');
        characterSet.add(')');
    }

    class Brace {
        char brace;
        int index;

        Brace(char _b , int _i){ brace = _b ;index = _i;}
    }

    public String minRemoveToMakeValid(String s) {
        if (s == null || s.isBlank())
            return s;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];

            if (characterSet.contains(current)){
                if (current == '('){
                    list.push(new Brace(')' , i) );
                } else if ( !list.isEmpty() && list.peek().brace == current){
                    list.pop();
                } else {
                    list.push(new Brace('(' , i));
                }
            }

        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (list.isEmpty() || (!list.isEmpty() && list.peekLast().index != i)){
                stringBuilder.append(chars[i]);
            } else {
                list.removeLast();
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test(){
//        System.out.println(minRemoveToMakeValid("())()((("));
//        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
    }
}
