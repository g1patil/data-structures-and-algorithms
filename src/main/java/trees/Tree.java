package trees;

/**
 * @author g1patil
 *
 * This is straight implementation of the BST using the YT channel Geekific
 * Reference : https://www.youtube.com/watch?v=zIX3zQP0khM
 */
public interface Tree<T extends Comparable<T>> {
    Tree<T> insert(T data);
    void delete(T data);
    void traverse();
    T getMax();
    T getMin();
    boolean isEmpty();
}
