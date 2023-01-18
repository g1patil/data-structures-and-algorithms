import model.TreeNode;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    //66. Plus One
    public int[] plusOne(int[] digits) {
        int carry = 1 , index = digits.length - 1;
        int[] result = digits;

        while ( carry != 0 && index >= 0){
            int sum =  (digits[index] + carry);
            digits[index] = sum % 10;
            carry = sum / 10;
            index--;
        }

        if (carry == 1){
            result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 0; i < digits.length ; i++) {
                result[i + 1] = digits[i];
            }
        }
        return result;
    }


    @Test
    public void test(){
        ArrayUtility.print(
                plusOne(
                        new int[]{9,9,9,9}
                )
        );
    }

}
