package trees.heap;

import sorting.ArrayUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Implementation of the MeanHeap ds.
 * Reference : https://www.youtube.com/watch?v=t0Cq6tVNRBA
 *
 * TODO : refactor the code with better docs
 * */
public class MinHeap {

    private int[] ints ;
    private int size;

    private int CAPACITY = 10 ;

    public MinHeap(int[] ints_){
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
        if ( size == this.ints.length ){
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

        while ( hasParent(index) && getParent( index) > ints[index]){
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

    private int removeElement(){
        int smallest = this.ints[0];
        this.ints[0] = this.ints[size -1];
        size -- ;
        heapifyDown();
        return smallest;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(new int[]{25});
        minHeap.add( 50 );
        minHeap.add( 30 );
        minHeap.add( 1 );
        minHeap.add( 17 );
        minHeap.add( 10 );
        minHeap.add( 55 );
        minHeap.add( 60 );

        int[] output = new int[minHeap.size];
        for (int i = 0; i < output.length; i++) {
            output[i] = minHeap.removeElement(); ;
        }
        float[] floatsNumbers = new float[]{0.37f,0.79f,0.52f,0.21f};

        ArrayList<LinkedList<Float>> linkedListArrayList = new ArrayList<>(floatsNumbers.length);

        for (int i = 0; i < floatsNumbers.length; i++) {
            linkedListArrayList.add(new LinkedList<>());
        }
        for (int i = 0; i < floatsNumbers.length; i++) {
            linkedListArrayList.get((int) ( floatsNumbers.length * floatsNumbers[i])).add( floatsNumbers[i]);
        }
        linkedListArrayList.forEach( a-> Collections.sort(a));
        LinkedList<Float> floatLinkedList = new LinkedList<>();
        linkedListArrayList.forEach(a -> a.forEach( e-> {
            floatLinkedList.add( e );
        }));

        System.out.println( floatLinkedList );
    }


}
