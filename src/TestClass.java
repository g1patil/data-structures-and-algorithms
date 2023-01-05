import model.TreeNode;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {



    // 1614. Maximum Nesting Depth of the Parentheses
    public int maxDepth(String s) {
        int result = 0;
        int p1 = 0 ;

        for(char c : s.toCharArray()){
            if(c == '('){
                p1++;
            } else if( c == ')'){
                p1--;
            }

            result = Math.max(result,p1);
        }
        return result;
    }


    @Test
    public void test(){

    }
}