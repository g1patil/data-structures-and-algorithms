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



    public List<String> letterCasePermutation(String s) {

        Queue<String> q = new LinkedList();
        q.add(s);

        for(int i = 0 ; i < s.length(); i ++){
            if(Character.isDigit(s.charAt(i)))
                continue;

            int size = q.size();
            for(int j  = 0 ; j < size; j ++){
                String str = q.poll();

                char[] lc = str.toCharArray();
                char[] uc = str.toCharArray();

                lc[i] = Character.toLowerCase(lc[i]);
                uc[i] = Character.toUpperCase(uc[i]);

                q.add(String.valueOf(lc));
                q.add(String.valueOf(uc));
            }

        }

        List<String> result = new ArrayList();

        while(!q.isEmpty()){
            result.add(q.poll());
        }

        return result;

    }
    @Test
    public void test_(){
        System.out.println(letterCasePermutation("h1b1"));
    }

}
