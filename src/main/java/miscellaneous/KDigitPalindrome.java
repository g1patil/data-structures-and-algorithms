package miscellaneous;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class KDigitPalindrome {

    public void printKDigitPalindrome(int k){

        double lowerBound = Math.pow(10 , k/2 - 1);
        double upperBound = Math.pow(10 , k/2 ) - 1 ;

        for (double i = lowerBound ; i <= upperBound ; i ++){
            double reverse = reverseNumber(i);
            double palindrome = i * Math.pow(10 , k/2) + reverse;
            System.out.println((int) palindrome);

            //generate for all the middle digits
        }
    }

    public double reverseNumber(double number){
        double result = 0 ;

        while (number >= 1){
            double digit = number % 10;
            number = number/10;
            result = result*10 + digit;
        }

        return result;
    }

    @Test
    public void test_(){
        printKDigitPalindrome(5);
    }
}
