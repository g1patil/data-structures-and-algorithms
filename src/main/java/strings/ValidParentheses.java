package strings;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author g1patil
 * 20. Valid Parentheses
 */
@Platform(Site.LEETCODE)
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.isBlank())
            return true;
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == '('){
                stack.push(')');
                continue;
            } else if (s.charAt(i) == '{'){
                stack.push('}');
                continue;
            } else if (s.charAt(i) == '['){
                stack.push(']');
                continue;
            }

            if ( !stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();
                continue;
            }
            return false;

        }
        return stack.isEmpty();
    }

    @Test
    public void test_(){
        System.out.println(isValid("{()[]}}"));
    }
}
