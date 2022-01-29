package strings;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author g1patil
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> p1Sign = new HashSet<>();
        Set<Character> p2Sign = new HashSet<>();

        p1Sign.add('*');
        p1Sign.add('/');

        p2Sign.add('+');
        p2Sign.add('-');

        for (char c : s.toCharArray()){

            if (!stack.isEmpty() && p2Sign.contains(stack.peek())){
                Character operation = stack.pop();
                Character c1 = stack.pop();
                switch (operation){
                    case '*':
                        int i = Character.getNumericValue(c1) * Character.getNumericValue(c);
                        stack.push(Integer.toString(i).charAt(0));
                        break;
                    case '/':
                         i = Character.getNumericValue(c1) / Character.getNumericValue(c);
                        stack.push(Integer.toString(i).charAt(0));
                        break;
                }
            } else if (!stack.isEmpty() && p1Sign.contains(stack.peek())){
                Character operation = stack.pop();
                Character c1 = stack.pop();
                switch (operation){
                    case '+':
                        int i = Character.getNumericValue(c1) + Character.getNumericValue(c);
                        stack.push(Integer.toString(i).charAt(0));
                        break;
                    case '-':
                        i = Character.getNumericValue(c1) - Character.getNumericValue(c);
                        stack.push(Integer.toString(i).charAt(0));
                        break;
                }
            }
            else {
                stack.push(c);
            }
        }
        return Character.getNumericValue(stack.pop());
    }

    @Test
    public void test_(){
        System.out.println(calculate("3+2*2"));
    }
}
