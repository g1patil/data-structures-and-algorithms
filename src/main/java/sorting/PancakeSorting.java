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
        int last = arr.length - 1;
        int biggestIndex = 0;
        List<Integer> result = new ArrayList<>();

        while( last >= 0 ){
            biggestIndex = getBiggestIndex(arr , last);
            if(biggestIndex != last && biggestIndex != 0){
                reverse(arr , 0 , biggestIndex);
                result.add(biggestIndex);
            }

            if(last != 0){
                reverse(arr , 0, last);
                result.add(last);
            }
            last--;
        }
        return result;
    }

    private int getBiggestIndex(int[] arr , int index){
        int max = Integer.MIN_VALUE;
        int result= 0;
        for(int i = 0; i <= index; i++) {
            if( arr[i] > max){
                max = arr[i];
                result = i;
            }
        }
        return result;
    }
    public void reverse(int[] arr, int i , int j){
        while( i <= j){
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
                        new int[]{5,3,4,2}
                )
        );
    }
}
