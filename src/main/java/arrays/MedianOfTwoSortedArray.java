package arrays;


/**
 * 4. Median of Two Sorted Arrays
 * Hard
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *
 * */
public class MedianOfTwoSortedArray {

    double getMedian(final int[] ints){
        int length = ints.length;

        if (length == 0){
            return 0;
        }

        if(length ==1){
            return ints[0];
        }
        if(length%2==1){
            return ints[ length/2];
        } else {
            return (double) ( ints[ length/2 -1 ] + ints[ length/2 ] )/2;
        }
    }

    public double findMedianSortedArrays(final int[] ints, final int[] ints2){
        if (ints.length == 0 || ints2.length ==0){
            return ( getMedian(ints) + getMedian(ints2) ) ;
        }
        return ( getMedian(ints) + getMedian(ints2) )/2 ;
    }

    public static void main(String[] args) {
        System.out.println(
                new MedianOfTwoSortedArray().findMedianSortedArrays(
                        new int[]{1,3}, new int[]{2,7})
        );
    }
}
