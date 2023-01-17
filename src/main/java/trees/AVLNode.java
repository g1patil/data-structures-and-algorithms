package trees;

import lombok.Data;
import lombok.NonNull;

/**
 * @auther g1patil
 */
@Data
public class AVLNode<T extends Comparable<T>>{

    private int height;
    private AVLNode<T> leftChild;
    private AVLNode<T> rightChild;
    @NonNull private T data;

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + data +
                '}';
    }
}
