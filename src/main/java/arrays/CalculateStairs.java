package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class CalculateStairs {
    static int getSum(int input){
        if(input == 0 || input == 1){
            return 1;
        }

        if(input == 2){
            return 2;
        }

        return getSum(input-2) + getSum(input-1);
    }
    public static void main(String[] args) {
        System.out.println(getSum(10));
    }
}