import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {


    public int getLargest(int n){
        String str = Integer.toString(n);

        int p1 = -1,p2 = -1;
        char s = 0, t = 0;
        for (int i = 0; i < str.length() -1 && p1 == -1; i++) {
            for (int j = i+1; j < str.length() ; j++) {
                if (str.charAt(i) < str.charAt(j) && str.charAt(j) >= t){
                    p1 = i;
                    p2 = j;
                    t = str.charAt(j);

                }
            }
        }
        StringBuilder sb = new StringBuilder(str);
        if (p1 != -1){
            sb.setCharAt(p1 ,str.charAt(p2));
            sb.setCharAt(p2 ,str.charAt(p1));
        }
        return p1 == -1 ? n : Integer.parseInt(sb.toString());
    }
    @Test
    public void test_(){
        System.out.println(getLargest(993999969));
    }
}
