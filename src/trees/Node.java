package trees;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data

public class Node<T extends Comparable<T>> {
    private Node<T> leftChild;
    private Node<T> rightChild;
    @NonNull private T data;

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + data +
                '}';
    }
}
