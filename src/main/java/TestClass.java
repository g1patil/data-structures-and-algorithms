import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    //1,5], [14, 17], [6,9], [10,13], [4,7], [8,12]
    @Test
    public void test(){
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,5});
        list.add(new int[]{14,17});
        list.add(new int[]{6,9});
        list.add(new int[]{10,13});
        list.add(new int[]{4,7});
        list.add(new int[]{8,12});

        sortIntervals(list).stream().forEach(
                a -> System.out.println("[" + a[0] + "," + a[1] + "]")
        );
    }

    private List<int[]> sortIntervals(List<int[]> list){
        list.sort((a,b)->a[0]-b[0]);
        return list;
    }
}
