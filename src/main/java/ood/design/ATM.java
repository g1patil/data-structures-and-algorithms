package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 2241. Design an ATM Machine
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ATM {

    private TreeMap<Integer,Long> count;
    private int[] values;

    public ATM() {
        count = new TreeMap<>(Comparator.reverseOrder());
        count.put(500,0L);
        count.put(200,0L);
        count.put(100,0L);
        count.put(50,0L);
        count.put(20,0L);

        values = new int[]{20,50,100,200,500};
    }

    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < banknotesCount.length; i++) {
            count.put( values[i] , count.get(values[i]) + banknotesCount[i] );
        }
    }

    private boolean isPossible(int amount){
        for(int value : count.keySet()){
            int neededCount = amount/value;
            long availableCount = Math.toIntExact(count.get(value));
            amount = (int) (amount - Math.min(neededCount,availableCount)*value);
        }
        return amount == 0;
    }

    public int[] withdraw(int amount) {
        if(isPossible(amount)){
            return withdrawAmount(amount);
        } else return new int[]{-1};
    }

    private int[] withdrawAmount(int amount){
        int[] result = new int[5];
        int p1 = result.length-1;
        for(int value : count.keySet()){
            int neededCount = amount/value;
            long availableCount = count.get(value);
            long withDrawal = Math.min(neededCount,availableCount)*value;
            amount = (int) (amount - withDrawal);
            if(withDrawal>0){
                result[p1] = (int) Math.min(neededCount,availableCount);
                count.put(value , count.get(value) - Math.min(neededCount,availableCount));
            }
            p1--;
        }
        return result;
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
