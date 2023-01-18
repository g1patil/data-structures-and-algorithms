import model.TreeNode;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    //125. Valid Palindrome
    public boolean isPalindrome(String s) {
        for (int i = 0 , j = s.length() - 1 ; i < j ; i++ , j --) {
            while ( !Character.isLetterOrDigit(s.charAt(i)) && i < j )
                i++;
            while ( !Character.isLetterOrDigit(s.charAt(j)) && i < j )
                j--;

            if (
                    Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))
            ){
                return false;
            }
        }
        return true;
    }


    @Test
    public void test(){
        System.out.println(
                isPalindrome("0P")
        );
    }

}
