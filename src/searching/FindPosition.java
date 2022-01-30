package searching;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author g1patil
 */
public class FindPosition {

    public int getPosition(List<Integer> list, int target){
        if (list.isEmpty())
            return -1;

        int low = 0 , high = list.size();

        while (low < high){
            int mid = (low + high)/2;

            if (list.get(mid)> target){
                high = mid;
            } else if (list.get(mid) < target){
                low = mid + 1;
            } else {
                return mid ;
            }
        }

        return high;

    }

    @Test
    public void test_(){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(10);
        list.add(12);

        System.out.println(getPosition(list , 9));
    }
}
