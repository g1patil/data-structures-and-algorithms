package arrays;

import org.junit.Test;
import sorting.ArrayUtility;

import java.util.Arrays;

/**
 * 1054. Distant Barcodes
 * */
public class DistantBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] result = new int[barcodes.length];
        Arrays.sort(barcodes);

        int p1 = 0 , p2 = barcodes.length-1 , p3 = 0;

        for (int i = 0; i < barcodes.length/2; i++) {
            result[p3++] = barcodes[p1++];
            result[p3++] = barcodes[p2--];
        }

        return result;
    }

    @Test
    public void test(){
        ArrayUtility.print(
                rearrangeBarcodes(
                        new int[]{1,1,1,2,2,2}
                )
        );
    }
}
