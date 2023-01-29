package arrays;

import org.junit.Test;
import sorting.ArrayUtility;

import java.util.Arrays;
import java.util.Random;

/**
 * Select k random items from array
 * */
public class SelectRandomItems {

    public int[] selectKItems(int[] ints,int k){
        Random random = new Random();
        int length = ints.length;

        for (int i = 0; i < ints.length; i++) {
            int index = random.nextInt(length - i) + i ;
            swap(ints , i , index);
        }

        return Arrays.copyOfRange(ints,0,k);
    }

    private void swap(int[] ints , int s , int t){
        int temp = ints[s];
        ints[s] = ints[t];
        ints[t] = temp;
    }

    @Test
    public void test(){
        int[] ints = new int[50];
        for (int i = 0; i < 50 ; i++) {
            ints[i] = i + 1;
        }
        ArrayUtility.print(
                selectKItems(ints,20)
        );
    }
}
