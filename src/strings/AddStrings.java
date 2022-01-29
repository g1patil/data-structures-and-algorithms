package strings;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

/*
 * 415. Add Strings
 *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*
 * */
@Platform(Site.LEETCODE)
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int resultSize = Math.max(num1.length() , num2.length()) ;
        char[] result = new char[resultSize];
        int carry = 0 ;

        int p1 = num1.length() - 1;
        int p2= num2.length() - 1;

        for(int i = result.length -1 ; i >=0 ; i --){

            if(p1>=0 && p2 >=0){
                int sum = carry + Character.getNumericValue(num1.charAt(p1)) +
                        Character.getNumericValue(num2.charAt(p2)) ;
                int d = sum % 10 ;
                carry = sum / 10 ;

                result[i] = Integer.toString(d).charAt(0);

                p1--;
                p2--;
            } else if (p1>=0){
                int sum = carry + Character.getNumericValue(num1.charAt(p1));

                int d = sum % 10 ;
                carry = sum / 10 ;

                result[i] = Integer.toString(d).charAt(0);
                p1--;
            } else if (p2>=0){
                int sum = carry + Character.getNumericValue(num2.charAt(p2));

                int d = sum % 10 ;
                carry = sum / 10 ;

                result[i] = Integer.toString(d).charAt(0);
                p2--;
            }
        }
        String sum = "" ;
        if (carry > 0){
            sum =  Integer.toString(carry) + String.valueOf(result);
        } else sum = String.valueOf(result);

        return sum;
    }

    public String addStringsOptimal(String num1, String num2) {

        StringBuilder bs = new StringBuilder();
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int carry = 0 ;

        while (p1 >=0 || p2 >=0){
            int x1 = p1 >=0 ? num1.charAt(p1) - '0' : 0 ;
            int x2 = p2 >=0 ? num2.charAt(p2) - '0' : 0 ;

            int d = (x1 + x2 + carry) % 10 ;
            carry = (x1 + x2 + carry) / 10 ;

            bs.append(d);
            p1--;
            p2--;
        }

        if (carry!=0)
            bs.append(carry);

        return bs.reverse().toString();
    }

    @Test
    public void test_(){
        System.out.println(addStringsOptimal("12","1000"));
    }
}
