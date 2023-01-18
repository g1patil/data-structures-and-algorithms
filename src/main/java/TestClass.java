import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    // 344. Reverse String
    public void reverseString(char[] s) {
        int p1 = 0 , p2 = s.length - 1;
        while( p1 <= p2){
            replace(s,p1,p2);
            p1++;
            p2--;
        }
    }

    private void replace(char[] chars, int s , int d){
        char temp = chars[s];
        chars[s] = chars[d];
        chars[d] = temp;
    }

    @Test
    public void test(){
        char[] a =  new char[]{'j','i','v','a','n'};
        reverseString(a);
        ArrayUtility.print(a);
    }

    @Test
    public void test2(){
        char[] a =  new char[]{'j'};
        reverseString(a);
        ArrayUtility.print(a);
    }
}
