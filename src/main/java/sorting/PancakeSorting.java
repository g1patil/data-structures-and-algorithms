package sorting;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 969. Pancake Sorting - my version
 * */
@Platform(Site.LEETCODE)
public class PancakeSorting {

    public List<Integer> pancakeSort(int[] arr) {
        int last = arr.length;
        List<Integer> result = new ArrayList<>();

        while(last > 1){
            int index = 0;
            index = getBiggestIndex(arr, last);

            if(index == last-1){
                last--;
                continue;
            }

            reverse(arr,0,index);
            result.add(index+1);

            reverse(arr,0,last-1);
            result.add(last);

            last--;
        }
        return result;
    }

    private int getBiggestIndex(int[] arr , int target){
        for(int i = 0; i < target; i++) {
            if( arr[i] == target)
                return i;
        }
        return -1;
    }
    public void reverse(int[] arr, int i , int j){
        while( i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    @Test
    public void test(){
        System.out.println(
                pancakeSort(
                        new int[]{3,2,4,1}
                )
        );
    }
}
