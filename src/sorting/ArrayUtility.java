package sorting;
/**
 * @author g1patil
 *
 * Custom utility class to implement some array operations
 *
 * */
public class ArrayUtility {

    /**
     * Swaps the elements from the array, given the source and the target position
     * */
    public static void swap(int[] ints_ , int source , int target_){
        int temp = ints_[source];
        ints_[source] = ints_[target_];
        ints_[target_] = temp;
    }
}
