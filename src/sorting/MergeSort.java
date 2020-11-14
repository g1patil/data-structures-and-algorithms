package sorting;

import java.util.Arrays;

/**
 * Algorithm for merge sort
 * 
 * 
*/
public class MergeSort {

    int[] mergeArray(int[] first,int[] second){
        int newLength  = first.length + second.length;
        int[] result = new int[newLength];

        int p1=0,p2=0;

        for(int i = 0; i < newLength ; i++){
                
            if(p1 < first.length && p2 < second.length){
                if (first[p1]< second[p2]){
                    result[i] = first[p1];
                    p1++;
                    continue;
                } else {
                    result[i] = second[p2];
                    p2++;
                    continue;
                }
            }
            
        }

        return result;
    }
    
    int[] mergeSort(int[] input){

        if(input.length == 1){
            return input;
        }

        int[] left = Arrays.copyOfRange(input, 0, (input.length+1)/2);
        int[] right = Arrays.copyOfRange(input,  (input.length+1)/2, input.length);

        int[] l = mergeSort(left);
        int[] r = mergeSort(right);

       return mergeArray(l,r);
    }
    public static void main(String[] args) {
        MergeSort mg = new MergeSort();

        System.out.println(mg.mergeSort(new int[]{10,5,1,7}));
    }
}