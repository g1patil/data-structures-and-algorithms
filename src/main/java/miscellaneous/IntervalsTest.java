package miscellaneous;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IntervalsTest {

    Intervals intervals = new Intervals();

    @Test
    public void testBeginsFirst_BothAreEqual(){
        boolean result = intervals.beginsFirst(new Integer[]{10,100},new Integer[]{10,100});
    }


    @Test
    public void testMergeInterval_BothIntervalEmpty(){
        List<Integer[]> result = intervals.mergeIntervals(Collections.emptyList(),Collections.emptyList());
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testMergeInterval_FirstIntervalEmpty(){
        List<Integer[]> integerIntervals = new ArrayList<>();
        integerIntervals.add(new Integer[]{10,100});

        List<Integer[]> result = intervals.mergeIntervals(Collections.emptyList(),integerIntervals);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testMergeInterval_SecondIntervalEmpty(){
        List<Integer[]> integerIntervals = new ArrayList<>();
        integerIntervals.add(new Integer[]{10,100});

        List<Integer[]> result = intervals.mergeIntervals(integerIntervals,Collections.emptyList());
        Assertions.assertArrayEquals(result.get(0),integerIntervals.get(0));
    }

    @Test
    public void testMergeInterval_NullInterval(){

    }

    @Test
    public void test(){
        List<Integer[]> include = new ArrayList<>();
        include.add(new Integer[]{10,100});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{50,60});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);

        Assertions.assertArrayEquals(result.get(0),new Integer[]{10,49});
        Assertions.assertArrayEquals(result.get(1),new Integer[]{61,100});
    }

    @Test
    public void testTwo(){
        List<Integer[]> include = new ArrayList<>();
        include.add(new Integer[]{10,100});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{95,110});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertArrayEquals(result.get(0),new Integer[]{10,94});

    }

    @Test
    public void testThree(){
        List<Integer[]> include = new ArrayList<>();
        include.add(new Integer[]{10,100});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{5,50});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertArrayEquals(new Integer[]{51,100},result.get(0));

    }

    @Test
    public void testFour(){
        List<Integer[]> include = new ArrayList<>();
        include.add(new Integer[]{10,100});
        include.add(new Integer[]{200,300});
        include.add(new Integer[]{400,500});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{95,205});
        exclude.add(new Integer[]{410,420});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);

    }

    @Test
    public void testFive(){
        List<Integer[]> include = new ArrayList<>();
        include.add(new Integer[]{10,100});
        include.add(new Integer[]{200,300});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{95,205});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertArrayEquals(result.get(0),new Integer[]{10,94});
        Assertions.assertArrayEquals(result.get(1),new Integer[]{206,300});

    }

    @Test
    public void testMerge_BothIntervalSameSize(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{10,60});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{70,100});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertArrayEquals(result.get(0),include.get(0));

    }

    @Test
    public void testMerge_BothIntervalEqual(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{10,50});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{10,50});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertTrue(result.isEmpty());

    }

    @Test
    public void testMerge_SecondBeginsFirst(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{10,50});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{1,25});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertArrayEquals(result.get(0),new Integer[]{26,50});

    }

    @Test
    public void testMerge_SecondBeginsFirst_Two(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{50,100});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{1,25});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertArrayEquals(result.get(0),include.get(0));

    }

    @Test
    public void one(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{1,25});
        include.add(new Integer[]{50,100});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{50,100});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertArrayEquals(result.get(0),include.get(0));
        Assertions.assertEquals(result.size(),1);

    }

    @Test
    public void two(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{1,25});
        include.add(new Integer[]{50,100});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{1,25});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertArrayEquals(result.get(0),include.get(0));
        Assertions.assertEquals(result.size(),1);

    }

    @Test
    public void three(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{1,100});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{2,99});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertArrayEquals(result.get(0),new Integer[]{1,1});
        Assertions.assertArrayEquals(result.get(1),new Integer[]{100,100});
        Assertions.assertEquals(result.size(),2);

    }

    @Test
    public void four(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{1,100});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{1,10});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertArrayEquals(result.get(0),new Integer[]{11,100});
        Assertions.assertEquals(result.size(),1);

    }

    @Test
    public void five(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{20,40});
        include.add(new Integer[]{60,80});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{1,100});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertEquals(2, result.size());

    }

    @Test
    public void six(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{20,40});
        include.add(new Integer[]{60,80});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{100,120});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertEquals(result.size(),2);

    }

    @Test
    public void testMergeIntervals_NoneOverlapping_ONE(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{20,40});
        include.add(new Integer[]{60,80});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{1,10});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertEquals(result.size(),2);

    }

    @Test
    public void eight(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{20,40});
        include.add(new Integer[]{60});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{1,10});
        Assertions.assertThrows(InvalidInputException.class , ()->intervals.mergeIntervals(include,exclude));

    }

    @Test
    public void testMergeIntervals_NoneOverlapping_IncludeOverlapping(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{1,100});
        include.add(new Integer[]{25,50});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{200,300});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertEquals(1,result.size());
        Assertions.assertArrayEquals(new Integer[]{1,100},result.get(0));
    }

    //negative
    @Test
    public void testMergeIntervals_NoneOverlapping(){
        List<Integer[]> include = new LinkedList<>();
        include.add(new Integer[]{-100,10});

        List<Integer[]> exclude = new ArrayList<>();
        exclude.add(new Integer[]{50,100});

        List<Integer[]> result = intervals.mergeIntervals(include,exclude);
        Assertions.assertEquals(1,result.size());
        Assertions.assertArrayEquals(include.get(0),result.get(0));
    }
}
