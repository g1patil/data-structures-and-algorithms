package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.Arrays;

/**
 * 2241. Design an ATM Machine
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ATM {

    private int[] values;
    private long[] count;

    public ATM() {
        values = new int[]{20,50,100,200,500};
        count = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < count.length; i++) {
            count[i]+=banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
       long[] result = new long[5];
       int p1 = 4;

        while(amount >0 && p1>=0 ) {
            long possible = Math.min(amount/values[p1],count[p1]);
            amount = (int) (amount - possible * values[p1]);
            result[p1--] = possible;
        }

        if (amount != 0) {
            return new int[]{-1};
        } else {
            for (int i = 0; i < 5; i++) {
                count[i] -= result[i];
            }
            return Arrays.stream(result).mapToInt(i -> (int) i).toArray();
        }
    }



    public static void main(String[] args){
        ATM obj = new ATM();
        obj.deposit(new int[]{0,0,1,2,1});
        obj.withdraw(600);
        obj.deposit(new int[]{0,1,0,1,1});
        obj.withdraw(600);
        obj.withdraw(550);

    }
}
