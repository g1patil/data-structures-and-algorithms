package lists;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * Given two list of numbers. Add the numbers in reverse order
 * 
 * 
*/
public class AddTwoNumber {

    private int addNumbers(java.util.List<Integer> l1, java.util.List<Integer> l2) {
        int sum1 = 0,sum2=0;

        Collections.reverse(l1);
        Collections.reverse(l2);

        for(int number : l1){
            sum1 = sum1*10 + number;
        }

        for(int number : l2){
            sum2 = sum2*10 + number;
        }

        return sum1 + sum2;
    }   
    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();

        l1.add(1);
        l1.add(2);
        l1.add(3);

        l2.add(1);
        l2.add(2);
        l2.add(3);

        System.out.println(new AddTwoNumber().addNumbers(l1, l2));
    }
    
}