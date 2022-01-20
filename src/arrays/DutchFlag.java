package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.Arrays;

/**
 * @author g1patil
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class DutchFlag {
    public static void sort(int[] ints){
        int p1 = 0;
        int p2 = ints.length -1 ;

        int i = 0;
        int j = ints.length - 1;

        while(i < ints.length){

            if(ints[i] < 1 ){
                int temp = ints[i];
                ints[i] = ints[p1];
                ints[p1] = temp;
                p1++;
            }
            i++;

        }

        while (j >=0 ){
            if(ints[j] > 1){
                int temp = ints[j];
                ints[j] = ints[p2];
                ints[p2] = temp;
                p2--;
            }
            j--;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1,0,1,0,2,0,5,0,7};
        sort(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
