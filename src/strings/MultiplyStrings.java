package strings;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int result = 0 ;
        int finalResult = 0 ;
        int finalMul = 1 ;

        String bigger  = num1.compareTo(num2) > 0 ? num1 : num2 ;
        String smaller = bigger.equals(num1) ? num2 : num1 ;

        int i = smaller.length() -1 ;
        while ( i >= 0){
            int mul = 1 ;
            result = 0 ;
            int carry  = 0 ;
            int j = bigger.length() - 1 ;
            int currentDigit  = Character.getNumericValue(smaller.charAt(i));

            while ( j >=0){
                int digit = Character.getNumericValue(bigger.charAt(j)) ;
                int d = (currentDigit*digit + carry)%10;
                carry= (currentDigit*digit + carry)/10;

                result+= mul * d ;

                mul*=10;
                j--;
            }
            if (carry!=0)
                result= mul + result ;

            finalResult = finalMul*result + finalResult;
            finalMul*=10;
            i--;
        }

        return null;
    }

    @Test
    public void test_(){
        Math.random();
        System.out.println(multiply("456","123"));
    }
}
