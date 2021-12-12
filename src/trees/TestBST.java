package trees;

import org.junit.jupiter.api.Test;

/**
 * @auther g1patil
 */
public class TestBST {

    @Test
    public void test_(){
        BinarySearchTree<Integer> integerTree = new BinarySearchTree<>();
        integerTree.insert(5);
        integerTree.insert(2);
        integerTree.insert(1);
        integerTree.insert(3);
        integerTree.insert(7);
        integerTree.traverse();

        integerTree.delete(2);
    }
}
