package arrays;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1399. Count Largest Group
 * */
public class CountLargestGroup {

    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxSize = 0;

        for(int i = 1 ; i <= n ; i++){
            int sumOfDigits = getSumOfDigits(i);
            List list = map.getOrDefault(sumOfDigits, new ArrayList<>());
            list.add(i);
            map.put(sumOfDigits,list);

            maxSize = Math.max(maxSize,list.size());
        }
        int count = 0;
        for(int key: map.keySet()){
            if (map.get(key).size() == maxSize)
                count++;
        }
        return count;
    }


    public int getSumOfDigits(int number){
        int result = 0;
        while (number > 0 ){
            result+=number%10;
            number = number/10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountLargestGroup().countLargestGroup(13));
    }
}
