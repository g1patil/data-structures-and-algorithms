package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int num = n;
        while ( num != 1 && !set.contains(num)){
            set.add(num);
            num = getSum(num);
        }
        return num == 1;
    }

    private int getSum(int number){
        int sum = 0;
        while ( number !=0){
            int digit = number % 10;
            sum+=digit*digit;
            number/=10;
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(
                isHappy(19)
        );
    }
}
