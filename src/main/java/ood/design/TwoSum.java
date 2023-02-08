package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 170. Two Sum III - Data structure design
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
class TwoSum {

    private final ArrayList<Integer> numbers;
    private boolean sorted;

    public TwoSum() {
        numbers = new ArrayList<>();
        sorted = false;
    }

    public void add(int number) {
        numbers.add(number);
    }

    public boolean find(int value) {
        int low = 0 , high = numbers.size()-1;
        if(!sorted){
            Collections.sort(numbers);
            sorted = true;
        }

        while(low<high){
            int sum = numbers.get(low) + numbers.get(high);
            if(sum > value){
                high--;
            } else if( sum < value){
                low++;
            } else return true;
        }
        return false;
    }

    @Test
    public void test(){
        TwoSum twoSum = new TwoSum();
        twoSum.add(0);
        System.out.println(
                twoSum.find(0)
        );
    }

}
