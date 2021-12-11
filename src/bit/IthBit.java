package bit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.logging.Logger;

/**
 * @author g1patil
 */
public class IthBit {

    private int getIthBit(int number, int i){
        int mask = 1 << i ;
        if ((mask & number) != 0)
            return 1 ;
        return 0 ;
    }

    private int numberOfDiffBit(int n1, int n2){
        System.out.println(Integer.toBinaryString(n1));
        System.out.println(Integer.toBinaryString(n2));

        n1 = n1 ^ n2 ;
        System.out.println(Integer.toBinaryString(n1));

        int count = 0 ;

        while ( n1 != 0){
            n1 = n1 & ( n1 - 1 );
            count++;
        }
        System.out.println(count);
        return - 1 ;
    }

    private void clearIthBit(int number, int i ){
        int mask = (~0) ;
        int num =  1 << (i - 1 ) ;
        num = num ^ mask ;

        System.out.println(Integer.toBinaryString(number));
        num = ( number & num );
        System.out.println(Integer.toBinaryString(num ));
    }

    private void swapTwoNums(int a , int b){
        System.out.println("a : " + a);
        System.out.println("b : " + b);

        a = a ^ b ;
        b = a ^ b ;
        a = a ^ b ;

        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }

    @Test
    @DisplayName("get the ith bit of the number")
    public void test_(){
        Assert.assertEquals(1 , getIthBit(6 , 0));
    }

    @Test
    @DisplayName("Swap two num without using the extra space")
    public void test2(){
        swapTwoNums(5 , 9 );
    }

    @Test
    public void test3(){
        clearIthBit(345 , 5 );
    }

    @Test
    public void test4(){
        numberOfDiffBit(345 , 365 );
    }
}
