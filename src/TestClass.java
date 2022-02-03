import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {



    public int compress(char[] chars) {
        int index = 0 ;

        for(int i = 0 , j = 0 ; i < chars.length ; ){

            char current = chars[i];
            int count = 0 ;

            while( i < chars.length && chars[i] == current){
                count++;
                i++;
            }
            chars[j] = current;
            j++;

            if (count > 1){
                for(char c : String.valueOf(count).toCharArray()){
                    chars[j] = c ;
                    j++;
                }
            }
            index = j ;
        }

        return index  ;
    }

    @Test
    public void test_(){
        System.out.println(compress(
                new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}
        ));
    }

}
