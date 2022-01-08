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

    public int minAddToMakeValid(String s) {
        if (s == null || s.isBlank())
            return 0;

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
        return list.size();

    }
}
