package sorting;

import java.util.Arrays;

/**
 * Algorithm for merge sort
 * 
 * 
*/
public class MergeSort {

    /***
     * Sorts the array using the merge sort algo.
     * First split the array in two sub arrays ,
     * call the merge sort on them , and merge the sorted array
     * @param input int array
     */
    int[] mergeSort(int[] input){

        if(input.length == 1){
            return input;
        }
        int mid = input.length/2;

        int[] left = Arrays.copyOfRange(input, 0,  mid );
        int[] right = Arrays.copyOfRange(input,   mid , input.length );

        left = mergeSort(left);
        right = mergeSort(right);

        return mergeArray(left , right );
    }

    /**
     * @param l left array
     * @param r right array
     * */
    private int[] mergeArray(int[] l, int[] r) {
        int newLength = l.length + r.length;
        int[] result = new int[newLength];
        int i=0,j=0,k=0;

        while ( k < newLength && i < l.length && j < r.length){
            if ( l[i] < r[j] ){
                result[k] = l[i];
                k++;
                i++;
            } else {
                result[k] = r[j];
                k++;
                j++;
            }
        }

        while ( i < l.length){
            result[k] = l[i];
            i++;
            k++;
        }

        while ( j < r.length){
            result[k] = r[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort mg = new MergeSort();

        for( int i : mg.mergeSort(new int[]{5,9,2,4,10,7,1,3}) ){
            System.out.println( i );
        }
    }
}