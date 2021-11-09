package trees.heap;

import org.junit.Test;
import sorting.ArrayUtility;

import java.util.Arrays;

/**
 * Implementation of the MeanHeap ds.
 * Reference : https://www.youtube.com/watch?v=t0Cq6tVNRBA
 * */
public class MinHeap {

    private int[] ints ;
    private int size;

    private int CAPACITY = 10 ;

    private MinHeap(int[] ints_){
        this.ints = ints_ ;
        this.size = this.ints.length ;
    }

    private int getParentIndex(final int index){
        return ( index -1 )/2;
    }
    private int getLeftChildIndex(final int index){
        return 2 * index + 1 ;
    }
    private int getRightChildIndex(final int index){
        return 2 * index + 2 ;
    }

    private boolean hasLeftChild(final int index){
        return getLeftChildIndex(index) < size ;
    }
    private boolean hasRightChild(final int index){
        return getRightChildIndex( index ) < size ;
    }
    private boolean hasParent(final int index){
        return getParentIndex( index ) >=0 ;
    }

    private int getLeftChild(final int index){
        return this.ints[ getLeftChildIndex( index )];
    }
    private int getRightChild(final int index){
        return this.ints[ getRightChildIndex( index)];
    }
    private int getParent(final int index){
        return this.ints [ getParentIndex(index)];
    }

    private void ensureCapacity(){
        if ( size == this.ints.length){
            this.ints = Arrays.copyOf( this.ints , CAPACITY * 2 );
            CAPACITY*= 2 ;
        }
    }

    private void add(final int element){
        ensureCapacity();
        this.ints[size] = element;
        size ++ ;
        heapifyUp();
    }

    private void heapifyUp(){
        int index = this.size - 1 ;

        while ( hasParent(index) && getParent( index) < ints[index]){
            ArrayUtility.swap( this.ints , getParentIndex(index), index);
            index = getParentIndex( index );
        }
    }

    private void heapifyDown(){
        int index = 0 ;

        while (hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex( index );

            if ( hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
                smallerChildIndex = getRightChildIndex( index );
            }

            if ( this.ints[index] < this.ints[smallerChildIndex]){
                break;
            } else {
                ArrayUtility.swap(this.ints , index , smallerChildIndex );
            }
            index = smallerChildIndex ;

        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(new int[]{50});
        minHeap.add( 100 );
    }


}
