package sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PancakeSortingV2 {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length, i; x > 0; --x) {
            for (i = 0; A[i] != x; ++i);{
                reverse(A, i + 1);
                res.add(i + 1);
            }

            reverse(A, x);
            res.add(x);
        }
        return res;
    }

    public void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
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
