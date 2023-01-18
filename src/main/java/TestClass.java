import org.junit.jupiter.api.Test;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    // 509. Fibonacci Number
    public int fib(int n) {
        if(n==0)
            return 0;

        if(n==1)
            return 1;

        int prev1 = 1 , prev2= 0 , current = 0;

        for(int i = 2; i <= n ; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    @Test
    public void test(){
        System.out.println(
                fib(3)
        );
    }

}
