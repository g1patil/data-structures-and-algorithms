package dynamicprogramming;

import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

/**
 * @author g1patil
 */
public class FibonacciNumber {

    //iterative , make sure to use this or stack will be full
    public int fib(int n) {
        if( n ==0)
            return 0;
        if(n == 1)
            return 1;

        int[] fibo = new int[n + 1];
        fibo[0] = 0 ; fibo[1] = 1 ;

        for(int i = 2 ; i <= n ; i ++){
            fibo[i] = fibo[i-1] + fibo[i - 2];
        }
        return fibo[n];
    }

    public void largeFix(int n ){
        int[] result = new int[500];
        result[0] = 1;
        int size = 1 ;

        for (int i = 2; i <= n ; i++) {
            size = multiply(i , result , size);
        }
        ArrayUtility.print(result);
    }

    public int multiply(int n , int[] result , int size){
        int carry = 0 , prod = 0;
        for (int i = 0; i < size; i++) {
            prod = result[i]*n + carry;
            result[i] = prod % 10;
            carry = prod/10;
        }

        while (carry!=0){
            result[size] = carry % 10;
            carry = carry/10;
            size++;
        }
        return size;
    }

    @Test
    public void test_(){
        largeFix(100);
    }
}
