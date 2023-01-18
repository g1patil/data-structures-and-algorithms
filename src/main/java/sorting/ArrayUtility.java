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

    public static void print(int[] ints_ ){
        for (int i : ints_)
            System.out.print(i + "   ");
    }

    public static void print(char[] chars){
        for (char i : chars)
            System.out.print(i + "   ");
    }

    public static void print(int[][] ints_ ){
        for (int i = 0; i < ints_.length; i++) {
            for (int j = 0; j < ints_[0].length; j++) {
                System.out.print(ints_[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
