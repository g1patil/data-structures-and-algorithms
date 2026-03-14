package strings;
import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;
import java.util.Stack;

/**
 * 844. Backspace String Compare
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        String sNew = buildString(s) , tNew = buildString(t);
        return sNew.equals(tNew);
    }

    private String buildString(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '#' && !stack.isEmpty()){
                stack.pop();
            } else if(c == '#'){

            } else stack.push(c);
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(
                backspaceCompare("a##c","#a#c")
        );
    }
}
