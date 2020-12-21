package arrays;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedArrays {

    @Test
    @Description("Happy path use case")
    public void testHappyPath(){
        Assert.assertArrayEquals(mergeArray(
                new int[]{1,2,3},new int[]{4,5,6}
        ),new int[]{1,2,3,4,5,6});
    }

    @Test
    @Description("First array in empty")
    public void testFirstArrayEmpty(){
        Assert.assertArrayEquals(mergeArray(
                new int[]{},new int[]{4,5,6}
        ),new int[]{4,5,6});
    }

    @Test
    @Description("Second array in empty")
    public void testSecondArrayEmpty(){
        Assert.assertArrayEquals(mergeArray(
                new int[]{1,2,3},new int[]{}
        ),new int[]{1,2,3});
    }

    @Test
    @Description("Both array are empty ")
    public void testBothArrayEmpty(){
        Assert.assertArrayEquals(mergeArray(
                new int[]{},new int[]{}
        ),new int[]{});
    }


    /**
     * @param first first integer input array param
     * @param second second integer input array param
     * @return int[] merged array
     * */
    int[] mergeArray(int[] first,int[] second){
        int newLength = first.length + second.length ;
        int[] result = new int[newLength];
        int p1=0,p2=0,p3=0;

        while ( p1 < first.length && p2 < second.length){
            if ( first[p1] < second[p2]){
                result[p3] = first[p1];
                p1++;
                p3++;
            } else {
                result[p3] = second[p2];
                p2++;
                p3++;
            }
        }

        while (p1 == first.length && p2 < second.length){
            result[p3] = second[p2];
            p2++;
            p3++;
        }
        while (p2 == second.length && p1 < first.length){
            result[p3] = first[p1];
                p1++;
                p3++;
        }
        return result;
    }

}
