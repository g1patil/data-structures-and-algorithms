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

        while(i <= p2 ){

            if(ints[i] == 0 ){

                ints[i] = ints[p1];
                ints[p1] = 0;
                p1++;
            }

            if(ints[i] == 2){

                ints[i] = ints[p2];
                ints[p2] = 2;
                p2--;
                i--;
            }

            i++;

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
